/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import cardStates.UnlockedCard;
import exceptions.ERefusedTransaction;
import exceptions.EOverExpectedPayment;
import exceptions.EWrongPassword;
import interfaces.Card;
import interfaces.IBankControl;
import interfaces.ICardStates;
import model.ItemPurchased;

/**
 *
 * @author nathancezar
 */
public class BankControl implements IBankControl {

    private static BankControl instance;
    private static final String password = "12345";

    public static BankControl getBankControl() {
        if (BankControl.instance == null) {
            BankControl.instance = new BankControl();
        }
        return BankControl.instance;
    }

    @Override
    public void passwordCheck(String password) throws EWrongPassword {
        if (!BankControl.password.equalsIgnoreCase(password)) {
            throw new EWrongPassword();
        }
    }

    @Override
    public void unlockCard(Card card) throws NullPointerException {
        if (!(card.getState() instanceof UnlockedCard)) {
            card.unlock();
        }
    }

    @Override
    public void lockCard(Card card) throws NullPointerException {
        if (!(card.getState() instanceof UnlockedCard)) {
            card.lock();
        }
    }

    @Override
    public ICardStates checkCardState(Card card) {
        return card.getState();
    }

    @Override
    public boolean checkLimit(Card card, double purchaseValue) {
        return (purchaseValue + card.getSpent()) <= card.getLimit();
    }

    @Override
    public void registerNewItem(Card card, String purchaseLocation, double itemValue) {
        card.getItems().add(new ItemPurchased(purchaseLocation, itemValue));
    }

    @Override
    public void registerPayment(Card card, double paymentValue) throws EOverExpectedPayment {
        if (!(paymentValue >= card.getSpent())) {
            card.setSpent(card.getSpent() - paymentValue);
        } else {
            card.setSpent(0);
            throw new EOverExpectedPayment();
        }
    }

    @Override
    public void releasePurchase(Card card, String purchaseLocation, double purchaseValue) throws ERefusedTransaction {
        if ((checkLimit(card, purchaseValue) && checkCardState(card) instanceof UnlockedCard)) {
            card.setSpent(card.getSpent() + purchaseValue);
            registerNewItem(card, purchaseLocation, purchaseValue);
        } else {
            throw new ERefusedTransaction();
        }
    }
}
