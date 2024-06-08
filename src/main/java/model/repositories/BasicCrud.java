package model.repositories;

public interface BasicCrud {
    Object create(Object object);

    Object findById(Long id);

    Object update (Object object);

    void delete(Long id);

}
