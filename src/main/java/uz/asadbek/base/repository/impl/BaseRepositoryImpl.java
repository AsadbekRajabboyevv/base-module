package uz.asadbek.base.repository.impl;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import uz.asadbek.base.repository.BaseRepository;
import uz.asadbek.base.repository.SoftDeletable;

public class BaseRepositoryImpl<T, ID>
    extends SimpleJpaRepository<T, ID>
    implements BaseRepository<T, ID> {

  public BaseRepositoryImpl(
      JpaEntityInformation<T, ID> entityInformation,
      EntityManager entityManager
  ) {
    super(entityInformation, entityManager);
  }

  @Override
  public void delete(T entity) {
    if (entity instanceof SoftDeletable deletable) {
      deletable.setDeletedAt(LocalDateTime.now());
      save(entity);
    } else {
      super.delete(entity);
    }
  }

  @Override
  public void deleteById(ID id) {
    T entity = findById(id).orElseThrow();
    delete(entity);
  }
}