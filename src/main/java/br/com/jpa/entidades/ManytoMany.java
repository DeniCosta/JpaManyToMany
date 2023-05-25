package br.com.jpa.entidades;

import java.util.List;
import java.util.Scanner;

public class ManytoMany {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		Controller controller = Controller.getInstance();

		while (continuar) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Classe");
			System.out.println("2 - Cadastrar Professor");
			System.out.println("3 - Atribuir Classe a um Professor");
			System.out.println("4 - Editar Professor");
			System.out.println("5 - Listar todas as Classes");
			System.out.println("0 - Sair");

			int opcao = scanner.nextInt();

			switch (opcao) {

			case 1:
				// Opção 1 - Cadastrar classe
				scanner.nextLine();
				System.out.println("Digite o nome da classe:");
				String nomeClasse = scanner.nextLine();

				Classe novaClasse = new Classe();
				novaClasse.setNome(nomeClasse);

				// Chama o método do controller para cadastrar a classe
				controller.cadastrarClasse(novaClasse);

				System.out.println("Classe cadastrada com sucesso!");
				break;

			case 2:
				// Opção 2 - Cadastrar Professor
				scanner.nextLine(); //
				System.out.println("Digite o nome do professor:");
				String nomeProfessor = scanner.nextLine();

				System.out.println("Digite o assunto do professor:");
				String assuntoProfessor = scanner.nextLine();

				Professor novoProfessor = new Professor();
				novoProfessor.setNome(nomeProfessor);
				novoProfessor.setAssunto(assuntoProfessor);

				// Chame o método do controller para cadastrar o professor
				controller.cadastrarProfessor(novoProfessor);

				System.out.println("Professor cadastrado com sucesso!");
				break;

			case 3:
				// Opção 3 - atribuir classe
				scanner.nextLine(); // Limpa o buffer do scanner
				// Exibir lista de todos os registros de professores
				List<Professor> professores = controller.listarTodosOsProfessores();
				System.out.println("Professores registrados:");
				for (Professor professor : professores) {
					System.out.println("ID: " + professor.getId() + ", Nome: " + professor.getNome());
				}
				// Solicita o id do professor
				System.out.println("Digite o ID do professor:");
				Long idProfessor = scanner.nextLong();
				scanner.nextLine(); // Limpa o buffer do scanner

				// Exibir lista de todos os registros de classes
				List<Classe> classes = controller.listarTodasAsClasses();
				System.out.println("Classes registradas:");
				for (Classe classe : classes) {
					System.out.println("ID: " + classe.getId() + ", Nome: " + classe.getNome());
				}
				// Solicita o id da classe
				System.out.println("Digite o ID da classe:");
				Long idClasse = scanner.nextLong();

				// Chame o método do controller para atribuir a classe ao professor
				controller.atribuirClasse(idProfessor, idClasse);

				System.out.println("Classe atribuída ao professor com sucesso!");
				break;
			case 4:
				// Opção 4 - Editar Professor
				scanner.nextLine(); // Limpa o buffer do scanner
				System.out.println("Digite o ID do professor que deseja editar:");
				Long idProfessorEditar = scanner.nextLong();
				scanner.nextLine(); // Consumir a quebra de linha pendente

				System.out.println("Digite o novo nome do professor:");
				String novoNome = scanner.nextLine();

				System.out.println("Digite o novo assunto do professor:");
				String novoAssunto = scanner.nextLine();

				Professor professorEditado = controller.editarProfessor(idProfessorEditar, novoNome, novoAssunto);

				if (professorEditado != null) {
					System.out.println("Professor editado com sucesso!");
				} else {
					System.out.println("Professor não encontrado.");
				}
				break;
			case 5:
				// Opção 5 - Listar todas as Classes

				List<Classe> todasAsClasses = controller.listarTodasAsClasses();
				if (todasAsClasses.isEmpty()) {
					System.out.println("Nenhuma classe encontrada.");
				} else {
					System.out.println("Classes registradas:");
					for (Classe classe : todasAsClasses) {
						System.out.println("ID: " + classe.getId() + ", Nome: " + classe.getNome());
					}
				}
				break;
			case 0:
				// Opção 0 - Sair
				continuar = false;
				System.out.println("Sessão encerrada!");
				break;

			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				break;
			}
		}

		scanner.close();
	}

}
