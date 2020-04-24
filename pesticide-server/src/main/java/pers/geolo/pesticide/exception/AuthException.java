package pers.geolo.pesticide.exception;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
public class AuthException extends RuntimeException {

    private int code;

    public AuthException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
