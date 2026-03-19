package uz.asadbek.base.mapper;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface BaseMapper<Entity, RequestDto, ResponseDto> {

  Entity toEntity(RequestDto dto);

  ResponseDto toDto(Entity entity);

  List<Entity> toEntity(List<RequestDto> dtoList);

  List<ResponseDto> toDto(List<Entity> entityList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void partialUpdate(@MappingTarget Entity entity, RequestDto dto);
}
