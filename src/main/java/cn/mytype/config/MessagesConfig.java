package cn.mytype.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public enum MessagesConfig {

    LabelFieldUserId("label.field.user.id"),
    MsgErrKaptchaDifferent("msg.err.kaptcha.different");


    private String key;

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;

    MessagesConfig(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue(String... args) {
        return messageSource.getMessage(this.key, args, null);
    }

    @Override
    public String toString() {
        return this.key;
    }

}
