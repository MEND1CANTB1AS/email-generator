package emailapp;

import org.javatuples.Pair;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Email {
  // private String firstName;
  //private String lastName;
  private String password;
  private String emailNumber;
  private String email;
  private int defaultPasswordLength = 10;
  private int emailNumeberLength = 4;
  private String schoolSuffix = "byui.edu";
  //private String alternateEmail;

  //Constructor to receive the first naem and last name
  public Email(String firstName, String lastName) {
    char firstNameLetter = firstName.charAt(0);
    firstNameLetter = Character.toLowerCase(firstNameLetter);
    //this.lastName = lastName;
    //System.out.println("Email Created: " + firstNameLetter + this.lastName); 
  
    //Call a method to generate a random 4 digit number
    this.emailNumber = setEmailNumber(emailNumeberLength);
    //System.out.println("Number: " + this.emailNumber);

    //Call a method that ruturns a random password
    this.password = randomPassword(defaultPasswordLength);
    //System.out.println("Your password is: " + this.password);

    //Combine elements to generate email
    email = firstNameLetter + lastName.toLowerCase() + "." + emailNumber + "@" + schoolSuffix;
    //System.out.println("Your email is: " + email);

    //Create tuple
    Pair<String, String> et = Pair.with(email, password);
    System.out.println(et);

    //Save to a file
    Pair<String, String> ep = et;
    writeUsingFileWirter(ep);

    //Sort the file alphabetically
    try {
      sortFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
  private static void writeUsingFileWirter(Pair<String, String> ep) {
    File file = new File("email.txt");
    FileWriter fr = null;
    try{
      fr = new FileWriter(file, true);
      fr.write(ep.toString());
      fr.write("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      //close resources
      try {
        fr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  public static void sortFile() throws IOException {     
    FileReader fileReader = new FileReader("email.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    List<String> lines = new ArrayList<String>();
    String line = null;
    while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
    }
    bufferedReader.close();

    Collections.sort(lines, Collator.getInstance());

    FileWriter writer = new FileWriter("email.txt"); 
    for(String str: lines) {
      writer.write(str + "\r\n");
    }
    writer.close();
  }
}