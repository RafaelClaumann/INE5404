/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testRegister;

import cardStates.LockedCard;
import java.util.ArrayList;
import model.BlackCard;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rafael
 */
public class CardTest {

    BlackCard blackCard;

    @Before
    public void begin() {
        blackCard = new BlackCard(12345, 500, 200, new ArrayList());
    }

    @Test
    public void cardLimitTest() {
        assertEquals((int) 300, (int) blackCard.avaibleLimit());
    }

    @Test
    public void testCardStatus() {
        assertTrue(blackCard.getState() instanceof LockedCard);
    }

}
