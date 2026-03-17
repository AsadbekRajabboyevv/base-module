package uz.asadbek.base.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.asadbek.base.dto.BaseResponseDto;
import uz.asadbek.base.filter.BaseFilter;

public interface BaseApi<RESPONSE, REQUEST, ID, F extends BaseFilter> {

  @GetMapping
  BaseResponseDto<Page<RESPONSE>> get(F filter, Pageable pageable);

  @GetMapping("/{id}")
  BaseResponseDto<RESPONSE> get(@PathVariable ID id);

  @PostMapping
  BaseResponseDto<RESPONSE> create(@RequestBody REQUEST request);

  @PutMapping("/{id}")
  BaseResponseDto<RESPONSE> update(@PathVariable ID id, @RequestBody REQUEST request);

  @DeleteMapping("/{id}")
  BaseResponseDto<Void> delete(@PathVariable ID id);
}