package group.geolo.defectmanager.entity;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
public class ResponseEntity<T> {

    private int code;
    private T data;
    private String message;

    public ResponseEntity() {
    }

    public ResponseEntity(int code) {
        this.code = code;
    }

    public ResponseEntity(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
