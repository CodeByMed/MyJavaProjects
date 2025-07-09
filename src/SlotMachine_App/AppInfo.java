package SlotMachine_App;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for providing app metadata.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AppInfo {
    String author();
    String version();
    String description();
}
