/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.view;

import ine5404.Graphics.InitialFrame;
import ine5404.context.Context;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {
        Context ct = new Context();
        new InitialFrame(ct).setVisible(true);
    }
}
