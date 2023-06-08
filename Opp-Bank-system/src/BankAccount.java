import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

abstract class BankAccount implements Serializable{
    private String name;
    private int age;
    private int accountNumber;
    private int accountBalance;

private String id;


    // Constructors
    BankAccount(){
   
    }

    BankAccount(String name, int age, int accountNumber) {
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    BankAccount(String name, int age, int accountNumber, int accountBalance) {
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;  
         }       
           
        BankAccount( String accountNumber) throws FileNotFoundException, IOException  
         { 
         }
   
        public  void setName( String name) {
            this .name=name;
      
          }

        public void setAge(int age) {
            this. age=age;
          }

        public void setAccountNumber( int  setAccountNumber) {
              this. accountNumber=setAccountNumber;
             }

        public void  setAccountBalance(int accountBalance ) {
            this. accountBalance=accountBalance;
        }
            
    // Getters
   public String getName() {
        return name;
    }

   public int getAge() {
        return age;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
    
    
     // Methods
    abstract void displayDetails();

    abstract void withdrawAmount(int amount);

    abstract void addMoney(int amount);
}