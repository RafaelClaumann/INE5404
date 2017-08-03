/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import cardStates.LockedCard;
import java.io.Serializable;
import java.util.ArrayList;
import model.ItemPurchased;

/**
 *
 * @author nathancezar
 */
public abstract class Card implements Serializable {

    private String ownerName;
    private int number;
    private double limit;
    private double spent;
    private ArrayList<ItemPurchased> items = new ArrayList();
    protected ICardStates state;

    public Card() {
        this.state = new LockedCard();
    }

    public Card(String ownerName, double limit) {
        this.ownerName = ownerName;
        this.limit = limit;
        this.state = new LockedCard();
    }

    public Card(int number, double limit, double spent, ArrayList items) {
        this.number = number;
        this.limit = limit;
        this.spent = spent;
        this.items = items;
        this.state = new LockedCard();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    public ArrayList<ItemPurchased> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPurchased> items) {
        this.items = items;
    }

    public void lock() {
        this.state = this.state.lock();
    }

    public void unlock() {
        this.state = this.state.unlock();
    }

    public ICardStates getState() {
        return state;
    }

    public void setState(ICardStates state) {
        this.state = state;
    }

    public double totalSpentCalculator() {
        double totalSpent = 0;
        for (ItemPurchased item : items) {
            totalSpent += item.getValue();
        }
        return totalSpent;
    }

    public String cardStatement(Card card) {
        String statement = "";
        for (ItemPurchased item : card.getItems()) {
            statement += "Local da compra: " + item.getLocation() + ", Valor da compra: R$" + item.getValue() + "\n";
        }
        return statement;
    }

    public double avaibleLimit() {
        return this.limit - this.spent;
    }

    /**
     *
     */
    public abstract void generateInterest();

    @Override
    public String toString() {
        return "Owner: " + ownerName + ", number: " + number + ", limit: " + limit;
    }
}
