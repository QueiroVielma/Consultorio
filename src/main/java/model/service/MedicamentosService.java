package model.service;

import model.entities.MedicamentosEntity;
import model.entities.PacientesEntity;
import model.repositories.MedicamentosRepository;
import model.repositories.PacientesRepository;

import java.util.List;

public class MedicamentosService {

    MedicamentosRepository medicamentosRepository= new MedicamentosRepository();
    PacientesRepository pacientesRepository = new PacientesRepository();

    public void salvarMedicamento(MedicamentosEntity medicamento) {
        medicamentosRepository.create(medicamento);
    }

    public List<MedicamentosEntity> findAll() {return medicamentosRepository.findAll();    }

    public void crirMedicamentoPaciente(Long usuarioId, Long medicamentoId) {
        PacientesEntity paciente = (PacientesEntity) pacientesRepository.findById(usuarioId);
        MedicamentosEntity medicamento = (MedicamentosEntity) medicamentosRepository.findById(medicamentoId);

        if (paciente != null && medicamento != null) {
            // Adiciona o medicamento ao paciente
            paciente.getMedicamentos().add(medicamento);
            // Adiciona o paciente ao medicamento
            medicamento.getPessoas().add(paciente);

            // Atualiza o estado do paciente e do medicamento no banco de dados
            pacientesRepository.update(paciente);
            medicamentosRepository.update(medicamento);
        } else {
            System.out.println("Paciente ou Medicamento não encontrado!");
        }

    }
}
