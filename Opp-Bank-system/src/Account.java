
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Account {
        
           // static variable used to call it without create an instance from this class
            static  Scanner inputNumber;// this object used to ask the user to enter input whitch type is number as age , balance ...
            static Scanner stringInput;//  this object used to ask the user to enter input whitch type is string as name
            ArrayList<Current> al;
           // int  [] array=new int[5];
            
            File file;
            ObjectOutputStream objectOutputStream ;// the object use to read objects from  the file  
            ObjectInputStream objectInputStream ;// the object use to write objects to  the file
            ListIterator li;// the object used to get elements of arraylist
    //Account ob1= new Account();
    Account() throws FileNotFoundException, IOException, ClassNotFoundException{
           
            //  construct to initialize class variables
            inputNumber=new Scanner(System.in);
            stringInput=new Scanner(System.in);
            al=new ArrayList<Current>();
             file= new File("Data Base.txt");
            objectOutputStream=null ;   
            objectInputStream =null;
            li=null;
            if(file.isFile()){// if the file is exist the open it using objectInputStream and read it's content to arraylist using readObject method
            objectInputStream=new ObjectInputStream(new FileInputStream (file));
            al=(ArrayList<Current>)objectInputStream.readObject();
            //close the object that deal with files ( read from or write to)
            objectInputStream.close();} 
            }
    public  void message(){
           // the avaliable choices th the user
           System.out.println("###########################################");   
           System.out.println(" 1 - Add New Accounts ");
           System.out.println(" 2 - Display All Accounts Information ");
           System.out.println(" 3 - Edit Information of Spesific Account");
           System.out.println(" 4 - Delete Account From the File");
           System.out.println(" 5 - Deposit");
           System.out.println(" 6 - Withdraw");
           System.out.println(" 7 - Transfer");
           System.out.println(" 8 - Check account information ...");
           System.out.println(" 9 - Exit ...");
           System.out.println("###########################################");     
           System.out.println(" Enter you choice");

}
    public void add(Account account, int n) throws Exception{
     //  Account account=new Account();
    // for loop to create n account 
           for(int i=0;i<n;i++){
             System.out.println(" Enter Accout Number");
             // ask the user to enter new account number                       
             int accountNumber=inputNumber.nextInt();
             System.out.println(" Enter Accout User Name");
             // ask the user to enter new account user name                        
             String name=account.stringInput.nextLine();
             System.out.println(" Enter  Age");
             // ask the user to enter new account user age  
             int age=inputNumber.nextInt();
             System.out.println(" Enter Accout Balance");
             // ask the user to enter new account user balance  
             int Balance=inputNumber.nextInt();
             System.out.println("-------------------------------------------");
             System.out.println("welcome to uqu Bank");   
             System.out.println("the Acouunt is crated Successfuly ");   
             System.out.println("-------------------------------------------");
             // add new object created from current class to the arraylist
             account.al.add(new Current(name,age,accountNumber,Balance));           
           }
             // after add all accounts to araylist the we open file to write on using objectOutputStream
             account.objectOutputStream=new ObjectOutputStream(new FileOutputStream (account.file));
             // write all arraylist content into the opened file 
             account.objectOutputStream.writeObject(account.al);
             //close the file
             account. objectOutputStream.close();
    
    }   
    public void edit(int accNumb, String name, int age,int Balance) throws IOException, Exception{
            
             System.out.println("-------------------------------------------");
             boolean found=false;
             // cope arraylist elements to listIterator to get each object from retrieved data
             li=al.listIterator();
             while(li.hasNext()){// get objects one by one
                Current c=(Current) li.next();
                if(c.getAccountNumber()==accNumb){  
                //if the account is found then we replace the old information by the new information using set method
                li.set(new Current(name,age,accNumb,Balance));
                found=true;// set the flag to true
               }
              }       
             if(found==true){
                // after we found account and edited  account inforamation  in araylist then we open file to write on 
                objectOutputStream=new ObjectOutputStream(new FileOutputStream (file));
                // write  arraylist  after edit account information content into the opened file 
                objectOutputStream.writeObject(al);
                //close the file 
                objectOutputStream.close();
                System.out.println(" Account was Edited Successfuly");
                }
             else{

               System.out.println(" Account was not found");    
              }
              
    }
    public void search(int accNumb) throws FileNotFoundException, IOException, ClassNotFoundException{
             
                    System.out.println("-------------------------------------------");
                    boolean found=false;
                    li=al.listIterator();// get arraylist element
                    while(li.hasNext()){// get arraylist element one by one
                       Current c=(Current) li.next();
                       if(c.getAccountNumber()==accNumb){ // if account is found  we will print it's details
                       c.displayDetails();
                       found=true;
                      }
                     }       
                    if(found){
                       System.out.println(" Account was found");
                       }
                    else{
                         
                      System.out.println(" Account was not found");   
                     }
                     

    }
    public void delete(int accNumb) throws FileNotFoundException, IOException, ClassNotFoundException{
                         
                            System.out.println("-------------------------------------------");
                            boolean found=false;                       
                            li=al.listIterator();
                         while(li.hasNext()){

                           Current c=(Current) li.next();
                           if(c.getAccountNumber()==accNumb){
                           li.remove();// this method used to remove the found element from te arraylist 
                           found=true;
                       }
                      }
                      if(found){
                            // if the element was found and removed then we rewrite rhe arraylist into the file
                            objectOutputStream=new ObjectOutputStream(new FileOutputStream (file));// open the file to write on
                            objectOutputStream.writeObject(al);// write the arraylist elements into the file
                            objectOutputStream.close();// close the file
                            System.out.println(" Account was Deleted Successfuly");

                        }
                      else{
                            System.out.println(" Account was not found");    
                          }
                           
    
    }
    public void deposit(int accNumb, int amount) throws FileNotFoundException, IOException, Exception{   

                        System.out.println("-------------------------------------------");        
                        boolean found=false;
                        // System.out.println("-------------------------------------------");
                        li=al.listIterator();
                  while(li.hasNext()){

                         Current c=(Current) li.next();//
                         if(c.getAccountNumber()==accNumb){
                         c.addMoney(amount);// if the account is found the we call the add function to add the addition amount to the current balance
                         li.set(new Current(c.getName(),c.getAge(),c.getAccountNumber(),c.accountBalance));// replace the balance with the new value balance+ amount
                         found=true;
                         }
                        }
                       if(found){
                           // if the account is found then the arraylist with the  new balance will be writen to the file
                           objectOutputStream=new ObjectOutputStream(new FileOutputStream (file));// open the file to write on
                           objectOutputStream.writeObject(al);// write the arraylist elements into the file
                           objectOutputStream.close();// close the file
                      // System.out.println(" Deposit was Done Successfully");         
                        }
                       else{        
                          System.out.println(" Account was not found");    
                       }
               
    }
    public void withdraw (int accNumb, int amount) throws FileNotFoundException, IOException, ClassNotFoundException, Exception{
       
                   System.out.println("-------------------------------------------");
                   boolean found=false;
                    //System.out.println("-------------------------------------------");
                    li=al.listIterator();
                    while(li.hasNext()){

                    Current c=(Current) li.next();
                    if(c.getAccountNumber()==accNumb){
                   
                    Current w=new Current(c.getName(),c.getAge(),c.getAccountNumber(),c.getAccountBalance());// if the account is found the we call the withdraw function to subtract the  amount from the current balance if it is possible
                    w.withdrawAmount(amount);
                    li.set(new Current(w.getName(),w.getAge(),w.getAccountNumber(),w.accountBalance));// replace the balance with the new value balance - amount
                    found=true;
                   }
                  }
                  if(found){
                      // if the account is found and the withdraw operation was done then the arraylist with the  new balance will be writen to the file
                      objectOutputStream=new ObjectOutputStream(new FileOutputStream (file));// open the file to write on
                      objectOutputStream.writeObject(al);// write the arraylist elements into the file
                      objectOutputStream.close();// close the file
                    System.out.println(" Deposit was Done Successfully");         
                  }
                  else{
                   System.out.println(" Account was not found");    
                  }
              
    }
   public void transfer(int accNumb1, int accNumb2, int amount) throws FileNotFoundException, IOException, ClassNotFoundException{
                    Current c1=null;
                    Current c2=null;
                    boolean found1=false;
                    boolean found2=false;
                    //System.out.println("-------------------------------------------");
                    li=al.listIterator();
                    while(li.hasNext()){// get each arraylist lements one by one 

                        Current c=(Current) li.next();// make object casting
                        if(c.getAccountNumber()==accNumb1){// compare each account number in arraylist with account number that the user want to transfer money from
                           c1=c;
                           found1=true;
                        }
                        if(c.getAccountNumber()==accNumb2){//// compare each account number in arraylist with with account number that the user want to transfer money to
                            c2=c;
                            found2=true;}
                        }
                       if(found1==true&& found2==true ){// if the two account are found 
                         if (amount<=c1.getAccountBalance())// if the amount is equal or less than the account balance then we subtract the amount from account1 and add the same amount to account2
                         {c1.withdrawAmount(amount);
                         c2.addMoney( amount);
              
                         objectOutputStream=new ObjectOutputStream(new FileOutputStream (file));// open the file to write on
                         objectOutputStream.writeObject(al);// write the arraylist elements into the file
                         objectOutputStream.close();// close the file
                         System.out.println(" Transfer was Done Successfully");         
                        }
                      else{

                        System.out.println(" There is no enough balance to trancfer ");    
                      }
                       } 
                      else {
                        System.out.println(" one or both Accounts are not found ");    
                     
                       }
   }
    public static void main(String args[]) throws Exception{  
        // create object of account class to use the method of it
        Account account=new Account();
        // accNumber is the variable that use to hold account number
        int accNumb;
        // ammount variable is used to hold th  amount to deposit or withdraw or transfer
        int amount;
        // user choice 1 for create accounts, 2 for display , 3...
        int choice;
        // her infinite loop for user allow him to rehoice any choice
        do{
                account.message();
                // ask user to enter him choice
                choice = inputNumber.nextInt();
                // test user choice 
               switch(choice){
                    // the choice to create new accounts
                    case 1: System.out.println(" How many Account Do you want");
                    // n is accounts number that the user want to creat
                         int n=inputNumber.nextInt();
                         // call add function 
                         account.add(account,n);
                         break;
                    case 2:
                        // read all arraylist elements inside listIteration
                        account.li=account.al.listIterator();
                        //read arraylist elment one by one by use listItration hasNext method
                        while(account.li.hasNext()){
                           // each ret
                           Current c=(Current) account.li.next();
                          c.displayDetails();
                       // System.out.println(c.accountNumber+"      "+c.name+"      "+c.age+"      "+c.accountBalance);
                         //System.out.println("------------------------------------------");
                        }
                        break;
                    case 3: 
                        
                         System.out.println("Enter Account Number to Edit");
                         // ask user to enter account number that he want to edit its information
                         accNumb=inputNumber.nextInt();
                         System.out.println(" Enter new   Name");
                         // ask the user to enter new account user name // 
                         String name=stringInput.nextLine();
                          // ask the user to enter new account user age
                         System.out.println(" Enter new Age");
                         int age=inputNumber.nextInt();
                         // ask the user to enter new account user balance
                         System.out.println(" Enter new Balance");
                         int Balance=inputNumber.nextInt();
                         // call the function that make edit operation
                         account.edit(accNumb,name,age,Balance);
                         break;
                    case 4 : 
                         System.out.println("Enter Account Number That You Want to Delete");
                         // ask user to enter account number that he want to edit its information
                         accNumb=inputNumber.nextInt();
                         // call the function that make delete operation
                         account.delete(accNumb);
                         break;
                    case 5:
                         System.out.println("Enter Account Number that you want to  make Deposit to  ");
                          // ask user to enter account number that he want to  Deposit to
                         accNumb=inputNumber.nextInt();
                         System.out.println(" Enter amount");
                         // ask user to the amount to  Deposit
                         amount=inputNumber.nextInt();
                         // call the function that make depost operation
                         account.deposit(accNumb,amount);
                        break;
                    case 6:
                         System.out.println("Enter Account Number that you want to  make Withdraw from  ");
                         // ask user to enter account number that he want to  withdraw from
                         accNumb=inputNumber.nextInt();
                         //  ask user to the amount to  get it from the account balance
                         System.out.println(" Enter amount");
                         amount=inputNumber.nextInt();
                         account.withdraw(accNumb,amount);
                         break;
                    case 7:
                         System.out.println("Enter Account Number that you want to  Transfer Money From  ");
                         int accNumb1=inputNumber.nextInt();
                         // ask user to enter account number that he want to  transfer from 
                         System.out.println("Enter Account Number that you want to  Transfer Money To  ");
                         int accNumb2=inputNumber.nextInt();
                         // ask user to enter account number that he want to transfer to
                         System.out.println("Enter Amount  ");
                         // ask user to enter amount to transfer
                         amount=inputNumber.nextInt();
                         account.transfer(accNumb1, accNumb2, amount);
                         break;
                    case 8:
                         System.out.println("Enter Account Number That You Want to search about");
                         accNumb=inputNumber.nextInt();
                         account.search(accNumb);
                         break;
                    case 9:
                         System.exit(0);
                    default : 
                         System.out.println("Your Choice Is Not Exist");    
            }
    }while(choice!=0);
    }
     
}
