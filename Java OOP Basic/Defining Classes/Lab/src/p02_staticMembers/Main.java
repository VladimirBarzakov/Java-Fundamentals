package p02_staticMembers;

import p02_staticMembers.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String line;

        while (true){
            line=scanner.nextLine();
            if ("End".equals(line)){
                break;
            }
            String[] input = line.split("\\s+");
            switch (input[0]){
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(),account);
                    System.out.printf("Account %s created%n",account);
                    break;
                case "Deposit":
                    int accNumber = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    if (!accounts.containsKey(accNumber) || accounts.get(accNumber)==null){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    account = accounts.get(accNumber);
                    account.deposit(amount);
                    System.out.printf("Deposited %.0f to %s%n",amount,accounts.get(accNumber));
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    accNumber = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if (!accounts.containsKey(accNumber) || accounts.get(accNumber)==null){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    account = accounts.get(accNumber);
                    System.out.printf("%.2f%n",account.getInterest(years));
                    break;
            }
        }

    }
}
