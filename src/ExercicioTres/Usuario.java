package ExercicioTres;

public class Usuario {
    private String email;
    private String password;

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean verificarSenha(String senha) {
        return this.password.equals(senha);
    }

    public String toDatabase() {
        String usuarioProBanco = "";

        usuarioProBanco += this.email + ";";
        usuarioProBanco += this.password + ";";

        return usuarioProBanco;
    }

    public static Usuario fromDatabase(String usuarioNoBanco) {
        String[] segmentosDoUsuario = usuarioNoBanco.split(";");

        Usuario usuario = new Usuario(
            segmentosDoUsuario[0],
            segmentosDoUsuario[1]
        );

        return usuario;
    }

    @Override
    public String toString() {
        String usuarioComoString = "";

        usuarioComoString += "{";
        usuarioComoString += " \"email\": " + "\"" + this.email + "\",";
        usuarioComoString += " \"password\": " + "\"" + this.password + "\"";
        usuarioComoString += " }";

        return usuarioComoString;
    }
}
