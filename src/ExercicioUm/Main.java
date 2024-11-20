package ExercicioUm;

public class Main {
    public static void main(String[] args) {
        SorteadorDeNomes sorteador = new SorteadorDeNomes(
            "Angelo",
            "Anna",
            "Lucas",
            "Fernanda",
            "Bruno"
        );

        System.out.printf("Nome sorteado: %s\n", sorteador.sortear());
    }
}
