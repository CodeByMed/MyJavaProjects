package Quiz_App;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for adding metadata to the QuizGame class.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    String author();
    String version();
    String description();
}
