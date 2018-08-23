package p04_shopping_spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> productBag;


    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.productBag=new ArrayList<>();
    }

    private void setName(String name){
        if (name.isEmpty() || name.trim().length()==0){
            throw  new IllegalArgumentException("Name cannot be empty");
        }
        this.name=name;
    }

    private void setMoney(int money){
        if (money<0){
            throw  new IllegalArgumentException("Money cannot be negative");
        }
        this.money=money;
    }

    public boolean buyProduct(Product product){
        if (this.money<product.getCost()){
            return false;
        }

        this.money-=product.getCost();
        this.productBag.add(product);
        return true;
    }

    public String getName() {
        return this.name;
    }


    public List<Product> getProductBag() {
        return Collections.unmodifiableList(this.productBag);
    }
}
