import java.io.*;
import java.time.LocalDateTime;

public class ExemploJavaIo {
    public static void main(String[] args) {
        File file = new File("/Users/angeloevangelista/Desktop/nomes.txt");

//        System.out.println("Eh um diretorio: " + file.isDirectory());
//        System.out.println("Eh um arquivo: " + file.isFile());
//        System.out.println("O path existe: " + file.exists());

//        try (FileWriter fileWriter = new FileWriter(file, true)) {
//            fileWriter.write(LocalDateTime.now() + " - Angelo\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(LocalDateTime.now() + " - Angelo from buffered\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

//            while (fileReader.ready()) {
//                char letra = (char)(fileReader.read());
//
//                System.out.print(letra);
//            }

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}