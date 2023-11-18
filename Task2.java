import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        // Step 1: Prompt the user to enter a text or provide a file
        System.out.println("Enter a text or provide a file path:");

        // Step 2: Read the input text or file and store it in a string
        String input = getInput();

        // Step 3: Split the string into an array of words
        String[] words = input.split("[\\s\\p{Punct}]+");

        // Step 4: Initialize a counter variable
        int wordCount = 0;

        // Step 5: Initialize a map to store word frequencies
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // Step 5: Iterate through the array of words and increment the counter
        for (String word : words) {
            // Step 7: Ignore common words or stop words
            if (!isCommonWord(word)) {
                wordCount++;

                // Step 8: Update word frequency statistics
                wordFrequencyMap.put(word.toLowerCase(), wordFrequencyMap.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        // Step 6: Display the total count of words to the user
        System.out.println("Total word count: " + wordCount);

        // Step 8: Display the number of unique words and their frequencies
        System.out.println("Number of unique words: " + wordFrequencyMap.size());
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Step 9: Implement input validation to handle empty inputs or file errors
        if (input.isEmpty()) {
            System.out.println("Input is empty. Please provide valid input.");
        }
    }

    // Helper method to read input from the user or a file
    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // If the input is a file path, read the content of the file
        if (input.startsWith("file:")) {
            String filePath = input.substring(5); // Remove "file:" prefix
            try {
                Scanner fileScanner = new Scanner(new File(filePath));
                StringBuilder fileContent = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    fileContent.append(fileScanner.nextLine()).append("\n");
                }
                fileScanner.close();
                return fileContent.toString();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please provide a valid file path.");
                return "";
            }
        }

        return input;
    }

    // Helper method to check if a word is a common word or stop word
    private static boolean isCommonWord(String word) {
        // Add your list of common words or stop words here
        Set<String> commonWords = new HashSet<>();
        commonWords.add("the");
        commonWords.add("and");
        commonWords.add("is");
        // Add more words as needed

        return commonWords.contains(word.toLowerCase());
    }
}
