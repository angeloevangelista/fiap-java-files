import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.LocalDateTime;
import java.util.List;

public class ExemploJavaNio {
    public static void main(String[] args) {
//        Path path = Paths.get("file.txt");

        Path path = Path.of("./files.txt");

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            Files.writeString(
                path,
                LocalDateTime.now()+ "\n",
                StandardOpenOption.APPEND
            );

//            String todoConteudo = Files.readString(path);
//
//            System.out.println("Todo o conteudo:");
//            System.out.println(todoConteudo);

            List<String> linhas = Files.readAllLines(path);

            System.out.println("Todas as linhas:");

            for (String linha : linhas) {
                System.out.println(linha);
            }

//            Files.delete(path);
            Files.copy(
                path,
                Path.of(path.toString() + ".bak"), //  ./files.txt + / + .bak
                StandardCopyOption.REPLACE_EXISTING
            );

            Files.move(
                    Path.of(path.toString() + ".bak"),
                    Path.of("backup-movido.txt"),
                    StandardCopyOption.ATOMIC_MOVE
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Eh um path absoluto: %s\n", path.isAbsolute());
        System.out.printf("Path existe: %s\n", Files.exists(path));

        System.out.println("Disretórios na Home:");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of("/Users/angeloevangelista"))) {
            for (Path directory: directoryStream) {
                String tipo = Files.isHidden(directory) ? "oculto" : "visivel";

                System.out.println(" - " + directory + " (" + tipo + ")");
            }

            System.out.println(Files.isRegularFile(Path.of("/Users/angeloevangelista/.vscode")));

            BasicFileAttributes atributos = Files.readAttributes(
                    Path.of("/Users/angeloevangelista/Desktop"),
                    BasicFileAttributes.class
            );

            System.out.println("Data de modificacao: " + atributos.lastModifiedTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
