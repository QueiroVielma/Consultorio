package model.repositories;

import model.entities.ResponsaveisEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ResponsaveisRepository implements BasicCrud{

    EntityManager em = Persistence.createEntityManagerFactory("terapia").createEntityManager();

    @Override
    public Object create(Object object) {
        ResponsaveisEntity responsavel = (ResponsaveisEntity) object;
        em.getTransaction().begin();
        em.persist(responsavel);
        em.getTransaction().commit();
        return findById(responsavel.getId());
    }

    @Override
    public Object findById(Long id) {
        try {
            ResponsaveisEntity responsavelInBd = em.find(ResponsaveisEntity.class, id);
            return responsavelInBd;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;    }


    @Override
    public Object update(Object object) {
        ResponsaveisEntity responsavelUpdate = (ResponsaveisEntity) object;
        em.getTransaction().begin();
        em.merge(responsavelUpdate);
        em.getTransaction().commit();
        return null;

    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var repsponsavel = (ResponsaveisEntity) findById(id);
        em.remove(repsponsavel);
        em.getTransaction().commit();
    }


}
