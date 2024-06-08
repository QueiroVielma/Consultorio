package model.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "responsaveis")
public class ResponsaveisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String parentesco;
    private  String contato;
    private String email;
    @OneToMany(mappedBy = "responsavel", cascade = {CascadeType.ALL,CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<PacientesEntity> paciente= new ArrayList<>();

    public ResponsaveisEntity(){

    }

    public ResponsaveisEntity(Long id, String nome, String parentesco, String contato, String email, List<PacientesEntity> pessoa) {
        this.id = id;
        this.nome = nome;
        this.parentesco = parentesco;
        this.contato = contato;
        this.email = email;
        this.paciente = pessoa;
    }

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PacientesEntity> getPessoa() {
        return paciente;
    }

    public void setPessoa(List<PacientesEntity> pessoa) {
        this.paciente = pessoa;
    }
}
