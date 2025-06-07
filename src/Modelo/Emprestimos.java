package Modelo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import Repositorio.BibliotecaRepositorio;

public class Emprestimos {
    static class RegistroEmprestimo {
        String cpfUsuario;
        String tituloLivro;

        RegistroEmprestimo(String cpfUsuario, String tituloLivro) {
            this.cpfUsuario = cpfUsuario;
            this.tituloLivro = tituloLivro;
        }
    }

    // Lista para guardar o histórico de todos os empréstimos realizados
    public static ArrayList<RegistroEmprestimo> historicoEmprestimos = new ArrayList<>();

    // Lista de livros emprestados atualmente
    public static ArrayList<RegistroEmprestimo> emprestimosAtuais = new ArrayList<>();

    // FUNÇÃO PARA REALIZAR EMPRÉSTIMO
    public static void realizarEmprestimo(Scanner scanner) {
        Map<String, Livros> livros = BibliotecaRepositorio.getLivros();
        System.out.print("Informe o CPF do usuário: ");
        String cpf = scanner.nextLine();
        boolean usuarioExiste = false;
        for (Usuario usuario : Usuario.listaUsuarios) {
            if (usuario.getCPF().equals(cpf)) {
                usuarioExiste = true;
                break;
            }
        }

        if (!usuarioExiste) {
            System.out.println("Usuário não encontrado. Empréstimo cancelado.");
            return;
        }
        System.out.print("Informe o título do livro: ");
        String titulo = scanner.nextLine();

        for (Livros livro : BibliotecaRepositorio.getLivros().values()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.getQtd() > 1) {
                    livro.setQtd(livro.getQtd() - 1);
                    RegistroEmprestimo registro = new RegistroEmprestimo(cpf, titulo);
                    emprestimosAtuais.add(registro);
                    historicoEmprestimos.add(registro);
                    System.out.println("Empréstimo realizado com sucesso!");
                    return;
                } else {
                    System.out.println("Não é possível realizar o empréstimo. Apenas um exemplar disponível.");
                    return;
                }
            }
        }

        System.out.println("Livro não encontrado.");
    }

    // FUNÇÃO PARA REGISTRAR DEVOLUÇÃO
    	public static void registrarDevolucao(Scanner scanner, Map<String, Livros> livros) {
        System.out.print("Informe o CPF do usuário: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o título do livro: ");
        String titulo = scanner.nextLine();

        for (int i = 0; i < emprestimosAtuais.size(); i++) {
            RegistroEmprestimo reg = emprestimosAtuais.get(i);
            if (reg.cpfUsuario.equals(cpf) && reg.tituloLivro.equalsIgnoreCase(titulo)) {
                emprestimosAtuais.remove(i);

                for (Livros livro : BibliotecaRepositorio.getLivros().values()) {
                    if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                        livro.setQtd(livro.getQtd() + 1);
                        break;
                    }
                }


                System.out.println("Devolução registrada com sucesso!");
                return;
            }
        }
        System.out.println("Empréstimo não encontrado.");
    }

    // FUNÇÃO PARA LISTAR TODOS OS LIVROS EMPRESTADOS
    public static void listarLivrosEmprestados() {
        if (emprestimosAtuais.isEmpty()) {
            System.out.println("Nenhum livro está emprestado no momento.");
            return;
        }

        System.out.println("\nLivros atualmente emprestados:");
        for (RegistroEmprestimo reg : emprestimosAtuais) {
            System.out.println("Título: " + reg.tituloLivro + " | CPF do usuário: " + reg.cpfUsuario);
        }
    }

    // FUNÇÃO PARA VERIFICAR QUAIS LIVROS ESTÃO DISPONÍVEIS

    public static void listarLivrosDisponiveis(Map<String, Livros> livros) {
        System.out.println("\nLivros disponíveis na biblioteca:");
        for (Livros livro : BibliotecaRepositorio.getLivros().values()) {
            if (livro.getQtd() > 0) {
                System.out.println("Título: " + livro.getTitulo() + " | Quantidade: " + livro.getQtd());
            }
        }
    }

    // FUNÇÃO PARA MOSTRAR HISTÓRICO DE EMPRÉSTIMOS
    public static void mostrarHistoricoEmprestimos() {
        if (historicoEmprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo foi realizado ainda.");
            return;
        }

        System.out.println("\nHistórico de empréstimos:");
        for (RegistroEmprestimo reg : historicoEmprestimos) {
            System.out.println("Título: " + reg.tituloLivro + " | CPF do usuário: " + reg.cpfUsuario);
        }
    }
}