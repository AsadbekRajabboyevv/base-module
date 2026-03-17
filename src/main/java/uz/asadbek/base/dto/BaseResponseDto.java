package uz.asadbek.base.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto<T> {

  private boolean success;
  private String message;
  private LocalDateTime timestamp = LocalDateTime.now();
  private T data;

  public static <T> BaseResponseDto<T> ok(T data) {
    return BaseResponseDto.<T>builder()
        .success(true)
        .message("Success")
        .data(data)
        .build();
  }

  public static <T> BaseResponseDto<T> ok(String message, T data) {
    return BaseResponseDto.<T>builder()
        .success(true)
        .message(message)
        .data(data)
        .build();
  }

  public static <T> BaseResponseDto<T> fail(String message) {
    return BaseResponseDto.<T>builder()
        .success(false)
        .message(message)
        .build();
  }
}
