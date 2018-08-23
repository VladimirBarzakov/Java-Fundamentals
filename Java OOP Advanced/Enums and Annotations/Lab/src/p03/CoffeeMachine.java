package p03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {
    private int collectedMoney;
    private List<Coffee> soldCoffees;

    public CoffeeMachine() {
        this.collectedMoney = 0;
        this.soldCoffees=new ArrayList<>();
    }

    public void insertCoin(String coin){
        int coinValue = Coin.valueOf(Coin.class, coin).getValue();
        this.collectedMoney+=coinValue;
    }


    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size, type);
        if (collectedMoney>=coffee.getSize().getC()){
            this.soldCoffees.add(coffee);
            this.collectedMoney=0;
        }
    }

    public Iterable<Coffee> coffeesSold(){
        return Collections.unmodifiableList(this.soldCoffees);
    }
}
