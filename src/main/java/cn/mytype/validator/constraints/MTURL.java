package cn.mytype.validator.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;


@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@URL
public @interface MTURL {

    @OverridesAttribute(constraint = URL.class, name = "protocol") String protocol() default "";
    @OverridesAttribute(constraint = URL.class, name = "host") String host() default "";
    @OverridesAttribute(constraint = URL.class, name = "port") int port() default -1;
    @OverridesAttribute(constraint = URL.class, name = "regexp") String regexp() default ".*";
    @OverridesAttribute(constraint = URL.class, name = "flags") Pattern.Flag[] flags() default { };

	String message() default "{cn.mytype.validator.constraints.MTURL.message}";

	String name() default "";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	/**
	 * Defines several {@code @NotEmpty} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
	    MTURL[] value();
	}
}
