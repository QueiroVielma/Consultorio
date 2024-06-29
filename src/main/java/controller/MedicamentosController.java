package controller;

import model.entities.MedicamentosEntity;
import model.entities.PacientesEntity;
import model.service.MedicamentosService;

import java.util.List;
import java.util.Scanner;

public class MedicamentosController {

    MedicamentosService medicamentosService= new MedicamentosService();

    public void salvarMedicamento(MedicamentosEntity medicamento){medicamentosService.salvarMedicamento(medicamento);}

    public List<MedicamentosEntity> findAll(){ return medicamentosService.findAll();}

    public void medicamentoPaciente(Long usuarioId, Long medicamentoId) {medicamentosService.crirMedicamentoPaciente( usuarioId, medicamentoId);    }
    
    public MedicamentosEntity finById (Long id){return medicamentosService.findById(id);}
    
    public void deletarAgenda (Long id){ medicamentosService.deletemedicamento(id);}
}
