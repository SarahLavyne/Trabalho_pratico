import java.util.ArrayList;
import java.util.Scanner;
public class Usuario {
	private String Nome;
	private String Email;
	private String CPF;
	
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);
	
public Usuario(String Nome, String Email, String CPF) {
	this.Nome = Nome;
	this.Email = Email;
	this.CPF = CPF;
}
	public void setNome(String Nome) {this.Nome = Nome;}
	public void setEmail(String Email) {this.Email = Email;}
	public void setCPF(String CPF) {this.CPF = CPF;}
	
	public String getNome() { return this.Nome; }
	public String getEmail() { return this.Email; }
	public String getCPF() { return this.CPF; }

	
//FUNÇÃO DE CADASTRAR USUÁRIO
	public static void cadastrarUsuario(Scanner scanner) {
	    System.out.print("Nome: ");
	    String nome = scanner.nextLine();
	    System.out.print("Email: ");
	    String email = scanner.nextLine();
	    System.out.print("CPF: ");
	    String cpf = scanner.nextLine();
	    
	    Usuario novoUsuario = new Usuario(nome, email, cpf);
	    listaUsuarios.add(novoUsuario);
	    
	    System.out.println("Usuário cadastrado com sucesso!");
	}
//FUNÇÃO PARA PROCURAR COM CPF
	public static void consultarPorCpf(Scanner scanner) {
	    System.out.print("Informe o CPF: ");
	    String cpf = scanner.nextLine();
	    
	    for (Usuario u : listaUsuarios) {
	        if (u.getCPF().equals(cpf)) {
	            System.out.println("Nome: " + u.getNome());
	            System.out.println("Email: " + u.getEmail());
	            System.out.println("CPF: " + u.getCPF());
	            return;
	        }
	    }
	    System.out.println("Usuário não encontrado.");
	}
	
//FUNÇÃO PARA LISTAR USUARIO
	public static void listarUsuarios() {
	    if (listaUsuarios.isEmpty()) {
	        System.out.println("Nenhum usuário cadastrado.");
	        return;
	    }
	    
	    for (Usuario u : listaUsuarios) {
	        System.out.println("Nome: " + u.getNome() + ", Email: " + u.getEmail() + ", CPF: " + u.getCPF());
	    }
	}

//FUNÇÃO PARA EXCLUIR USUARIO
	public static void removerUsuario(Scanner scanner) {
	    System.out.print("Informe o CPF do usuário a remover: ");
	    String cpf = scanner.nextLine();
	    
	    for (Usuario u : listaUsuarios) {
	        if (u.getCPF().equals(cpf)) {
	            listaUsuarios.remove(u);
	            System.out.println("Usuário removido com sucesso!");
	            return;
	        }
	    }
	    System.out.println("Usuário não encontrado.");
	}
}
