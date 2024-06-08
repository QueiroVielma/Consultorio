package model.repositories;

import model.entities.MedicamentosEntity;
import model.entities.PacientesEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class  MedicamentosRepository implements BasicCrud{

    EntityManager em = Persistence.createEntityManagerFactory("terapia").createEntityManager();

    @Override
    public Object create(Object object) {
        MedicamentosEntity medicamentos = (MedicamentosEntity) object;
        em.getTransaction().begin();
        em.persist(medicamentos);
        em.getTransaction().commit();
        return findById(medicamentos.getId());
    }

    @Override
    public Object findById(Long id) {
        try {
            MedicamentosEntity medicamentosInBd = em.find(MedicamentosEntity.class, id);
            return medicamentosInBd;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Object update(Object object) {
        MedicamentosEntity medicamentoUpdate = (MedicamentosEntity) object;
        em.getTransaction().begin();
        em.merge(medicamentoUpdate);
        em.getTransaction().commit();
        return null;

    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var medicamento = (MedicamentosEntity) findById(id);
        em.remove(medicamento);
        em.getTransaction().commit();
    }

    public List<MedicamentosEntity> findAll(){
        return em.createQuery("SELECT m FROM MedicamentosEntity m",MedicamentosEntity.class).getResultList();
    }



}
