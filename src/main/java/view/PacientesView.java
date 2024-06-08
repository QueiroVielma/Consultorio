package view;

import controller.PacienteController;
import model.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PacientesView {


    Scanner scanner = new Scanner(System.in);
    PacienteController pacienteController= new PacienteController();
    EnderecoView enderecoCadView= new EnderecoView();
    ResponsavelView responsavelView = new ResponsavelView();
    public void salvarPacientes (){
        PacientesEntity paciente= cadPaciente();
        EnderecosEntity enderecos= enderecoCadView.cadEndereco();
        pacienteController.criarPaciente(paciente, enderecos);
    }


    public PacientesEntity cadPaciente(){
        scanner.nextLine();
        PacientesEntity novoPaciente = new PacientesEntity();
        System.out.println("Digite o nome do paciente:");
        novoPaciente.setNome(scanner.nextLine());

        System.out.println("Digite a data de nascimento do paciente (no formato yyyy-MM-dd):");
        String dataNascimento= scanner.nextLine();
        LocalDate dataNascimentoLD = LocalDate.parse(dataNascimento);
        novoPaciente.setDataNascimento(dataNascimentoLD);

        System.out.println("Digite o email do paciente:");
        novoPaciente.setEmail(scanner.nextLine());

        System.out.println("Digite o contato do paciente:");
        novoPaciente.setContato(scanner.nextLine());

        System.out.println("Digite o contato de emergência do paciente:");
        novoPaciente.setContatoEmergencia(scanner.nextLine());

        ResponsaveisEntity responsavel= responsavelView.cadResponsavel();
        novoPaciente.setResponsavel(responsavel);
        return novoPaciente;
    }

    public void allPacientes() {
        PacienteController pessoasController = new PacienteController();
        for(PacientesEntity x : pessoasController.findAll()) {
            System.out.println("ID:"+x.getId()+" - Nome: "+x.getNome());
        }
    }

    public PacientesEntity finById (){
        System.out.println("Selecinar paciente");
        allPacientes();
        long id = scanner.nextLong();
        return pacienteController.finById (id);
    }

    public void detalhesPaciente(){
        PacientesEntity paciente= finById();
        System.out.println("   Dados Paciente");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("Data Nascimento: "+ paciente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Email: " + paciente.getEmail());
        System.out.println("Contato: "+ paciente.getContato());
        System.out.println("Contato de Emergencia: "+ paciente.getContatoEmergencia());
        for (MedicamentosEntity x: paciente.getMedicamentos())
            System.out.println("Medicamento: "+ x.getNome());
        for (EnderecosEntity x: paciente.getEnderecos())
            System.out.println("Endereco: "+ x.getRua()+", " + x.getNumero()+", " + x.getBairro()+", "+ x.getCep());
        if(paciente.getResponsavel()!=null){
            System.out.println("-----Dados Responsavel-----");
            System.out.println("Nome representante: " + paciente.getResponsavel().getNome());
            System.out.println("Parentesco:  "+ paciente.getResponsavel().getParentesco());
            System.out.println("Contato: "+ paciente.getResponsavel().getContato());
            System.out.println("Email: " + paciente.getResponsavel().getEmail());
        }
    }

    public void consultarAtendimentos(){
        PacientesEntity paciente= finById();
        System.out.println("Agenmdamentos do paciente: "+ paciente.getNome());
        boolean proximosAgendamentos= filtrarAgendamento();
        if(proximosAgendamentos){
            System.out.println("Proximos horarios:");
        }else {
            System.out.println("Toodos Os Horarios");
        }
        LocalDateTime now = LocalDateTime.now();
        for(AgendasEntity x: paciente.getAgendas()){
            if (now.isBefore(x.getAgendamento()) && proximosAgendamentos) {
                System.out.println("Horario: " + x.getAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }else {
                System.out.println("Horario: " + x.getAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        }
    }

    public boolean filtrarAgendamento(){
        int opcao;

        do {
            System.out.println("Escolha uma Opcao");
            System.out.println("1. Visualizar Próximos Atendimentos");
            System.out.println("2. Visualizar Todos os Atendimentos");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    return true;
                case 2:
                    return false;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
        return false;
    }

}
