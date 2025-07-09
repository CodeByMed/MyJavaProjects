package Madlibs_App;

import java.util.*;

/**
 * Java Mad Libs game. Fills a story template with user inputs.
 */
public class MadlibsProgram extends Game implements Playable {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<DifficultyLevel, MadLibsTemplate> templates = new HashMap<>();

    public MadlibsProgram() {
        templates.put(DifficultyLevel.EASY, new MadLibsTemplate(
                "Today I went to the {place} and saw a {adjective} {noun}.",
                List.of("place", "adjective", "noun")
        ));
        templates.put(DifficultyLevel.HARD, new MadLibsTemplate(
                "In the year {year}, a {adjective} scientist named {name} built a {adjective2} {invention}.",
                List.of("year", "adjective", "name", "adjective2", "invention")
        ));
    }

    @Override
    public void run() {
        printWelcome("Java Madlibs");

        DifficultyLevel level = selectDifficulty();
        MadLibsTemplate template = templates.get(level);

        Map<String, String> userInputs = new HashMap<>();

        for (String word : template.placeholders()) {
            System.out.print("Please enter a " + word + ": ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                throw new InvalidInputException("cannot be empty for: " + word);
            }
            userInputs.put(word, input);
        }

        String story = fillTemplate(template.template(), userInputs);
        System.out.println("\n🎉 Your Mad Lib Story 🎉\n" + story);
    }

    private DifficultyLevel selectDifficulty() {
        System.out.println("Select Difficulty: [1] EASY, [2] HARD");
        String choice = scanner.nextLine();
        return switch (choice) {
            case "1" -> DifficultyLevel.EASY;
            case "2" -> DifficultyLevel.HARD;
            default -> throw new InvalidInputException("Invalid difficulty selection.");
        };
    }

    private String fillTemplate(String template, Map<String, String> inputs) {
        String result = template;
        for (Map.Entry<String, String> entry : inputs.entrySet()) {
            result = result.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return result;
    }
}