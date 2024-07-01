package finalexam.task5;

public class ChatbotTester {
    public static void main(String[] args) {
        // Replace with your actual endpoint
        String endpoint = "https://api.example.com/chatbot";
        CommunicationManager manager = new CommunicationManager(endpoint);

        String userMessage = "Hello, chatbot!";
        String response = manager.sendUserMessage(userMessage);

        System.out.println("User: " + userMessage);
        System.out.println("Chatbot: " + response);
    }
}