package cn.mytype.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public enum MessagesConfig {

    LabelFieldUserId("label.field.user.id");


    private final String value;

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;

    MessagesConfig(final String key) {
        value = messageSource.getMessage(key, null, null);
    }

    public String getValue() {
        return this.value;
    }

}
