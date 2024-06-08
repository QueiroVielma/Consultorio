package model.repositories;

import model.entities.PacientesEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PacientesRepository implements BasicCrud{

    EntityManager em = Persistence.createEntityManagerFactory("terapia").createEntityManager();

    @Override
    public Object create(Object object) {
        PacientesEntity paciente = (PacientesEntity) object;
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
        return findById(paciente.getId());
    }

    @Override
    public Object findById(Long id) {
        try {
            PacientesEntity pacienteInBd = em.find(PacientesEntity.class, id);
            return pacienteInBd;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Object update(Object object) {
        PacientesEntity pacienteUpdate = (PacientesEntity) object;
        em.getTransaction().begin();
        em.merge(pacienteUpdate);
        em.getTransaction().commit();
        return null;

    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var paciente = (PacientesEntity) findById(id);
        em.remove(paciente);
        em.getTransaction().commit();
    }

    public List<PacientesEntity> findAll(){
        return em.createQuery("SELECT p FROM PacientesEntity p",PacientesEntity.class).getResultList();
    }

    public PacientesEntity merge(PacientesEntity paciente) {
        return em.merge(paciente);
    }


}
