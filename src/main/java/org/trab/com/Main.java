package org.trab.com;


import view.AdministrarOpcoesMain;

import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministrarOpcoesMain administrarOpcoesMain = new AdministrarOpcoesMain();
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Administrar Pacientes");
            System.out.println("2. Administrar atendimentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    administrarOpcoesMain.administrarPacientes();
                    break;
                case 2:
                    administrarOpcoesMain.administrarAgendamentos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:

                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();


    }
}
