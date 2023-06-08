import java.io.BufferedReader;
import java.io.File;import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class Current extends BankAccount implements Serializable {

    int accountNumber = getAccountNumber();
    int accountBalance = getAccountBalance();
    String name = getName();
    int age = getAge();

    Current(String name, int age, int accountNumber, int accountBalance) throws FileNotFoundException, Exception, IOException, ClassNotFoundException {
        super(name, age, accountNumber, accountBalance);

    }

    Current() {
    }

    Current(String name, int age, int accountNumber) throws FileNotFoundException, IOException, ClassNotFoundException {
    }

    Current(String name) throws IOException {
        super(name);
        // edit();
    }
     void displayDetails() {
        System.out.println("Account Holder Details");
        System.out.println("Name : " + this.name);
        System.out.println("Age of the account holder : " + this.age);
        System.out.println("Account Number : " + this.accountNumber);
       // System.out.println("Account Type: " + this.accountType);
        System.out.println("Account Balance : " + this.accountBalance);
        System.out.println();
    }

    void withdrawAmount(int amount) {
        if (accountBalance < amount) {
            System.out.println("Not enough Balance\nCurrent account balance is: " + accountBalance);
            return;
        }

            accountBalance -= amount;//accountBalance=accountBalance-amount
            System.out.println("Amount Received : " + amount);
            System.out.println("Current account Balance: " + accountBalance);
    }

    void addMoney(int amount) {
        this.accountBalance += amount;//accountBalance=accountBalance+amount
    }
}