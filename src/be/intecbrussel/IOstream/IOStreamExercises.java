package be.intecbrussel.IOstream;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOStreamExercises {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/seunghokang/Downloads/folder/text.txt"); //direct to path
        file.setWritable(true);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            //direct to the path
            fileWriter.write("Don't make me angry");
            fileWriter.write("You are a scammer");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(file)) {
            int character;
            while ((character = fileReader.read()) != -1) { //while the characters in sentence is present (i.e. more than 0)
                System.out.println((char) character); //typecasting in int to character
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Since we are creating a new file we have to set a new pathway
        Path pathOfFile = Path.of("/Users/seunghokang/Downloads/folder/Text.txt");

        try (FileWriter fileWriter = new FileWriter("/Users/seunghokang/Downloads/folder/Text.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write("Hello\n");
            bufferedWriter.write("World!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(BufferedReader bufferedReader = Files.newBufferedReader(pathOfFile)) {
            String line;
            while ((line= bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException ex) {
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
    }
}