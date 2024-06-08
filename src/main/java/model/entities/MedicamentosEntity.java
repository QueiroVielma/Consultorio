package model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "medicamentos")
@Entity

public class MedicamentosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nome;

    private String descricao;


    @ManyToMany(mappedBy = "medicamentos")
    private List<PacientesEntity> pacidentes =new ArrayList<>();

    public MedicamentosEntity(){

    }

    public MedicamentosEntity(long id, String nome, String descricao, List<PacientesEntity> pessoas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

        this.pacidentes = pessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PacientesEntity> getPessoas() {
        return pacidentes;
    }

    public void setPessoas(List<PacientesEntity> pessoas) {
        this.pacidentes = pessoas;
    }
}
