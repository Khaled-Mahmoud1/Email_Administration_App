package io.github.khaled_mahmoud1.emailadmin;

import java.security.SecureRandom;


public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final Department department;
    private final String email;
    private int mailboxCapacity = 200;
    private String alternateEmail;
    private static final int defaultPasswordLength = 10;
    private static final String companySuffix = "@company.com";

    // Constructor for first & last name
    public Email(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        System.out.println("Email created : " + this.firstName + " " + this.lastName);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is : " + this.password);


        this.email = buildEmail();
        System.out.println("Your Email address is : " + email);

    }

    // Build email
    private String buildEmail() {
        String deptPart = (department == Department.NONE) ? "" : "." + department.name().toLowerCase();
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + deptPart + companySuffix;
    }

    // Generate random password (Secure)
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!$#@%";
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = passwordSet.charAt(random.nextInt(passwordSet.length()));
        }
        return new String(password);
    }

    // Setters
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    // Getters
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD: " + getPassword() +
                "\nMAILBOX CAPACITY: " + getMailboxCapacity() + "mb" +
                "\nALTERNATE EMAIL: " + getAlternateEmail();
    }

}
