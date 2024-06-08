package model.repositories;

import model.entities.EnderecosEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EnderecosRepository implements BasicCrud{

    EntityManager em = Persistence.createEntityManagerFactory("terapia").createEntityManager();

    @Override
    public Object create(Object object) {
        EnderecosEntity endereco = (EnderecosEntity) object;
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
        return findById(endereco.getId());
    }

    @Override
    public Object findById(Long id) {
        try {
            EnderecosEntity endereecosInBd = em.find(EnderecosEntity.class, id);
            return endereecosInBd;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;    }

    @Override
    public Object update(Object object) {
        EnderecosEntity enderecoUpdate = (EnderecosEntity) object;
        em.getTransaction().begin();
        em.merge(enderecoUpdate);
        em.getTransaction().commit();
        return null;

    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var endereco=  findById(id);
        em.remove(endereco);
        em.getTransaction().commit();
    }


}
