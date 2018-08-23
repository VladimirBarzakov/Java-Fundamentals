package p10to14Inferno.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomAnnotation {
    String author();
    int revision();
    String description();
    String[] reviewers();

}
