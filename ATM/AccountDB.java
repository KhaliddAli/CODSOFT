package ATM;

import java.util.ArrayList;
import java.util.List;

public class AccountDB {

    List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        accounts.add(account);
    }

    public Account getAccount(long ac){
        for(Account acc : accounts){
            if(acc.ac==ac){
                return acc;
            }
        }

        return null;
    }
}
