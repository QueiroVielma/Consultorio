package model.service;

import controller.AgendasController;
import model.entities.AgendasEntity;
import model.entities.PacientesEntity;
import model.repositories.AgendasRepository;
import model.repositories.PacientesRepository;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AgendasService {

    PacientesRepository pacientesRepository= new PacientesRepository();
    AgendasRepository agendasRepository= new AgendasRepository();
    public Object criarAgendamento (AgendasEntity agenda, Long idPaciente){
        return null;
    }

    public void createAgendamento(AgendasEntity entity, Long idPaciente ) {
        // Recupera todos os agendamentos existente
        List<AgendasEntity> agendamentos = agendasRepository.findAll();
        PacientesEntity paciente = (PacientesEntity) pacientesRepository.findById(idPaciente);

        boolean existeNoMesmoHorario = false;
        for (AgendasEntity agendamento : agendamentos) {
            if (agendamento.getAgendamento().equals(entity.getAgendamento())) {
                existeNoMesmoHorario = true;
                break;
            }
        }

        if (!existeNoMesmoHorario) {
            entity.setPacientes(paciente);
            agendasRepository.create(entity);
            paciente.getAgendas().add(entity);
        } else {
            throw new RuntimeException("Já existe um agendamento para esse hoarario: " + entity.getAgendamento());
        }
    }

    public void deleteAgendamento(Long id) {agendasRepository.delete(id);}

    public void fazerProntuario(Long id, String prontuario) {
        AgendasEntity agendamento = (AgendasEntity) agendasRepository.findById(id);
        agendamento.setProntuario(prontuario);
        agendasRepository.update(agendamento);

    }

    public List<AgendasEntity> findAll(){return agendasRepository.findAll();}
    
    public AgendasEntity upDate(AgendasEntity agenda){return (AgendasEntity) agendasRepository.update(agenda);}
    
    public AgendasEntity finById(Long id) {return (AgendasEntity) agendasRepository.findById(id);}

    public List<AgendasEntity> agendasPendentes(){return agendasRepository.agendasPendentes();}
    
    public List<AgendasEntity> prontuariosFeitos(){return agendasRepository.prontuariosFeitos();}
    
    public List<AgendasEntity> agendamentosProximos(){return agendasRepository.agendamentosProximos();}

}
