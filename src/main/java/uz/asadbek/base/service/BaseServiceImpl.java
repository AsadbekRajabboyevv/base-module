package uz.asadbek.base.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import uz.asadbek.base.exception.BaseException;
import uz.asadbek.base.filter.BaseFilter;
import uz.asadbek.base.mapper.BaseMapper;
import uz.asadbek.base.repository.BaseRepository;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<
    ENTITY,
    REQUEST,
    RESPONSE,
    ID,
    F extends BaseFilter>
    implements BaseService<RESPONSE, REQUEST, ID, F> {

  protected final BaseRepository<ENTITY, ID> repository;
  protected final BaseMapper<ENTITY, REQUEST, RESPONSE> mapper;

  protected abstract Page<RESPONSE> findAllDto(F filter, Pageable pageable);
  protected abstract RESPONSE findOneDto(ID id);

  protected abstract String getEntityName();

  @Override
  public Page<RESPONSE> get(F filter, Pageable pageable) {
    return findAllDto(filter, pageable);
  }

  @Override
  public RESPONSE get(ID id) {
    return findOneDto(id);
  }

  @Override
  public RESPONSE create(REQUEST request) {
    ENTITY entity = mapper.toEntity(request);
    ENTITY saved = repository.save(entity);
    return mapper.toDto(saved);
  }

  @Override
  public RESPONSE update(ID id, REQUEST request) {
    ENTITY entity = getEntity(id);

    mapper.partialUpdate(entity, request);

    ENTITY saved = repository.save(entity);
    return mapper.toDto(saved);
  }

  @Override
  public void delete(ID id) {
    repository.delete(getEntity(id));
  }
  protected ENTITY getEntity(ID id) {
    return repository.findById(id)
        .orElseThrow(() -> new BaseException(
            getEntityName() + " not found", HttpStatus.NOT_FOUND.value()));
  }
}