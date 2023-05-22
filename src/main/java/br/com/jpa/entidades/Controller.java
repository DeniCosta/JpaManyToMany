package br.com.jpa.entidades;

import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public List<Professor> listarTodosOsProfessores() {
	    // Lógica para listar todos os registros de professores existentes

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	    EntityManager em = emf.createEntityManager();

	    List<Professor> professores = null;

	    try {
	        em.getTransaction().begin();

	        // Recupere todos os registros de professores do banco de dados
	        TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p", Professor.class);
	        professores = query.getResultList();

	        em.getTransaction().commit();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }

	        logger.log(Level.SEVERE, "Erro ao listar professores:", e);
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }

	    return professores;
	}

	public List<Classe> listarTodasAsClasses() {
	    // Lógica para listar todas as classes existentes

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	    EntityManager em = emf.createEntityManager();

	    List<Classe> classes = null;

	    try {
	        em.getTransaction().begin();

	        // Recupere todas as classes do banco de dados
	        TypedQuery<Classe> query = em.createQuery("SELECT c FROM Classe c", Classe.class);
	        classes = query.getResultList();

	        em.getTransaction().commit();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }

	        logger.log(Level.SEVERE, "Erro ao listar classes:", e);
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }

	    return classes;
	}
	
	public void atribuirClasse(Long idProfessor, Long idClasse) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
	    EntityManager em = emf.createEntityManager();

	    try {
	        em.getTransaction().begin();

	        // Recuperar o professor pelo ID
	        Professor professor = em.find(Professor.class, idProfessor);

	        // Recuperar a classe pelo ID
	        Classe classe = em.find(Classe.class, idClasse);

	        // Verificar se professor e classe existem
	        if (professor != null && classe != null) {
	            // Adicionar a classe ao conjunto de classes do professor
	            List<Classe> classesDoProfessor = professor.getClasseSet();
	            classesDoProfessor.add(classe);
	            professor.setClasseSet(classesDoProfessor);
	            em.merge(professor);

	            // Atualizar o conjunto de professores da classe
	            List<Professor> professoresDaClasse = classe.getProfessorSet();
	            professoresDaClasse.add(professor);
	            classe.setProfessorSet(professoresDaClasse);
	            em.merge(classe);

	            em.getTransaction().commit();
	            logger.log(Level.INFO, "Classe atribuída ao professor com sucesso!");
	        } else {
	            logger.log(Level.WARNING, "Professor ou classe não encontrados. Atribuição não realizada.");
	        }
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }

	        logger.log(Level.SEVERE, "Erro ao atribuir classe ao professor:", e);
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
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
