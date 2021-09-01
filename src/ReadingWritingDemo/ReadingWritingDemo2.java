package ReadingWritingDemo;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ReadingWritingDemo2 {

    public static void main(String[] args) throws IOException {
        try {
            //define path
            Path pathToFile = Paths.get("/Users/seunghokang/Downloads/folder/Test.txt");
            //create parent directories
            Files.createDirectories(pathToFile.getParent());
            //Create if not exists
            if (Files.notExists(pathToFile)) {
                Files.createFile(pathToFile);
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }

            //write lines of text t files
            List<String> lines = new ArrayList<>();
            lines.add("Hello");
            lines.add("world");
            Files.write(pathToFile, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            //Retrieve attributes of file
            DosFileAttributes attributes = Files.readAttributes(pathToFile, DosFileAttributes.class); //fix the permission issue

            System.out.println(attributes.size());
            System.out.println(attributes.creationTime());
            System.out.println(attributes.lastAccessTime());
            System.out.println(attributes.lastModifiedTime());
            System.out.println(attributes.isArchive());
            System.out.println(attributes.isHidden());
            System.out.println(attributes.isReadOnly());

            //Read lines of text from file
            Files.lines(pathToFile).forEach(System.out::println);

            //copy file
            Path pathToFile2 = Paths.get("\"\\\\Users\\\\seunghokang\\\\Downloads\\\\BoardingCard_242049093_CRL_WAW_copy.pdf\"");

            //delete file
            Files.deleteIfExists(pathToFile2);
        } catch (IIOException e) {
            e.printStackTrace();
        }

    }
}
