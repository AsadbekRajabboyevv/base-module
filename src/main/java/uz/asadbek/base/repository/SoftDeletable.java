package uz.asadbek.base.repository;

import java.time.LocalDateTime;

public interface SoftDeletable {
  void setDeletedAt(LocalDateTime deletedAt);
}