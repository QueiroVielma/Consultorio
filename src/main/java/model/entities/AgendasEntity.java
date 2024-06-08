package model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Table(name = "agendas")
@Entity
public class AgendasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime agendamento;
    private String comentario;

    private String prontuario;
    @ManyToOne
    @JoinColumn(name = "fk_idpacientes")
    private PacientesEntity pacientes;

    public AgendasEntity(){

    }
    public AgendasEntity(long id, LocalDateTime agendamento, String comentario, String prontuario, PacientesEntity pessoa) {
        this.id = id;
        this.agendamento = agendamento;
        this.comentario = comentario;
        this.prontuario= prontuario;
        this.pacientes = pessoa;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public PacientesEntity getPacientes() {
        return pacientes;
    }

    public void setPacientes(PacientesEntity pacientes) {
        this.pacientes = pacientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(LocalDateTime agendamento) {
        this.agendamento = agendamento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
