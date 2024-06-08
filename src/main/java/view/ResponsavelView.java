package view;

import model.entities.ResponsaveisEntity;

import java.util.Scanner;

public class ResponsavelView {

    Scanner scanner = new Scanner(System.in);
    public ResponsaveisEntity cadResponsavel(){

        ResponsaveisEntity novoResponsavel = new ResponsaveisEntity();
        System.out.println("Cadastro de Novo Responsável");
        System.out.println("Digite o nome do responsável:");
        novoResponsavel.setNome(scanner.nextLine());

        System.out.println("Digite o parentesco com o paciente:");
        novoResponsavel.setParentesco(scanner.nextLine());

        System.out.println("Digite o contato do responsável:");
        novoResponsavel.setContato(scanner.nextLine());

        System.out.println("Digite o email do responsável:");
        novoResponsavel.setEmail(scanner.nextLine());

        return novoResponsavel;

    }
}
