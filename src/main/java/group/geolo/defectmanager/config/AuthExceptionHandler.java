package group.geolo.defectmanager.config;

import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.exception.AuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public ResponseEntity<Void> handleAuthException(AuthException authException) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(authException.getCode());
        responseEntity.setMessage(authException.getMessage());
        return responseEntity;
    }
}
