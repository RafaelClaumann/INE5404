/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Card;
import java.util.ArrayList;

/**
 *
 * @author nathancezar
 */
public class BlackCard extends Card {

    public BlackCard() {

    }

    public BlackCard(String ownerName, double limit) {
        super(ownerName, limit);
    }

    public BlackCard(int number, double limit, double spent, ArrayList items) {
        super(number, limit, spent, items);
    }

    @Override
    public void generateInterest() {
        if (this.getSpent() > 0) {
            this.setSpent(this.getSpent() + (this.getSpent() * 5) / 100);
        }
    }
}
