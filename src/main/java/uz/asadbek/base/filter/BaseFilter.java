package uz.asadbek.base.filter;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseFilter {

  private Long id;
  private LocalDateTime createdAtFrom;
  private LocalDateTime createdAtTo;
  private LocalDateTime updatedAtFrom;
  private LocalDateTime updatedAtTo;
  private Long createdBy;
  private Long updatedBy;
  private String createdByName;
  private String updatedByName;
}
