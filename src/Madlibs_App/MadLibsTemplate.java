package Madlibs_App;

import java.util.List;

/**
 * Represents a Mad Libs story template and its required placeholders.
 * Uses Java Records for immutability and simplicity.
 */
public record MadLibsTemplate(String template, List<String> placeholders) {
}
