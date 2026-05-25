package prog;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Registration
        System.out.println("===== QUICKCHAT =====");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Number: ");
        String cellPhone = scanner.nextLine();

        Login login = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhone
        );

        System.out.println(login.registerUser());

        // Login
        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Password: ");
        String enteredPassword = scanner.nextLine();

        boolean loginStatus =
                login.loginUser(
                        enteredUsername,
                        enteredPassword
                );

        System.out.println(
                login.returnLoginStatus(loginStatus)
        );

        // Continue only if login successful
        if (loginStatus) {

            System.out.println("\nWelcome to QuickChat.");

            MessageStore store = new MessageStore();

            System.out.print(
                    "How many messages would you like to send? "
            );

            int numMessages = scanner.nextInt();
            scanner.nextLine();

            int menuOption;

            do {

                System.out.println("\n===== MENU =====");

                System.out.println("1. Send Messages");
                System.out.println("2. Show Recently Sent Messages");
                System.out.println("3. Quit");

                System.out.print("Choose Option: ");

                menuOption = scanner.nextInt();
                scanner.nextLine();

                switch (menuOption) {

                    case 1:

                        for (int i = 1;
                             i <= numMessages;
                             i++) {

                            System.out.println(
                                    "\nMessage " + i
                            );

                            System.out.print(
                                    "Enter Recipient Number: "
                            );

                            String recipient =
                                    scanner.nextLine();

                            System.out.print(
                                    "Enter Message: "
                            );

                            String messageText =
                                    scanner.nextLine();

                            Message message =
                                    new Message(
                                            i,
                                            recipient,
                                            messageText
                                    );

                            System.out.println(
                                    message.checkRecipientCell()
                            );

                            System.out.println(
                                    message.checkMessageLength()
                            );

                            System.out.println(
                                    "\n1. Send Message"
                            );

                            System.out.println(
                                    "2. Disregard Message"
                            );

                            System.out.println(
                                    "3. Store Message"
                            );

                            System.out.print(
                                    "Choice: "
                            );

                            int option =
                                    scanner.nextInt();

                            scanner.nextLine();

                            String result =
                                    message.sentMessage(option);

                            System.out.println(result);

                            if (option == 1) {

                                store.addSentMessage(
                                        message.printMessages()
                                );

                            } else if (option == 2) {

                                store.addDisregardedMessage(
                                        message.printMessages()
                                );

                            } else if (option == 3) {

                                store.addStoredMessage(
                                        message.printMessages()
                                );
                            }

                            System.out.println(
                                    "\n===== MESSAGE DETAILS ====="
                            );

                            System.out.println(
                                    message.printMessages()
                            );
                        }

                        System.out.println(
                                "\nTotal Messages Sent: "
                                + Message.returnTotalMessages()
                        );

                        break;

                    case 2:

                        System.out.println("Coming Soon.");
                        break;

                    case 3:

                        System.out.println(
                                "Exiting QuickChat..."
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid option."
                        );
                }

            } while (menuOption != 3);
        }
    }
}