package com.company.Classes;
import com.company.Interfaces.IAccount;
import com.company.Interfaces.IBank;
import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> Accounts;
    private List<IAccount> AccountsInDebt;

    public Bank()
    {
        Accounts = new ArrayList<IAccount>();
        AccountsInDebt = new ArrayList<IAccount>();
    }

    public void OpenAccount(IAccount account)
    {
        if(!Accounts.contains(account))
        {
            Accounts.add(account);
        }
    }

    public void CloseAccount(int accountNumber)
    {
        if(AccountNumberExists(accountNumber))
        {
            if(BalanceIsPositive(accountNumber))
            {
                RemoveAccount(accountNumber);
            }
            else
            {
                System.out.println("You cannot remove the account number " +
                        accountNumber + " because it has a negative balance");
            }
        }
    }

    private void RemoveAccount(int accountNumber)
    {
        for (int accountIndex = 0; accountIndex< Accounts.size(); accountIndex++)
        {
            if(Accounts.get(accountIndex).GetAccountNumber() == accountNumber)
            {
                IAccount accountToDelete = Accounts.get(accountIndex);
                Accounts.remove(accountToDelete);
            }
        }
    }

    private boolean BalanceIsPositive(int accountNumber)
    {
        IAccount account = GetAccount(accountNumber);
        if(account.GetCurrentBalance() >= 0)
        {
            return true;
        }
        return  false;
    }

    private IAccount GetAccount(int accountNumber)
    {
        IAccount account = null;
        for (int accountIndex = 0; accountIndex< Accounts.size(); accountIndex++)
        {
            if(Accounts.get(accountIndex).GetAccountNumber() == accountNumber)
            {
                account = Accounts.get(accountIndex);
            }
        }
        return account;
    }

    private boolean AccountNumberExists(int accountNumber)
    {
        for (int accountIndex = 0; accountIndex< Accounts.size(); accountIndex++)
        {
            if(Accounts.get(accountIndex).GetAccountNumber() == accountNumber)
            {
                return  true;
            }
        }
        return  false;
    }

    public List<IAccount> GetAllAccounts()
    {
        return Accounts;
    }

    public List<IAccount> GetAllAccountsInDebt()
    {
        return GetAccountsInDebt();
    }

    private List<IAccount> GetAccountsInDebt()
    {
        List<IAccount> accountsInDebt = new ArrayList<IAccount>();
        for (int accountIndex = 0; accountIndex < Accounts.size(); accountIndex++)
        {
            IAccount account = Accounts.get(accountIndex);
            if(account.GetCurrentBalance() < 0)
            {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        return GetAccountsWithBalance(balanceAbove);
    }

    private List<IAccount> GetAccountsWithBalance(double balance)
    {
        List<IAccount> accountsWithBalance = new ArrayList<IAccount>();
        for (int accountIndex = 0; accountIndex < Accounts.size(); accountIndex++)
        {
            IAccount account = Accounts.get(accountIndex);
            if(account.GetCurrentBalance() > balance)
            {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}
