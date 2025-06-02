import java.util.Scanner;
public class Livros {
	private String Titulo;
	private String Autor;
	private String Editora;
	private int ISBN;
	private int Qtd;
	private int Ano;

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
	public void setSerie(int ISBN) {this.ISBN = ISBN;}
	public void setTurma(int Qtd) {this.Qtd = Qtd;}
	public void setAno(int Ano) {this.Ano = Ano;}
	
	public String getTitulo() { return Titulo; }
    public String getAutor() { return Autor; }
    public String getEditora() { return Editora; }
    public int getISBN() { return ISBN; }
    public int getQtd() { return Qtd; }
    public int getAno() { return Ano; }

// FUNÇÃO PARA CADASTRAR OS LIVROS
public static Livros cadastrarLivro() {
	Scanner scanner = new Scanner(System.in);
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

//FUNÇÃO PARA LISTAR OS LIVROS

//FUNÇÃO REMOVER LIVROS

//FUNÇÃO PARA BUSCAR POR AUTOR
}