package pers.geolo.pesticide.server.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import pers.geolo.pesticide.server.entity.ResponseEntity;
import pers.geolo.pesticide.server.exception.AuthException;
import pers.geolo.pesticide.server.exception.FileNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<Void> handleJWTVerificationException(JWTVerificationException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(403);
        responseEntity.setMessage("client need an authorization");
        return responseEntity;
    }

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

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleFileNotFoundException(FileNotFoundException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(-5);
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }
}
