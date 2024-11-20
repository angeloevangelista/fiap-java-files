package ExercicioTres;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("Suas opções:");
            System.out.println("  0. Sair");
            System.out.println("  1. Logar");
            System.out.println("  2. Criar usuário");

            System.out.print("O que você deseja fazer? ");
            escolha = myScanner.nextInt();
            myScanner.nextLine(); // lembre de 'consumir' a quebra de linha (Enter) depois de ler um 'int'

            switch (escolha) {
                case 0: {
                    break;
                }
                case 1: {
                    logar(myScanner);
                    break;
                }
                case 2: {
                    criarUsuario(myScanner);
                    break;
                }
                default: {
                    System.out.println("Hey! Tinha '" + escolha + "' nas opções?");
                }
            }
        } while (escolha != 0);

        myScanner.close();
    }

    public static void criarUsuario(Scanner scanner) {
        System.out.print("Informe o e-mail: ");
        String emailInput = scanner.next(); // Não precisa ser nextLine, e-mail não tem espaço, né?

        TabelaUsuarios tabelaUsuarios = new TabelaUsuarios();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario:tabelaUsuarios.listar()) {
            if (usuario.getEmail().equalsIgnoreCase(emailInput)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            System.out.println("Oops! E-mail já cadastrado :/");
            return;
        }

        System.out.print("Informe a senha: ");
        String senhaInput = scanner.next();

        System.out.print("Confirme a senha: ");
        String confirmacaoSenhaInput = scanner.next();

        if (!senhaInput.equals(confirmacaoSenhaInput)) {
            System.out.println("Confia em mim, você gostaria de conseguir digitar essa senha 2 vezes em sequencia :)");
            return;
        }

        Usuario usuario = new Usuario(emailInput, senhaInput);

        tabelaUsuarios.inserir(usuario);

        System.out.println("Usuário cadastrado!");
    }

    public static void logar(Scanner scanner) {
        System.out.print("Informe o e-mail: ");
        String emailInput = scanner.next();

        System.out.print("Informe a senha: ");
        String senhaInput = scanner.next();

        TabelaUsuarios tabelaUsuarios = new TabelaUsuarios();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario:tabelaUsuarios.listar()) {
            if (!usuario.getEmail().equalsIgnoreCase(emailInput)) {
                continue;
            }

            if (!usuario.verificarSenha(senhaInput)) {
                continue;
            }

            usuarioEncontrado = usuario;
        }

        if (usuarioEncontrado == null) {
            System.out.println("E-mail ou senha incorretos, amigão :/");
            return;
        }

        System.out.printf("Logado: %s\n", usuarioEncontrado);
    }
}
