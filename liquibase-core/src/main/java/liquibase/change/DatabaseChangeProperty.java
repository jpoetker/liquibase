package liquibase.change;

import liquibase.serializer.LiquibaseSerializable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used by {@link AbstractChange } to declare {@link ChangeParameterMetaData} information.
 * The annotation should be placed on the read method.
 * This annotation should not be checked for outside AbstractChange, if any code is trying to determine the
 * metadata provided by this annotation, it should get it from {@link liquibase.change.Change#getChangeMetaData()}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DatabaseChangeProperty {

    /**
     * Value to put into {@link ChangeParameterMetaData#getDescription()}
     */
    public String description() default "";

    /**
     * Value to put into {@link liquibase.change.ChangeParameterMetaData#getExampleValue()}
     */
    public String exampleValue() default "";

    /**
     * Value to put into {@link liquibase.change.ChangeParameterMetaData#getExampleValue()}
     */
    public String since() default "";

    /**
     * If false, this field or method will not be included in {@ChangeParameterMetaData}
     */
    public boolean isChangeProperty() default true;

    /**
     * Value to put into {@link ChangeParameterMetaData#getRequiredForDatabase()}
     */
    public String[] requiredForDatabase() default "none";

    /**
     * Value to put into {@link liquibase.change.ChangeParameterMetaData#getMustEqualExisting()}
     */
    public String mustEqualExisting() default "";

    /**
     * Format to use when serializing this Change via a {@link liquibase.serializer.ChangeLogSerializer}.
     */
    public LiquibaseSerializable.SerializationType serializationType() default LiquibaseSerializable.SerializationType.NAMED_FIELD;
}
