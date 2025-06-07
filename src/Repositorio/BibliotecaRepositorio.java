package Repositorio;

import java.util.HashMap;
import java.util.Map;
import Modelo.Emprestimos;
import Modelo.Livros;
import Modelo.Usuario;

public class BibliotecaRepositorio {
    
    
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static Map<String, Livros> listaLivros = new HashMap<>();
    private static Map<String, Emprestimos> emprestimos = new HashMap<>();
    private static Map<String, Emprestimos> historicoEmprestimos = new HashMap<>();

    // Getters
    public static Map<String, Livros> getLivros() {
        return listaLivros;
    }

    public static Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public static Map<String, Emprestimos> getEmprestimos() {
        return emprestimos;
    }

    public static Map<String, Emprestimos> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }
}
