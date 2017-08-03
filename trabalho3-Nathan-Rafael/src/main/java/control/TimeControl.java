/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Set;
import model.Client;

/**
 *
 * @author rafael
 */
public class TimeControl {

    private static TimeControl instance;

    public static TimeControl getTimeControl() {
        if (TimeControl.instance == null) {
            TimeControl.instance = new TimeControl();
        }
        return TimeControl.instance;
    }

    public void turnMonth(Set<Client> clientsList) {
        for (Client client : clientsList) {
            client.getCard().generateInterest();
        }
    }
}
