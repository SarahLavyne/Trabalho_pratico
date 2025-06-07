package Modelo;
import java.util.ArrayList;

import java.util.Scanner;
import Repositorio.BibliotecaRepositorio;

public class Livros {
	private String Titulo;
	private String Autor;
	private String Editora;
	private int ISBN;
	private int Qtd;
	private int Ano;
	
    public static Scanner scanner = new Scanner(System.in);
   
public Livros(String Titulo, String Autor, String Editora, int ISBN, int Qtd, int Ano ) {
	this.Titulo = Titulo;
	this.Autor = Autor;
	this.Editora = Editora;
	this.ISBN = ISBN;
	this.Qtd = Qtd;
	this.Ano = Ano;
}
	public void setTitulo(String Titulo) {this.Titulo = Titulo;}
	public void setAutor(String Autor) {this.Autor = Autor;}
	public void setEditora(String Editora) {this.Editora = Editora;}
	public void setISBN(int ISBN) {this.ISBN = ISBN;}
	public void setQtd(int Qtd) {this.Qtd = Qtd;}
	public void setAno(int Ano) {this.Ano = Ano;}
	
	public String getTitulo() { return Titulo; }
    public String getAutor() { return Autor; }
    public String getEditora() { return Editora; }
    public int getISBN() { return ISBN; }
    public int getQtd() { return Qtd; }
    public int getAno() { return Ano; }

// FUNÇÃO PARA CADASTRAR OS LIVROS
public static Livros cadastrarLivro(Scanner scanner) {
	
	System.out.println("Digite o título:");
	String titulo = scanner.nextLine();
	
	System.out.println("Digite o autor:");
	String autor = scanner.nextLine();
	
	System.out.println("Digite a editora:");
	String editora = scanner.nextLine();
	
	System.out.println("Digite o ISBN:");
	int isbn = scanner.nextInt();
	
	System.out.println("Digite a quantidade:");
	int qtd = scanner.nextInt();
	
	System.out.println("Digite o ano:");
	int ano = scanner.nextInt();
	scanner.nextLine();
	
	System.out.println("Livro cadastrado com sucesso!");
	return new Livros(titulo, autor, editora, isbn, qtd, ano);
    }

//FUNÇÃO PARA PROCURAR POR ISBN
public static void buscarPorISBN(Scanner scanner) {
    if (BibliotecaRepositorio.getLivros().isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }

    System.out.println("Digite o ISBN do livro que deseja buscar:");
    int isbnBuscado = scanner.nextInt();
    scanner.nextLine();

    boolean encontrado = false;
    for (Livros livro : BibliotecaRepositorio.getLivros()) {
        if (livro.getISBN() == isbnBuscado) {
            System.out.println("Livro encontrado:");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Quantidade: " + livro.getQtd());
            System.out.println("Ano: " + livro.getAno());
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        System.out.println("Livro com ISBN " + isbnBuscado + " não encontrado.");
    }
}

//FUNÇÃO PARA LISTAR OS LIVROS
public static void listarLivros() {
    if (BibliotecaRepositorio.getLivros().isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }
    System.out.println("Lista de livros cadastrados:");
    for (Livros livro : BibliotecaRepositorio.getLivros()) {
        System.out.println("---------------------------");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("ISBN: " + livro.getISBN());
        System.out.println("Quantidade: " + livro.getQtd());
        System.out.println("Ano: " + livro.getAno());
    }
}
//FUNÇÃO REMOVER LIVROS POR ISBN
public static void removerLivro() {
    if (BibliotecaRepositorio.getLivros().isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }

    System.out.println("Digite o ISBN do livro que deseja remover:");
    int isbnRemover = scanner.nextInt();
    scanner.nextLine();

    boolean removido = false;
    for (int i = 0; i < BibliotecaRepositorio.getLivros().size(); i++) {
        if (BibliotecaRepositorio.getLivros().get(i).getISBN() == isbnRemover) {
        	BibliotecaRepositorio.getLivros().remove(i);
            System.out.println("Livro removido com sucesso.");
            removido = true;
            break;
        }
    }
    if (!removido) {
        System.out.println("Livro com ISBN " + isbnRemover + " não encontrado.");
    }
}


//FUNÇÃO PARA BUSCAR POR AUTOR
public static void listarPorAutor() {
    if (BibliotecaRepositorio.getLivros().isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }

    System.out.println("Digite o nome do autor para buscar:");
    String autorBusca = scanner.nextLine().trim();

    boolean encontrado = false;
    for (Livros livro : BibliotecaRepositorio.getLivros()) {
        if (livro.getAutor().equalsIgnoreCase(autorBusca)) {
            if (!encontrado) {
                System.out.println("Livros do autor \"" + autorBusca + "\":");
            }
            System.out.println("---------------------------");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("ISBN: " + livro.getISBN());
            System.out.println("Quantidade: " + livro.getQtd());
            System.out.println("Ano: " + livro.getAno());
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("Nenhum livro encontrado para o autor \"" + autorBusca + "\".");
    }
}

}