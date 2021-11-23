package com.company.Classes;

import com.company.Interfaces.IAccount;

public class PremiumAccount implements IAccount {

    private  int AccountNumber;
    private  double TotalAmount;

    public PremiumAccount(int accountNumber)
    {
        AccountNumber = accountNumber;
    }

    public void Deposit(double amount){
        TotalAmount = TotalAmount + amount;
    }

    public double Withdraw(double amount){
        double withdraw = 0.0;
        if(AccountHasEnoughMoney(amount))
        {
            TotalAmount = TotalAmount-amount;
            withdraw = amount;
        }
        else
        {
            TotalAmount = 0.0;
            withdraw = TotalAmount;
        }
        return withdraw;
    }

    private  boolean AccountHasEnoughMoney(double amount)
    {
        if(amount >= TotalAmount)
        {
            return  true;
        }
        return  false;
    }

    public double GetCurrentBalance(){
        return  TotalAmount;
    }

    public int GetAccountNumber(){
        return AccountNumber;
    }
}
