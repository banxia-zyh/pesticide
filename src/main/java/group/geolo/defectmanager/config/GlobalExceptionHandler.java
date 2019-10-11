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
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public ResponseEntity<Void> handleAuthException(AuthException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(exception.getCode());
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<Void> handleIllegalException(IllegalArgumentException exception) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(-2);
        responseEntity.setMessage(exception.getMessage());
        return responseEntity;
    }
}
