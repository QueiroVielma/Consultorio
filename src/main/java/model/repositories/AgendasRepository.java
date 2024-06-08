package model.repositories;

import model.entities.AgendasEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class AgendasRepository implements BasicCrud{

    EntityManager em = Persistence.createEntityManagerFactory("terapia").createEntityManager();

    @Override
    public Object create(Object object) {
        AgendasEntity agenda = (AgendasEntity) object;
        em.getTransaction().begin();
        em.persist(agenda);
        em.getTransaction().commit();
        return findById(agenda.getId());
    }

    @Override
    public Object findById(Long id) {
        try {
            AgendasEntity agendaInBd = em.find(AgendasEntity.class, id);
            return agendaInBd;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Object update(Object object) {
        AgendasEntity agendaUpdate = (AgendasEntity) object;
        em.getTransaction().begin();
        em.merge(agendaUpdate);
        em.getTransaction().commit();
        return null;

    }

    @Override
    public void delete(Long id){
        em.getTransaction().begin();
        AgendasEntity agenda = (AgendasEntity) findById(id);
        em.remove(agenda);
        em.getTransaction().commit();
    }

    public List<AgendasEntity> findAll(){
        return em.createQuery("SELECT a FROM AgendasEntity a",AgendasEntity.class).getResultList();
    }

}
