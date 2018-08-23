package p02_staticMembers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person() {
        this.accounts=new ArrayList<>();
    }

    public Person(String name, int age) {
        this(name,age,new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> accounts){
        this.name=name;
        this.age=age;
        this.accounts=accounts;
    }

    public double getBalance(){
        Optional<Double> balance = this.accounts.stream()
                .map(BankAccount::getBalance).reduce((x,y)->x+y);
        if (balance.isPresent()){
            return balance.get();
        } else{
            return 0d;
        }
    }
}
