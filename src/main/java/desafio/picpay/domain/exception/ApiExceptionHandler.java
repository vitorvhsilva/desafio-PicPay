package desafio.picpay.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ResponseEntity<?> tratarValidacaoException(PicPayException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
