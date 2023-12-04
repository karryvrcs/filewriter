import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        File file = new File("text.txt");
        File outputFile = new File("output.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
             PrintWriter writer = new PrintWriter(bufferedWriter)){ //// 使用"output.txt"作为输出

            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null){
                String[] strArray = line.split(",");
                for (String item : strArray){
                    writer.printf("%-9s", item);
                }
                writer.println();
                count++;
                if (count % 5 == 0){
                    Thread.sleep(2000);
                    writer.flush(); // Physical writes now
                    System.out.println(".");
                }
            }


            // For writing files, there's temporary storage, that gets filled up as writes are executed on a writer class.
            // Physical writes to disk happen when the buffer is flused.
            // auto flsuh is false by default.
            // the buffer is always flushed when a file is closed.
            // you can manually flush a buffer, by calling the flush method.

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}