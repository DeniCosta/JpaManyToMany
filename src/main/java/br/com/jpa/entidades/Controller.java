package br.com.jpa.entidades;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {
	private static Controller instance;
	private Logger logger;

	private Controller() {
		logger = Logger.getLogger("MeuLogger");
		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler("ArquivosLogger/Logtext.txt", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	public void cadastrarClasse(Classe classe) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	    EntityManager em = emf.createEntityManager();

	    try {
	        em.getTransaction().begin();

	        // Insere a classe no banco de dados
	        em.persist(classe);

	        em.getTransaction().commit();
	        logger.log(Level.INFO, "Classe cadastrada com sucesso!");
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }

	        logger.log(Level.SEVERE, "Erro ao cadastrar classe:", e);
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }
	}


	public void cadastrarProfessor(Professor professor) {
	    try {
	        //Persistência usando JPA/Hibernate
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();

	        // Insere o professor no banco de dados
	        em.persist(professor);

	        em.getTransaction().commit();
	        logger.log(Level.INFO, "Professor cadastrado com sucesso!");
	        
	        em.close();
	        emf.close();
	    } catch (Exception e) {
	        logger.log(Level.SEVERE, "Erro ao cadastrar professor:", e);
	        e.printStackTrace();
	    }
	}

	public void editarProfessor() {
		try {
			// Lógica para editar um professor existente
			logger.log(Level.INFO, "Professor editado com sucesso!");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao editar professor:", e);
			e.printStackTrace();
		}
	}

	public void listarTodasAsClasses() {
		try {
			// Lógica para listar todas as classes existentes
			logger.log(Level.INFO, "Listagem de todas as classes realizada com sucesso!");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao listar todas as classes:", e);
			e.printStackTrace();
		}
	}

	public void excluirClasse() {
		try {
			// Lógica para excluir uma classe existente
			logger.log(Level.INFO, "Classe excluída com sucesso!");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao excluir classe:", e);
			e.printStackTrace();
		}
	}

	public void excluirProfessor() {
		try {
			// Lógica para excluir um professor existente
			logger.log(Level.INFO, "Professor excluído com sucesso!");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao excluir professor:", e);
			e.printStackTrace();
		}
	}
}
