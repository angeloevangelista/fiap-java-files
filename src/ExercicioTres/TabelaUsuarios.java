package ExercicioTres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TabelaUsuarios {
    private final String nomeArquivoDaTabela = "usuarios.txt";

    public TabelaUsuarios() {
        // Vamos criar o arquivo, caso não exista ainda
        try {
            Path pathDaTabela = Path.of(this.nomeArquivoDaTabela);

            if (!Files.exists(pathDaTabela)) {
                Files.createFile(pathDaTabela);
            }
        } catch (IOException e) {
            throw new RuntimeException(e); // Se não deu pra criar, nem vale continuar :(
        }
    }

    public void inserir(Usuario usuario) {
        try {
            Files.writeString(
                Path.of(this.nomeArquivoDaTabela),
                usuario.toDatabase() + "\n",
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> listar() {
        List<String> usuariosNoBanco;

        try {
            usuariosNoBanco = Files.readAllLines(Path.of(this.nomeArquivoDaTabela));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Usuario> usuarios = new ArrayList<>();

        for (String usuarioNoBanco: usuariosNoBanco) {
            usuarios.add(Usuario.fromDatabase(usuarioNoBanco));
        }

        return usuarios;
    }
}
