package com.company.Classes;

import com.company.Interfaces.IAccount;

public class BasicAccount implements IAccount {

    private int AccountNumber;
    private double WithdrawalLimit;
    private double TotalAmount;

    public  BasicAccount(int accountNumber, double withdrawalLimit)
    {
        AccountNumber = accountNumber;
        WithdrawalLimit = withdrawalLimit;
    }

    public void Deposit(double amount){
        TotalAmount = amount;
    }
    public double Withdraw(double amount){
        double withdraw = 0.0;
        if(AccountHasEnoughMoney(amount)) {
            if (AmountIsLessThanWithdrawalLimit(amount)) {
                withdraw = amount;
            } else {
                withdraw = WithdrawalLimit;
            }
            TotalAmount = TotalAmount-withdraw;
        }
        return withdraw;
    }

    private Boolean AmountIsLessThanWithdrawalLimit(double amount)
    {
        if(amount <= WithdrawalLimit)
        {
            return true;
        }
        return  false;
    }

    private  boolean AccountHasEnoughMoney(double amount)
    {
        if(amount >= TotalAmount)
        {
            return  true;
        }
        return  false;
    }
    public double GetCurrentBalance()
    {
        return  TotalAmount;
    }
    public int GetAccountNumber()
    {
        return AccountNumber;
    }

}
