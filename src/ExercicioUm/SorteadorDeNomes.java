package ExercicioUm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class SorteadorDeNomes {
    private final List<String> nomes;
    private final static String caminhoDoLog = "nomes.log";

    public SorteadorDeNomes(String... nomes) {
        /*
        * Você pode considerar o spread (String...) como uma lista, dá até usar num 'for', tente depois:
        *
        *   for (String nome: nomes) {
        *       System.out.println(nome);
        *   }
        * */

        if (nomes.length == 0) {
            throw new RuntimeException("Ooops! Pelo menos 1 nome, amigão :D");
        }

        this.nomes = List.of(nomes);
    }

    public String sortear() {
        int indexAleatorio = (int)(Math.random() * this.nomes.size());

        String nomeSorteado = this.nomes.get(indexAleatorio);

        this.registrarLog(nomeSorteado);

        return nomeSorteado;
    }

    public void registrarLog(String nomeSorteado) {
        try {
            File arquivoDeLog = new File(caminhoDoLog);

            if (!arquivoDeLog.exists()) {
                arquivoDeLog.createNewFile();
            }

            // a gente não quer reescrever o arquivo inteiro, só adicionar linhas novas lá :)
            FileWriter fileWriter = new FileWriter(arquivoDeLog, true); // lembra do 'append'

            fileWriter.write("[" + LocalDateTime.now() + "] | " + nomeSorteado + "\n");

            fileWriter.close();
        } catch (IOException e) {
            System.out.printf("Falha ao persistir o log: %s\n", e);
        }
    }
}
