package view;

import controller.MedicamentosController;
import controller.PacienteController;
import model.entities.MedicamentosEntity;
import model.entities.PacientesEntity;

import java.util.Scanner;

public class MedicamentosView {

    PacientesView pacientesView = new PacientesView();
    PacienteController pacienteController= new PacienteController();
    MedicamentosController medicamentosController= new MedicamentosController();
    Scanner scanner= new Scanner(System.in);


    public void cadastrarMedicamento(){

        MedicamentosEntity novoMedicamento = new MedicamentosEntity();

        System.out.println("Digite o nome do medicamento:");
        novoMedicamento.setNome(scanner.nextLine());

        System.out.println("Digite a descrição do medicamento:");
        novoMedicamento.setDescricao(scanner.nextLine());

        medicamentosController.salvarMedicamento(novoMedicamento);
    }


    public void asociarPaciente(){

        boolean validarid= false;
        Long usuarioId;
        long medicamentoId;
        do {
            pacientesView.allPacientes();
            System.out.println("Informe o ID do usuário que deseja agregar um medicamento:");
            usuarioId = Long.parseLong(scanner.nextLine());
            for(PacientesEntity x : pacienteController.findAll()) {
                if (usuarioId == x.getId()){
                    validarid=true;
                }
            }
        }while (!validarid);
        validarid=false;
        do {
            allMedicamentos();
            System.out.println("Informe o ID do medicamento:");
            medicamentoId = Long.parseLong(scanner.nextLine());
            for(MedicamentosEntity x : medicamentosController.findAll()) {
                if (medicamentoId == x.getId()){
                    validarid=true;
                }
            }
        }while (!validarid);

        medicamentosController.medicamentoPaciente (usuarioId, medicamentoId);
    }

    public void allMedicamentos() {
        for(MedicamentosEntity x : medicamentosController.findAll()) {
            System.out.println("ID:"+x.getId()+" - Nome: "+x.getNome());
        }
    }


}
