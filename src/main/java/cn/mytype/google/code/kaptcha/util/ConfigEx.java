package cn.mytype.google.code.kaptcha.util;

import java.awt.Color;
import java.util.Properties;
import java.util.Random;

import org.springframework.util.StringUtils;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.util.Config;
import com.google.code.kaptcha.util.ConfigHelper;



public class ConfigEx extends Config {

    private static final String DELIMITERS = "|";

    /** */
    private ConfigHelper helper;

    public ConfigEx(Properties properties) {
        super(properties);
        this.helper = new ConfigHelper();
    }

    /** */
    @Override
    public Color getTextProducerFontColor()
    {
        String paramName = Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR;
        String paramValue = getProperties().getProperty(paramName);
        String[] colors = StringUtils.tokenizeToStringArray(paramValue, DELIMITERS);
        Random random =new Random();
        String color = colors[random.nextInt(colors.length)];
        return this.helper.getColor(paramName, color, Color.BLACK);
    }

    /** */
    @Override
    public Color getNoiseColor()
    {
        String paramName = Constants.KAPTCHA_NOISE_COLOR;
        String paramValue = getProperties().getProperty(paramName);
        String[] colors = StringUtils.tokenizeToStringArray(paramValue, DELIMITERS);
        Random random =new Random();
        String color = colors[random.nextInt(colors.length)];
        return this.helper.getColor(paramName, color, Color.BLACK);
    }

}
