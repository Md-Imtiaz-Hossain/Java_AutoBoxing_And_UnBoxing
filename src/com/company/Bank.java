package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }


    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null){
            return existingBranch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){

        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null){
            return existingBranch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }



    public boolean listCustomers(String branchName, boolean showTransaction){
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null){
            System.out.println("Customer details in the branch of- " + existingBranch.getName());

            ArrayList<Customer> branchAllCustomers = existingBranch.getCustomers();


            for (int i = 0; i < branchAllCustomers.size(); i++) {
                        Customer branchOneCustomer = branchAllCustomers.get(i);
                        System.out.println("Customer: " + branchOneCustomer.getName() + "[" + (i+1) + "]");


                        if (showTransaction){
                            System.out.println("Transactions");
                            ArrayList<Double> allTransactions = branchOneCustomer.getTransactions();
                            for (int j = 0; j < allTransactions.size(); j++) {
                                System.out.println("[" + (i+1) + "] Amount " + allTransactions.get(j));
                            }
                        }

            }
            return true;
        }else {
            return false;
        }
    }







    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size() ; i++) {
            Branch checkBranch = this.branches.get(i);
            if (checkBranch.getName().equals(branchName)){
                return checkBranch;
            }
        }
        return null;
    }
}
