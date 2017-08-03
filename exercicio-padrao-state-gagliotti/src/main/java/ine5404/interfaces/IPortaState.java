/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.interfaces;

/**
 *
 * @author martin
 */
public interface IPortaState {
    public IPortaState abre();
    public IPortaState fecha();
    public IPortaState tranca();
    public IPortaState destranca();
}
