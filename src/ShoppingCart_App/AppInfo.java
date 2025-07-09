package ShoppingCart_App;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation providing metadata about the application.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AppInfo {
    String author();
    String version();
    String description();
}
