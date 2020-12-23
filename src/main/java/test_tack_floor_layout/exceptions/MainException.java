package test_tack_floor_layout.exceptions;

import java.util.Objects;

public class MainException extends RuntimeException{
    private String message;
    private Long exceptionCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainException that = (MainException) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(exceptionCode, that.exceptionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, exceptionCode);
    }

    public MainException() {
    }

    public MainException(String message) {
        super(message);
    }

    public MainException(String message, Long exceptionCode) {
        this.message = message;
        this.exceptionCode = exceptionCode;
    }

    public MainException(String message, Throwable cause) {
        super(message, cause);
    }

    public MainException(Throwable cause) {
        super(cause);
    }

    public MainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
