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
            System.out.println("6 - Excluir Professor");
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
                // Lógica para editar um professor existente
                break;

            case 5:
                // Opção 5 - Listar todas as Classes
                // Lógica para listar todas as classes existentes
            	// O método já está pronto...só precisa fazer a lógica aqui
                break;

            case 6:
                // Opção 6 - Excluir Professor
                // Lógica para excluir um professor existente
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
