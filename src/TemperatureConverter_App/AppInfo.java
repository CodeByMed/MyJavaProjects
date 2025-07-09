package TemperatureConverter_App;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for providing application metadata.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AppInfo {
    String author();
    String version();
    String description();
}
