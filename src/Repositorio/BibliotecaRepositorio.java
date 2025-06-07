package Repositorio;

import java.util.ArrayList;
import java.util.List;
import Modelo.Emprestimos;
import Modelo.Livros;
import Modelo.Usuario;


public class BibliotecaRepositorio {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Livros> listaLivros = new ArrayList<>();
    private static List<Emprestimos> emprestimos = new ArrayList<>();
    private static List<Emprestimos> historicoEmprestimos = new ArrayList<>();

    
    
    public static List<Livros> getLivros() {	
        return listaLivros;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static List<Emprestimos> getEmprestimos() {
        return emprestimos;
    }

    public static List<Emprestimos> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }
}
