package ReadingWritingDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingWrtiing {
    public static void main(String[] args) {
        /*String sentence ="hello\\";
        System.out.println(sentence);*/

        Path path = Path.of("/Users/seunghokang/Downloads/ForestNotebook-master/ReadingWwritingDemo/src/test.txt");
        Path pathOfDirectory = path.getParent();

/*        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
        System.out.println(pathOfDirectory.getParent());
        System.out.println(pathOfDirectory.getFileSystem());*/

        System.out.println(Files.notExists(pathOfDirectory));
        System.out.println(Files.notExists(path));


        try {
            if (Files.notExists(pathOfDirectory))
                Files.createDirectories(pathOfDirectory);
            else System.out.println("Directory already exist");

            if (Files.notExists(path))
                Files.createDirectories(path);
            System.out.println(Files.deleteIfExists(path));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
