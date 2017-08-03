/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testRegister;

import control.BankControl;
import exceptions.ERefusedTransaction;
import java.util.ArrayList;
import model.BlackCard;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nathancezar
 */
public class BankTest {

    BankControl bankControl;
    BlackCard blackCard;

    @Before
    public void begin() {
        bankControl = new BankControl();
        blackCard = new BlackCard(12345, 500, 100, new ArrayList());
        blackCard.unlock();
    }

    @Test(expected = ERefusedTransaction.class)
    public void releasePurchaseTest() throws ERefusedTransaction {
        bankControl.releasePurchase(blackCard, "purchaseLocation", 800);
    }

    @Test
    public void purchaseRegistrationTest() throws ERefusedTransaction {
        bankControl.releasePurchase(blackCard, "purchaseLocation", 200);
        assertEquals((int) 200, (int) blackCard.totalSpentCalculator());
    }
}
