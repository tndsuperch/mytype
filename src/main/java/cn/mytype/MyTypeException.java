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

    public MyTypeException() {
        super();
    }

    public MyTypeException(Throwable throwable) {
        super();
        this.exception = throwable;
        log.error(throwable);
    }

    public MyTypeException(String message, Throwable throwable) {
        super();
        this.message = message;
        this.exception = throwable;
        log.error(message, throwable);
    }

    public MyTypeException(String messageId, Object[] args, Throwable throwable) {
        super();
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
