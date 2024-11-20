public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Angelo", "1234");

        System.out.println(aluno.converterParaBanco());

        Aluno aluno2 = Aluno.converterDoBanco("Anna;918348");

        System.out.println(aluno2.email);
        System.out.println(aluno2.password);
    }
}
