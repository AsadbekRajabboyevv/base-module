package uz.asadbek.base.mapper;

import java.util.List;
public interface BaseMapper<Entity, RequestDto, ResponseDto> {

  Entity toEntity(RequestDto dto);

  ResponseDto toDto(Entity entity);

  List<Entity> toEntity(List<RequestDto> dtoList);

  List<ResponseDto> toDto(List<Entity> entityList);

  void partialUpdate(Entity entity, RequestDto dto);
}
