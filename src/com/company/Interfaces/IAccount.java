package com.company.Interfaces;

public interface IAccount {

    void Deposit(double amount);
    double Withdraw(double amount);
    double GetCurrentBalance();
    int GetAccountNumber();

}
