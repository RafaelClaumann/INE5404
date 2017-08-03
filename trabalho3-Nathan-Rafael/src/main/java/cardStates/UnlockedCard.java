/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardStates;

import interfaces.ICardStates;
import java.io.Serializable;

/**
 *
 * @author rafael
 */
public class UnlockedCard implements ICardStates, Serializable {

    @Override
    public ICardStates unlock() {
        System.out.println("cartão ja esta desbloqueado!");
        return this;
    }

    @Override
    public ICardStates lock() {
        System.out.println("Cartão bloqueado!");
        return new UnlockedCard();
    }

    @Override
    public String toString() {
        return "Cartão Desbloquado";
    }
}
