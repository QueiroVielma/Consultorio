package controller;

import model.entities.EnderecosEntity;
import model.entities.PacientesEntity;
import model.service.PacienteService;

import java.util.List;

public class PacienteController {
    PacienteService pacienteService = new PacienteService();
    public void criarPaciente (PacientesEntity paciente, EnderecosEntity enderecos){ pacienteService.criarPacienteComEndereco(paciente, enderecos); }

    public List<PacientesEntity> findAll(){return pacienteService.findAll();}

    public PacientesEntity finById (Long id){return pacienteService.finById(id);}
}
