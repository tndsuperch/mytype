package cn.mytype;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.mytype.utils.ImageUtil;

public class MyTypeException extends RuntimeException {

    private static Log log = LogFactory.getLog(ImageUtil.class);

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6284465249389077859L;

    private Throwable exception;
    private String message;
    private String messageId;

    MyTypeException(Throwable throwable) {
        this.exception = throwable;
        log.error(throwable);
    }

    MyTypeException(String message, Throwable throwable) {
        this.message = message;
        this.exception = throwable;
        log.error(message, throwable);
    }

    MyTypeException(String messageId, Object[] args, Throwable throwable) {
        // TODO
        this.message = "";
        this.exception = throwable;
        log.error(this.message, throwable);
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
