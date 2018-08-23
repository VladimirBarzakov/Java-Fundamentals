package p01_bankAccount;

import p01_bankAccount.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Map<Integer, BankAccount> accountMap = new HashMap<>();

        String line;
        while (true){
            line=reader.nextLine();
            if ("End".equals(line)){
                break;
            }

            String[] input = line.split("\\s+");
            int accNumber = Integer.parseInt(input[1]);
            double amount =0;
            if (input.length==3){
                amount = Double.parseDouble(input[2]);
            }
            switch (input[0]){
                case "Create":
                    if (accountMap.containsKey(accNumber) || accountMap.get(accNumber)!=null){
                        System.out.println("Account already exists");
                        continue;
                    }
                    accountMap.put(accNumber, new BankAccount(accNumber));
                    break;
                case "Deposit":
                    if (!accountMap.containsKey(accNumber) || accountMap.get(accNumber)==null){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    accountMap.get(accNumber).deposit(amount);
                    break;
                case "Withdraw":
                    if (!accountMap.containsKey(accNumber) || accountMap.get(accNumber)==null){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    BankAccount account = accountMap.get(accNumber);
                    if (account.getBalance()<amount){
                        System.out.println("Insufficient balance");
                        continue;
                    }
                    account.withdraw(amount);
                    break;
                case "Print":
                    if (!accountMap.containsKey(accNumber) || accountMap.get(accNumber)==null){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    account = accountMap.get(accNumber);
                    System.out.printf("Account ID%d, balance %.2f%n",account.getId(),account.getBalance());
                    break;
            }
        }
    }

}
