package model.service;

import model.entities.EnderecosEntity;
import model.entities.PacientesEntity;
import model.entities.ResponsaveisEntity;
import model.repositories.PacientesRepository;

import java.util.List;

public class PacienteService {

    PacientesRepository pacientesRepository= new PacientesRepository();
    EnderecosService enderecosService= new EnderecosService();

    public void addPacienteBD(PacientesEntity entity){pacientesRepository.create(entity);}

    public void criarPacienteComEndereco(PacientesEntity paciente, EnderecosEntity enderecos) {
        ResponsaveisEntity responsavel = paciente.getResponsavel();
        ResponsavelService responsavelService = new ResponsavelService();

        if (responsavel != null) {
            ResponsaveisEntity responsavelEmBD = responsavelService.criarResponsavel(responsavel, paciente);
            paciente.setResponsavel(responsavelEmBD);
        }

        pacientesRepository.merge(paciente);
        System.out.println("depois de pegar o cep");

        EnderecosEntity enderecoCEP = enderecosService.criarEndereco(paciente, enderecos.getCep(), enderecos.getNumero());

        if (enderecoCEP != null) {
            paciente.getEnderecos().add(enderecoCEP);
            enderecoCEP.setPaciente(paciente);

            pacientesRepository.merge(paciente);
        } else {
            System.out.println("Erro ao criar cliente. Cliente não foi salvo!");
        }
    }

    public boolean updateCliente(PacientesEntity entity){
        PacientesEntity clienteUp = (PacientesEntity) pacientesRepository.findById(entity.getId());
        if (clienteUp == null){
            return false;
        }

        clienteUp.setEmail(entity.getEmail());
        clienteUp.setEnderecos(entity.getEnderecos());
        clienteUp.setContato(entity.getContato());
        clienteUp.setContatoEmergencia(entity.getContatoEmergencia());

        pacientesRepository .update(clienteUp);
        return true;

    }
    public List<PacientesEntity> findAll(){return pacientesRepository.findAll();}

    public PacientesEntity finById(Long id) {return (PacientesEntity) pacientesRepository.findById(id);}
}
