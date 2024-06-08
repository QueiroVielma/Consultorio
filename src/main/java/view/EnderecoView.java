package view;

import model.entities.EnderecosEntity;

import java.util.Scanner;

public class EnderecoView {
    public EnderecosEntity cadEndereco(){

        Scanner scanner = new Scanner(System.in);
        EnderecosEntity novoEndereco=new EnderecosEntity();

        System.out.println("Informe o CEP:");
        novoEndereco.setCep(scanner.nextLine());

        System.out.println("Informe o número:");
        novoEndereco.setNumero(scanner.nextLine());

        return novoEndereco;

    }
}
