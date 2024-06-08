package model.service;

import model.entities.EnderecoViaCep;
import model.entities.EnderecosEntity;
import model.entities.PacientesEntity;
import model.repositories.EnderecosRepository;
import model.repositories.PacienteViaCepRepository;

import java.util.Scanner;

public class EnderecosService {
    private Scanner sc = new Scanner(System.in);
    EnderecosRepository enderecosRepository = new EnderecosRepository();
    PacienteViaCepRepository pacienteViaCepRepository = new PacienteViaCepRepository();


    public void addEnderecoBD(EnderecosEntity entity){enderecosRepository.create(entity);}

    public EnderecosEntity criarEndereco(PacientesEntity entity, String cep, String numeroCasa) {

        EnderecoViaCep enderecoViaCep = pacienteViaCepRepository.findEndereco(cep);

        if (enderecoViaCep != null) {
            EnderecosEntity endereco = new EnderecosEntity(
                    null,
                    enderecoViaCep.getCep(),
                    enderecoViaCep.getLogradouro(),
                    numeroCasa,
                    enderecoViaCep.getBairro(),
                    entity
            );
            enderecosRepository.create(endereco);
            return endereco;
        } else {
            System.out.println("Endereço não encontrado para o CEP fornecido.");
            return null;
        }
    }



}
