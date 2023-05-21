package br.com.jpa.entidades;

import java.util.List;

public class Controller {

    private static Controller instance;
    private List<Classe> classes;
    private List<Professor> professores;

    private Controller() {
        // Inicialize as listas de classes e professores
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void cadastrarClasse() {
        // Lógica para cadastrar uma nova classe
    }

    public void cadastrarProfessor() {
        // Lógica para cadastrar um novo professor
    }

    public void editarProfessor() {
        // Lógica para editar um professor existente
    }

    public void listarTodasAsClasses() {
        // Lógica para listar todas as classes existentes
    }

    public void excluirClasse() {
        // Lógica para excluir uma classe existente
    }

    public void excluirProfessor() {
        // Lógica para excluir um professor existente
    }
}
