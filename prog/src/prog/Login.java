package prog;

import java.util.regex.Pattern;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhone;

    // Constructor
    public Login(String firstName, String lastName,
                 String username, String password,
                 String cellPhone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    // Check Username
    public boolean checkUserName() {

        return username.contains("_") &&
                username.length() <= 5;
    }

    // Check Password Complexity
    public boolean checkPasswordComplexity() {

        String regex =
                "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{8,}$";

        return Pattern.matches(regex, password);
    }

    // Check Cell Phone Number
    public boolean checkCellPhoneNumber() {

        String regex = "^\\+27\\d{9}$";

        return Pattern.matches(regex, cellPhone);
    }

    // Register User
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; " +
                    "please ensure that your username contains " +
                    "an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; " +
                    "please ensure that the password contains " +
                    "at least eight characters, a capital letter, " +
                    "a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted " +
                    "or does not contain international code.";
        }

        return "User registered successfully.";
    }

    // Login User
    public boolean loginUser(String enteredUsername,
                             String enteredPassword) {

        return username.equals(enteredUsername) &&
                password.equals(enteredPassword);
    }

    // Return Login Status
    public String returnLoginStatus(boolean loginSuccess) {

        if (loginSuccess) {

            return "Welcome " + firstName + ", " +
                    lastName +
                    " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}