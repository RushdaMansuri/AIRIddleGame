import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class RiddleGame {

    private static final String API_URL = "https://api.openai.com/v4/completions";
    private static String API_KEY;  // API Key is now loaded dynamically

    public static void main(String[] args) {
        // Load the API key from an environment variable for better security
        API_KEY = System.getenv("OPENAI_API_KEY");
        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("API Key is not set. Please configure the OPENAI_API_KEY environment variable.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Generating a riddle for you...");

        String riddle = generateRiddle();
        if (riddle != null && !riddle.isEmpty()) {
            System.out.println("Riddle: " + riddle);
            System.out.print("What's your answer? ");
            String userAnswer = scanner.nextLine(); // Simulate user answering the riddle

            System.out.println("Let's assume every answer is clever. Well done!");
        } else {
            System.out.println("Failed to generate a riddle. Please try again later.");
        }
    }

    private static String generateRiddle() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v4/completions")) // Ensure this is correctly formatted
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\n" +
                                "\"model\": \"text-davinci-003\", \n" + // or use the latest model version
                                "\"prompt\": \"Create a clever riddle.\",\n" +
                                "\"temperature\": 0.5,\n" +
                                "\"max_tokens\": 100\n" +
                                "}"
                ))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println(responseBody); // Print the raw JSON response
            return parseResponseToGetRiddle(responseBody);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String parseResponseToGetRiddle(String responseBody) {
        try {
            JSONObject jsonObj = new JSONObject(responseBody);

            // Check for errors in the response
            if (jsonObj.has("error")) {
                String errorMessage = jsonObj.getJSONObject("error").getString("message");
                return "Error from API: " + errorMessage;
            }

            // Proceed with parsing the riddle if there's no error
            JSONArray choices = jsonObj.getJSONArray("choices");
            if (choices.length() > 0) {
                String riddleText = choices.getJSONObject(0).getString("text");
                return riddleText.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed to parse riddle from response";
    }

}
