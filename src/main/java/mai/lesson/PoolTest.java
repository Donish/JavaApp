package mai.lesson;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class PoolTest {

    public void execute(String inputFilename, String outputFilename) {

        if (inputFilename == null) {
            throw new RuntimeException("inputFilename must not be null");
        }
        if (outputFilename == null) {
            throw new RuntimeException("outputFilename must not be null");
        }

        String inputFileName = getClass().getClassLoader().getResource(".").getPath() + inputFilename;
        String outputFileName = getClass().getClassLoader().getResource(".").getPath() + outputFilename;

        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new RuntimeException("inputFilename does not exist");
        }

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
        List<Future<String>> futures = new ArrayList<>();
        long fileSize = inputFile.length();

        for (long bytesRead = 0; bytesRead < fileSize; bytesRead += 7) {
            long finalBytesRead = bytesRead;
            futures.add(executorService.submit(() -> threadTask(inputFileName, outputFilename, finalBytesRead)));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException("Service was interrupted");
        }

        List<String> res = futures
                .stream()
                .filter(Future::isDone)
                .map(listFuture -> {
                    try {
                        return listFuture.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName))) {

            for(String element : res) {
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String threadTask(String inputFilename, String outputFilename, long offset) throws IOException {

        String result;

        try (RandomAccessFile file = new RandomAccessFile(inputFilename, "r")) {
            file.seek(offset);
            System.out.println(file.getFilePointer());
            int bytesRead = 0;
            long fileSize = file.length();
            result = file.readLine();
        }

        return result;
    }

}
