package br.com.jpa.entidades;

import java.util.Scanner;

public class ManytoMany {

    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Classe");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Editar Professor");
            System.out.println("4 - Listar todas as Classes");
            System.out.println("5 - Excluir Classe");
            System.out.println("6 - Excluir Professor");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Opção 1 - Cadastrar Classe
                    
                    break;

                case 2:
                    // Opção 2 - Cadastrar Professor
                    
                    break;

                case 3:
                    // Opção 3 - Editar Professor
                   
                    break;

                case 4:
                    // Opção 4 - Listar todas as Classes
                    
                    break;

                case 5:
                    // Opção 5 - Excluir Classe
                    
                    break;

                case 6:
                    // Opção 6 - Excluir Professor
                    
                    break;

                case 0:
                    // Opção 0 - Sair
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }

}
