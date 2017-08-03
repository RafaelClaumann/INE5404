/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.EInvalidRequest;
import interfaces.Card;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;
import model.Ticket;

/**
 *
 * @author rafael
 */
public class TicketControl implements Serializable {

    public Ticket generateTicket(Card card) throws EInvalidRequest {
        if (!(card.getSpent() <= 0)) {
            Random random = new Random();
            DecimalFormat decimalFormat = new DecimalFormat("%.2f");
            return new Ticket("Total da Fatura: R$" + String.format("%.2f", card.getSpent())
                    + "  Código de Barras: \n" + random.nextInt(99999)
                    + "." + random.nextInt(99999) + " " + random.nextInt(99999)
                    + "." + random.nextInt(999999) + " " + random.nextInt(99999)
                    + "." + random.nextInt(999999) + " " + random.nextInt(9) + " "
                    + random.nextInt(9999) + "000000" + ((int) card.getSpent()));
        }
        throw new EInvalidRequest();
    }

}
