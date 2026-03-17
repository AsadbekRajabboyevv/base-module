package uz.asadbek.base.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.asadbek.base.dto.BaseResponseDto;
import uz.asadbek.base.filter.BaseFilter;
import uz.asadbek.base.service.BaseService;

@RequiredArgsConstructor
public abstract class BaseController<
    RESPONSE,
    REQUEST,
    ID,
    F extends BaseFilter>
    implements BaseApi<RESPONSE, REQUEST, ID, F> {

  protected final BaseService<RESPONSE, REQUEST, ID, F> service;

  @Override
  public BaseResponseDto<Page<RESPONSE>> get(F filter, Pageable pageable) {
    return BaseResponseDto.ok(service.get(filter, pageable));
  }

  @Override
  public BaseResponseDto<RESPONSE> get(ID id) {
    return BaseResponseDto.ok(service.get(id));
  }

  @Override
  public BaseResponseDto<RESPONSE> create(REQUEST request) {
    return BaseResponseDto.ok(service.create(request));
  }

  @Override
  public BaseResponseDto<RESPONSE> update(ID id, REQUEST request) {
    return BaseResponseDto.ok(service.update(id, request));
  }

  @Override
  public BaseResponseDto<Void> delete(ID id) {
    service.delete(id);
    return BaseResponseDto.ok(null);
  }
}