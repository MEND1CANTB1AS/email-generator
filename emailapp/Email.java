package emailapp;

import java.util.Scanner;

public class Email {
  private String firstName;
  private String lastName;
  private String password;
  private String emailNumber;
  private String email;
  private int mailboxCapacity;
  private int defaultPasswordLength = 10;
  private int emailNumeberLength = 4;
  private String schoolSuffix = "byui.edu";
  //private String alternateEmail;

  //Constructor to receive the first naem and last name
  public Email(String firstName, String lastName) {
    char firstNameLetter = firstName.charAt(0);
    firstNameLetter = Character.toLowerCase(firstNameLetter);
    this.lastName = lastName;
    //System.out.println("Email Created: " + firstNameLetter + this.lastName); 
  
    //Call a method to generate a random 4 digit number
    this.emailNumber = setEmailNumber(emailNumeberLength);
    //System.out.println("Number: " + this.emailNumber);

    //Call a method that ruturns a random password
    this.password = randomPassword(defaultPasswordLength);
    System.out.println("Your password is: " + this.password);

    //Combine elements to generate email
    email = firstNameLetter + lastName.toLowerCase() + "." + emailNumber + "@" + schoolSuffix;
    System.out.println("Your email is: " + email);
  }
  //Generate random 4 digit number
  private String setEmailNumber(int length) {
    String numberSet = "1234567890";
    char[] emailNumber = new char[length];
    for (int i=0; i<length; i++) {
      int rand = (int) (Math.random() * numberSet.length());
      emailNumber[i] = numberSet.charAt(rand);
    }
    return new String(emailNumber);
  }
      //System.out.println(rand);
  
  

  //Generate a random password
  private String randomPassword(int length) {
    String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
    char[] password = new char[length];
    for (int i=0; i<length; i++) {
      int rand = (int) (Math.random() * passwordSet.length());
      password[i] = passwordSet.charAt(rand);
      //System.out.println(rand);
      //System.out.println(passwordSet.charAt(rand));
    }
    return new String(password);
  }
  //Set mailbox capacity

  //Set the alternate email

  //Change the password
}