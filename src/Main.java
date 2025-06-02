import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sistemaEscolhido;

        do {
            System.out.println("=== Sistema de Biblioteca ===");
            System.out.println("1 - Gerenciar Livros");
            System.out.println("2 - Gerenciar Usuários");
            System.out.println("3 - Gerenciar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            sistemaEscolhido = scanner.nextInt();
            scanner.nextLine();

            switch (sistemaEscolhido) {
                case 1:
                    menuLivros(scanner);
                    break;
                case 2:
                    menuUsuarios(scanner);
                    break;
                case 3:
                    menuEmprestimos(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (sistemaEscolhido != 0);

        scanner.close();
    }


 // Menu de operações com Livros
    public static void menuLivros(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Livros ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Consultar por ISBN");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Remover livro");
            System.out.println("5 - Buscar livro por autor");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Livros novoLivro = Livros.cadastrarLivro();
                    Livros.listaLivros.add(novoLivro); 
                    break;
                case 2:
                    Livros.buscarPorISBN();
                    break;
                case 3:
                    Livros.listarLivros();
                    break;
                case 4:
                    Livros.removerLivro();
                    break;
                case 5:
                    Livros.listarPorAutor();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }


    // Aqui será o menu dos métodos para usuários 
    public static void menuUsuarios(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Usuários ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Consultar por CPF");
            System.out.println("3 - Listar todos os usuários");
            System.out.println("4 - Remover usuário");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            
            switch (opcao) {
                case 1:
                    // cadastrarUsuario();
                    break;
                case 2:
                    // consultarPorCpf();
                    break;
                case 3:
                    // listarUsuarios();
                    break;
                case 4:
                    // removerUsuario();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    /// Aqui será o menu dos métodos para emprestimo 
    public static void menuEmprestimos(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Empréstimos ===");
            System.out.println("1 - Emprestar livro");
            System.out.println("2 - Registrar devolução");
            System.out.println("3 - Listar livros emprestados");
            System.out.println("4 - Verificar livros disponíveis");
            System.out.println("5 - Guardar histórico de empréstimo");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            
            switch (opcao) {
                case 1:
                    // emprestarLivro();
                    break;
                case 2:
                    // registrarDevolucao();
                    break;
                case 3:
                    // listarLivrosEmprestados();
                    break;
                case 4:
                    // verificarLivrosDisponiveis();
                    break;
                case 5:
                    // guardarHistoricoEmprestimo();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
