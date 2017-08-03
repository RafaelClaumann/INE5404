/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.context;

import ine5404.exceptions.ESizeLimiter;
import java.io.IOException;
import java.io.FileNotFoundException;
import ine5404.interfaces.IBehaviour;
import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public class Context {

    private IBehaviour behaviour;

    public void setBehaviour(IBehaviour gameInterface) {
        this.behaviour = gameInterface;
    }

    public IBehaviour getBehaviour() {
        return behaviour;
    }

    public void startGame() throws IOException, FileNotFoundException, ClassNotFoundException, ESizeLimiter {
        behaviour.startGame(0, 0);
    }

    public char[][] getBoard() {
        return behaviour.returnBoard();
    }

    public ArrayList getWords() {
        return behaviour.returnWords();
    }

}
