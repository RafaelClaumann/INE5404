/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concrete;

import interfaces.Strategy;

/**
 *
 * @author rafael
 */
public class OperationSubstract implements Strategy {

    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }

}
