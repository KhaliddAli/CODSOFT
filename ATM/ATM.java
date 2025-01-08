package ATM;
import java.util.*;
public class ATM {
    static AccountDB accountDB = new AccountDB();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while(true){
            int response = signIn();
            if(response==0) break;
        }

    }

    public static int signIn(){
        int res;
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
                res = chooseOperation(account);
                return res;
            }
            else{
                System.out.println("Please enter a valid A/C number!");
            }

        }

        System.out.println("To exit enter 0 else enter 1");
        res = sc.nextInt();
        return res;

    }

    public static void createAccount(long balance){
        Random random = new Random();
        long ac = Math.abs(random.nextLong()+1);

        while(accountDB.getAccount(ac)!=null){
            ac = random.nextLong()+1;
        }
        Account newAccount = new Account(ac,balance);
        System.out.println("Account created successfully, your new A/C number is: " + ac);
        accountDB.addAccount(newAccount);
    }

    public static int chooseOperation(Account account){
        Scanner sc = new Scanner(System.in);
        System.out.println("To check your Balance enter 1, To Withdraw money enter 2, To Deposit money enter 3: ");
        int response = sc.nextInt();

        if(response==1){
            System.out.println("Your Balance is: " + account.balance);
        }
        else if(response==2){
            System.out.println("Enter the withdraw amount: ");
            long amount = sc.nextInt();
            long balance = withdrawMoney(account,amount);

            if(balance!=0) System.out.println("Withdraw successful! Final balance is: " + balance);
        }
        else if(response==3){
            System.out.println("Enter the deposit amount: ");
            long amount = sc.nextInt();
            long balance = depositMoney(account,amount);
            System.out.println("Deposit successful! Final balance is: " + balance);
        }
        else{
            System.out.println("Transaction failed!, enter a valid response!");
        }
        System.out.println("If you wish to exit enter 0 else enter 1 to use other services: ");
        int res = sc.nextInt();
        if(res==1){
            int nm = chooseOperation(account);
        }
        else{
            System.out.println("Thank you for choosing XYZ Bank!");
        }
        return res;
    }

    public static long withdrawMoney(Account account, long amount){
        long balance = account.balance;

        if(amount>balance){
            System.out.println("Insufficient Balance");
            return 0;
        }

        balance-=amount;

        return balance;

    }

    public static long depositMoney(Account account, long amount){
        long balance = account.balance;
        balance+=amount;
        return balance;
    }
}
