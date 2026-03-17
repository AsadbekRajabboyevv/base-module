package uz.asadbek.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.asadbek.base.filter.BaseFilter;

public interface BaseService<RESPONSE, REQUEST, ID, F extends BaseFilter> {

  Page<RESPONSE> get(F filter, Pageable pageable);

  RESPONSE get(ID id);

  RESPONSE create(REQUEST request);

  RESPONSE update(ID id, REQUEST request);

  void delete(ID id);
}