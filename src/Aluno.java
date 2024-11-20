import java.util.List;

public class Aluno {
    public String email;
    public String password;

    public Aluno(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String converterParaBanco() {
        String usuarioConvertido = "";

        usuarioConvertido += this.email;
        usuarioConvertido += ";";
        usuarioConvertido += this.password;

        return usuarioConvertido;
    }

    public static Aluno converterDoBanco(String alunoDobanco) {
        String[] segmentosDoAluno = alunoDobanco.split(";");

        Aluno aluno = new Aluno(
                segmentosDoAluno[0],
                segmentosDoAluno[1]
        );

        return aluno;
    }
}
