package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank {
    private String name;
    private List<Account> accounts;
    private List<Customer> customers;
    private static double premi = 300.00;

    public Bank(String name) {
        this.name = name;
        accounts = new LinkedList<>();
        customers = new LinkedList<>();
    }

    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }
    public void removeAccount(Account oldAccount){
        accounts.remove(oldAccount);
    }
    public List<Account> getAccounts(){
        return accounts;
    }

    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer);
    }
    public List<Customer> getCustomers(){
        return customers;
    }

    public void showAccounts(){
        for (Account a:accounts)
            System.out.println(a);
    }

    public void revision(){
        for (Account acc:accounts)
            acc.revision();
    }
    
    public void lottery(){
        Random rand = new Random();
        List <Account> accountsList = getAccounts();
        int guanyador = rand.nextInt(accounts.size());
        accountsList.get(guanyador).deposit(premi);

    }

    public void storage(String ruta){
        try {
            FileOutputStream f = new FileOutputStream(ruta);
            ObjectOutputStream fos = new ObjectOutputStream(f);
            fos.writeObject(this);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e2){
            e2.printStackTrace();
        }
    }

    public void recovery(String ruta){
        Bank b = Bank.from_file(ruta);
        this.name = b.name;
        this.accounts = b.accounts;
        this.customers = b.customers;
    }

    public static Bank from_file(String ruta){
        Bank b = null;

        try {
            ObjectInputStream fis = new ObjectInputStream(new FileInputStream(ruta));
            b = (Bank) fis.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        } 
        return b;
    }


}
