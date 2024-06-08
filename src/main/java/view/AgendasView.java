package view;

import controller.AgendasController;
import controller.PacienteController;
import model.entities.AgendasEntity;
import model.entities.PacientesEntity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AgendasView {

    AgendasController agendasController= new AgendasController();
    PacientesView pacientesView = new PacientesView();

    PacienteController pacienteController =new PacienteController();

    public void cadastrarAgenda() {
        Scanner scanner= new Scanner(System.in);
        boolean validarid= false;
        Long usuarioId;
        do {
            pacientesView.allPacientes();
            System.out.println("Informe o ID do usuário que deseja agendar:");
            usuarioId = Long.parseLong(scanner.nextLine());
            for(PacientesEntity x : pacienteController.findAll()) {
                if (usuarioId == x.getId()){
                    validarid=true;
                }
            }
        }while (!validarid);
        AgendasEntity novaAgenda = new AgendasEntity();

        System.out.println("Informe a data e hora do agendamento (no formato yyyy-MM-ddTHH:mm:ss):");
        String dataHoraAgendamentoStr = scanner.nextLine();
        LocalDateTime dataHoraAgendamento = LocalDateTime.parse(dataHoraAgendamentoStr);
        novaAgenda.setAgendamento(dataHoraAgendamento);

        System.out.println("Informe um comentário:");
        novaAgenda.setComentario(scanner.nextLine());

        agendasController.agendar(novaAgenda, usuarioId);
    }

    public void deletarAgenda (){
        Scanner scanner= new Scanner(System.in);
        allConsultas();
        System.out.println("Informe o ID do atendimeento que deseja cancelar :");
        Long agendaId = Long.parseLong(scanner.next());
        agendasController.deletarAgenda(agendaId);
    }

    public void allConsultas() {
        for(AgendasEntity x : agendasController.findAll()) {
            System.out.println("ID:"+x.getId() +" - Nome: "+x.getPacientes().getNome() + " - Horario" + x.getAgendamento());
        }
    }

    public void prontuarioAgenda(){
        Scanner scanner= new Scanner(System.in);
        allConsultas();
        System.out.println("Informe o ID do atendimeento deseja fazer prontuario :");
        Long id = Long.parseLong(scanner.next());
        scanner.nextLine();
        System.out.println("Escreva o prontuaria:");
        String prontuario= scanner.nextLine();
         // Consumir a nova linha

        agendasController.fazerProntuario(id, prontuario);
    }

}
