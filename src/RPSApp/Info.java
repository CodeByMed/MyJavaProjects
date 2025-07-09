package RPSApp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to provide metadata about the game.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    String author();
    String version();
    String description();
}
