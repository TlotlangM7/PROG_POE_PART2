package prog;

import java.util.ArrayList;

public class MessageStore {

    private ArrayList<String> sentMessages =
            new ArrayList<>();

    private ArrayList<String> storedMessages =
            new ArrayList<>();

    private ArrayList<String> disregardedMessages =
            new ArrayList<>();

    // Store Sent Message
    public void addSentMessage(String message) {

        sentMessages.add(message);
    }

    // Store Saved Message
    public void addStoredMessage(String message) {

        storedMessages.add(message);
    }

    // Store Disregarded Message
    public void addDisregardedMessage(String message) {

        disregardedMessages.add(message);
    }

    // Display Sent Messages
    public void displaySentMessages() {

        System.out.println("===== SENT MESSAGES =====");

        for (String message : sentMessages) {

            System.out.println(message);
        }
    }

    // Display Stored Messages
    public void displayStoredMessages() {

        System.out.println("===== STORED MESSAGES =====");

        for (String message : storedMessages) {

            System.out.println(message);
        }
    }

    // Display Disregarded Messages
    public void displayDisregardedMessages() {

        System.out.println("===== DISREGARDED MESSAGES =====");

        for (String message : disregardedMessages) {

            System.out.println(message);
        }
    }
}