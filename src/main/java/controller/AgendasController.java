package controller;

import model.entities.AgendasEntity;
import model.entities.PacientesEntity;
import model.service.AgendasService;

import java.util.List;

public class AgendasController {

    AgendasService agendasService= new AgendasService();

    public void agendar(AgendasEntity agenda, Long idPaciente){agendasService.createAgendamento(agenda, idPaciente);}

    public void deletarAgenda (Long id){ agendasService.deleteAgendamento(id);}


    public List <AgendasEntity> findAll() {return agendasService.findAll();}

    public void fazerProntuario(Long id, String prontario) {agendasService.fazerProntuario(id, prontario);}
}
