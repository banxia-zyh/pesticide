package group.geolo.defectmanager.config;

import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.exception.AuthException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<Void> handleAuthException(AuthException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(exception.getCode());
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> handleIllegalException(IllegalArgumentException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(-2);
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handleEntityNotFoundException(EntityNotFoundException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(-3);
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }
}
