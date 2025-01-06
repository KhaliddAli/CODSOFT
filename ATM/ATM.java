package ATM;
import java.util.*;
public class ATM {
    static AccountDB accountDB = new AccountDB();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("If you are already registered enter 1 else enter 0");
        int response = sc.nextInt();

        if(response==0){
            System.out.println("Please enter the amount to deposit as an initial balance: ");
            long bal = sc.nextLong();
            createAccount(bal);
        }
        else{
            System.out.println("Please enter your A/C number: ");
            long ac = sc.nextLong();

            if(accountDB.getAccount(ac)!=null){
                Account account = accountDB.getAccount(ac);
                chooseOperation(account);
            }
            else{
                System.out.println("Please enter a valid A/C number!");
            }

        }

    }

    public static void createAccount(long balance){
        Random random = new Random();
        long ac = random.nextLong()+1;

        while(accountDB.getAccount(ac)!=null){
            ac = random.nextLong()+1;
        }
        Account newAccount = new Account(ac,balance);
        System.out.println("Account created successfully, your new A/C number is: " + ac);
        accountDB.addAccount(newAccount);
    }

    public static void chooseOperation(Account account){
        Scanner sc = new Scanner(System.in);
        System.out.println("To check your Balance enter 1, To Withdraw money enter 2, To Deposit money enter 3: ");
        int response = sc.nextInt();

        if(response==1){
            System.out.println("Your Balance is: " + account.balance);
            System.out.println("If you wish to exit enter 0 else enter 1 to use other services: ");
            int res = sc.nextInt();
            if(res==1){
                chooseOperation(account);
            }
            else{
                System.out.println("Thank you for choosing XYZ Bank!");
            }
        }
        else if(response==2){
            withdrawMoney(account);
            System.out.println("If you wish to exit enter 0 else enter 1 to use other services: ");
            int res = sc.nextInt();
            if(res==1){
                chooseOperation(account);
            }
            else{
                System.out.println("Thank you for choosing XYZ Bank!");
            }
        }
        else if(response==3){
            depositeMoney(account);
            System.out.println("If you wish to exit enter 0 else enter 1 to use other services: ");
            int res = sc.nextInt();
            if(res==1){
                chooseOperation(account);
            }
            else{
                System.out.println("Thank you for choosing XYZ Bank!");
            }
        }
        else{
            System.out.println("Transaction failed!, enter a valid response!");
            chooseOperation(account);
        }
    }
}
