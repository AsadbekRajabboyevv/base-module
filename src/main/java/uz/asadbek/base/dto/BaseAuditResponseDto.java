package uz.asadbek.base.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BaseAuditResponseDto {
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
  private Long createdBy;
  private Long updatedBy;
  private Long deletedBy;
}
