package ReadingWritingDemo;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingWritingDemo {
    public static void main(String[] args) throws IOException {
        Path pathOfFile = Paths.get("/Users/seunghokang"); //relative folder
        Path pathOfFile1 = pathOfFile.resolve("Downloads");
        Path pathOfFile2 = pathOfFile1.resolve("BoardingCard_242049092_CRL_WAW.pdf");

        System.out.println(pathOfFile2); //absolute path printing

        Path pathOfFile3 = Paths.get("BoardingCard_242049093_CRL_WAW.pdf");
        System.out.println(pathOfFile3.toAbsolutePath()); //printing absolute path

        Path path = Path.of("\\Users\\seunghokang\\Downloads\\BoardingCard_242049093_CRL_WAW.pdf");
        Path path1 = Paths.get("\\Users\\seunghokang\\Downloads\\BoardingCard_242049092_CRL_WAW.pdf");
        Path path2 = path.relativize(path1);
        System.out.println(path2);

        System.out.println(path.getRoot()); // output root directory
        System.out.println(path.getFileName()); //output fileName
        System.out.println(path.getParent()); // parent directory
        for (Path p: path) {
            System.out.println(p); //files that are in that directory listing all the directory
        }

        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem.getSeparator());
        for (Path p: fileSystem.getRootDirectories()) {
            System.out.println(p); //files that are in that directory listing all the directory
        }
    }
}
