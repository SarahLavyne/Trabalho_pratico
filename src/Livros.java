
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
	public void settitulo(String Titulo) {this.Titulo = Titulo;}
	public void setautor(String Autor) {this.Autor = Autor;}
	public void seteditora(String Editora) {this.Editora = Editora;}
	public void setSerie(int ISBN) {this.ISBN = ISBN;}
	public void setTurma(int Qtd) {this.Qtd = Qtd;}
	public void setAno(int Ano) {this.Ano = Ano;}
	
}