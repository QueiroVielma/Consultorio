package model.service;

import model.entities.EnderecosEntity;
import model.entities.PacientesEntity;
import model.entities.ResponsaveisEntity;
import model.repositories.ResponsaveisRepository;

import java.util.ArrayList;
import java.util.List;

public class ResponsavelService {

    ResponsaveisRepository responsaveisRepository= new ResponsaveisRepository();
    public ResponsaveisEntity addResponsavelBD(ResponsaveisEntity entity){return (ResponsaveisEntity) responsaveisRepository.create(entity);}

    public ResponsaveisEntity criarResponsavel(ResponsaveisEntity responsavel, PacientesEntity pacinete){
        responsavel.getPessoa().add(pacinete);
        return addResponsavelBD(responsavel);
    }

}
