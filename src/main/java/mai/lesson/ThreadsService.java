package mai.lesson;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsService {

    public void StartService() {

        Runnable task1 = () -> {
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 10; i < 16; i++) {
                System.out.println(i);
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }

    public void Enumerate() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int value = i;
            executorService.submit(() -> System.out.println(value));
        }

    }

}
