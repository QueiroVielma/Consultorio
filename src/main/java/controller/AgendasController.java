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
    
    public AgendasEntity finById (Long id){return agendasService.finById(id);}
    
    public AgendasEntity upDate(AgendasEntity agenda){return (AgendasEntity) agendasService.upDate(agenda);}
    
    public List<AgendasEntity> agendasPendentes(){return agendasService.agendasPendentes();}
    
    public List<AgendasEntity> prontuariosFeitos(){return agendasService.prontuariosFeitos();}
    
    public List<AgendasEntity> agendamentosProximos(){return agendasService.agendamentosProximos();}
}
