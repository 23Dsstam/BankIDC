package com.company.Classes;

import com.company.Interfaces.IAccount;

public class StandardAccount implements IAccount {

    private int AccountNumber;
    private double CreditLimit;
    private double TotalAmount;

    public StandardAccount(int accountNumber, double creditLimit) {
        AccountNumber = accountNumber;
        SetCreditLimit(creditLimit);
    }

    private boolean CreditLimitIsNegative(double creditLimit)
    {
        if(creditLimit > 0)
        {
            return true;
        }
        return false;
    }

    private void SetCreditLimit(double creditLimit)
    {
        if(CreditLimitIsNegative(creditLimit)) {
            CreditLimit = creditLimit;
        }else
        {
            CreditLimit = 0;
        }
    }

    public void Deposit(double amount){
        TotalAmount = amount;
    }
    public double Withdraw(double amount){
        double withdraw = 0.0;
        if(AccountHasEnoughMoney(amount)) {
            if (AmountIsLessThanCreditLimit(amount)) {
                withdraw = amount;
            } else {
                withdraw = CreditLimit;
            }
            TotalAmount = TotalAmount-withdraw;
        }
        return withdraw;
    }

    private Boolean AmountIsLessThanCreditLimit(double amount)
    {
        if(amount <= CreditLimit)
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
    public double GetCurrentBalance(){
        return TotalAmount;
    }
    public int GetAccountNumber(){
        return AccountNumber;
    }


}
