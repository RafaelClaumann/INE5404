/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.EOverExpectedPayment;
import exceptions.ERefusedTransaction;
import exceptions.EWrongPassword;

/**
 *
 * @author rafael
 */
public interface IBankControl {

    public void passwordCheck(String password) throws EWrongPassword;

    public void unlockCard(Card card) throws NullPointerException;

    public void lockCard(Card card) throws NullPointerException;

    public ICardStates checkCardState(Card card);

    public boolean checkLimit(Card card, double purchaseValue);

    public void registerNewItem(Card card, String purchaseLocation, double itemValue);

    public void registerPayment(Card card, double paymentValue) throws EOverExpectedPayment;

    public void releasePurchase(Card card, String purchaseLocation, double purchaseValue) throws ERefusedTransaction;
}
