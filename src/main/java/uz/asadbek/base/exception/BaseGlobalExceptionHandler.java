package uz.asadbek.base.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.asadbek.base.dto.BaseResponseDto;

@RestControllerAdvice
public class BaseGlobalExceptionHandler {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<BaseResponseDto<Object>> handleBaseException(BaseException e) {

    return ResponseEntity
        .status(e.getStatus())
        .body(BaseResponseDto.fail(e.getMessage()));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<BaseResponseDto<Object>> handleRuntime(RuntimeException e) {

    return ResponseEntity
        .badRequest()
        .body(BaseResponseDto.fail(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<BaseResponseDto<Object>> handleException(Exception e) {

    return ResponseEntity
        .internalServerError()
        .body(BaseResponseDto.fail("Internal server error"));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<BaseResponseDto<Object>> handleValidation(
      MethodArgumentNotValidException e
  ) {

    String error = e.getBindingResult()
        .getFieldErrors()
        .stream()
        .findFirst()
        .map(err -> err.getField() + " " + err.getDefaultMessage())
        .orElse("Validation error");

    return ResponseEntity
        .badRequest()
        .body(BaseResponseDto.fail(error));
  }
}