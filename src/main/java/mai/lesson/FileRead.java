package mai.lesson;

import java.io.File;
import java.net.URL;
import java.net.URI;

public class FileRead {

    public String test(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        String inputStream = classLoader.getResource(".").getPath() + filename;
        File file = new File(inputStream);
        if(!file.exists()) {
            return "No file!";
        }

        return inputStream;
    }

}
