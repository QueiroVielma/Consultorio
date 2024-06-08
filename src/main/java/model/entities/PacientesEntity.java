package model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "pacientes")
public class PacientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(name= "data_nascimento")
    private LocalDate dataNascimento;

    private String email;

    private String contato;
    @Column (name = "contato_emergencia")
    private String contatoEmergencia;

    @ManyToOne
    @JoinColumn(name = "fk_idresponsaveis")
    private ResponsaveisEntity responsavel;


    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<EnderecosEntity> enderecos= new ArrayList<>();

    @OneToMany(mappedBy = "pacientes", cascade =  {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private List<AgendasEntity> agendas;

    @ManyToMany()
    @JoinTable(name = "medicamentos_pacientes",
            joinColumns = @JoinColumn(name = "fk_idpacientes"),
            inverseJoinColumns = @JoinColumn(name = "fk_idmedicamentos"))
    private List<MedicamentosEntity> medicamentos = new ArrayList<>();


    public  PacientesEntity(){

    }
    public PacientesEntity(Long id, String nome, LocalDate dataNascimento, String email, String contato, String contatoEmergencia, List<EnderecosEntity> enderecos, List<AgendasEntity> agendas, List<MedicamentosEntity> medicamentos) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.contato = contato;
        this.contatoEmergencia = contatoEmergencia;
        this.enderecos = enderecos;
        this.agendas = agendas;
        this.medicamentos = medicamentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public List<EnderecosEntity> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosEntity> enderecos) {
        this.enderecos = enderecos;
    }

    public List<AgendasEntity> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendasEntity> agendas) {
        this.agendas = agendas;
    }

    public List<MedicamentosEntity> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentosEntity> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ResponsaveisEntity getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsaveisEntity responsavel) {
        this.responsavel = responsavel;
    }
}
