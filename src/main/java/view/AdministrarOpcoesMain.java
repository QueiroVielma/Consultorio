package view;

import model.entities.AgendasEntity;
import model.entities.EnderecosEntity;

import java.security.PublicKey;
import java.util.Scanner;

public class AdministrarOpcoesMain {
    Scanner scanner = new Scanner(System.in);
    PacientesView pacientesView= new PacientesView();
    MedicamentosView medicamentosView= new MedicamentosView();
    AgendasView agendasView= new AgendasView();
    public void administrarPacientes() {
        int opcao;
        do {
            System.out.println("\nAdministrar Pacientes");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Visualizar Paciente");
            System.out.println("3. Visualizar Todos os Pacientes");
            System.out.println("4. Administrar Atendimentos");
            System.out.println("5. Cadastrar medicamento");
            System.out.println("6. Adicionar medicamento para Paciente");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    pacientesView.salvarPacientes();
                    break;
                case 2:
                    pacientesView.detalhesPaciente();
                    break;
                case 3:
                    pacientesView.allPacientes();
                    break;
                case 4:
                    pacientesView.consultarAtendimentos();
                    break;
                case 5:
                    medicamentosView.cadastrarMedicamento();
                    break;
                case 6:
                    medicamentosView.asociarPaciente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void administrarAgendamentos(){
        int opcao;

        do {
            System.out.println("\nAdministrar Atendimentos");
            System.out.println("1. Agendar Atendimento");
            System.out.println("2. Cancelar Atendimento");
            System.out.println("3. Fazer Prontuário");
            System.out.println("0. Voltar ao Menu de Pacientes");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    agendasView.cadastrarAgenda();
                    break;
                case 2:
                    agendasView.deletarAgenda();
                    break;
                case 3:
                    agendasView.prontuarioAgenda();
                    break;
                case 0:
                    System.out.println("Voltando ao menu de pacientes...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}
