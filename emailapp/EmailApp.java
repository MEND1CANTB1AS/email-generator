package emailapp;

import java.util.Scanner;

public class EmailApp {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the student's last name: ");
        String lastName = scan.nextLine();

        System.out.println("Please enter the student's first name: ");
        String firstName = scan.nextLine();
        System.out.println();
        // public static void main(String[] args) {
        Email em1 = new Email(firstName,lastName);        
        scan.close();
        }
}

