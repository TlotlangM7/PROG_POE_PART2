package prog;

import java.util.Random;

public class Message {

    private static int totalMessages = 0;

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;

    // Constructor
    public Message(int messageNumber,
                   String recipient,
                   String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
    }

    // Generate Message ID
    private String generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L +
                        (long)(random.nextDouble() * 8999999999L);

        return String.valueOf(number);
    }

    // Check Message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check Recipient Cell
    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted " +
                "or does not contain an international code. " +
                "Please correct the number and try again.";
    }

    // Check Message Length
    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";
        }

        int excess = message.length() - 250;

        return "Message exceeds 250 characters by "
                + excess +
                "; please reduce the size.";
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord =
                words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) +
                ":" +
                messageNumber +
                ":" +
                firstWord +
                lastWord;
    }

    // Send Message
    public String sentMessage(int option) {

        switch (option) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Print Message Details
    public String printMessages() {

        return "Message ID: " + messageID +
                "\nMessage Hash: " + createMessageHash() +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }

    // Return Total Messages
    public static int returnTotalMessages() {

        return totalMessages;
    }
}