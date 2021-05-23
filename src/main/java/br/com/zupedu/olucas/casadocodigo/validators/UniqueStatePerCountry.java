package br.com.zupedu.olucas.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@Target({ ElementType.TYPE_USE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueStatePerCountryValidator.class })
@ReportAsSingleViolation
public @interface UniqueStatePerCountry {

    String message() default "State already exists";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default  { };
}
