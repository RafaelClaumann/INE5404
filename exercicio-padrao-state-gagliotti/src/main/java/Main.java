
import ine5404.porta.state.PortaContext;
import ine5404.simples.Porta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class Main {
    public static void main(String args[]){
        Porta porta1 = new Porta();
        PortaContext porta2 = new PortaContext();
        
        System.out.println("Porta simples");
        porta1.tranca();
        porta1.abre();
        porta1.fecha();
        porta1.destranca();
        porta1.tranca();
        porta1.abre();
        porta1.destranca();
        porta1.abre();
        
        
        System.out.println("\n\nPorta com padrão state");
        porta2.tranca();
        porta2.abre();
        porta2.fecha();
        porta2.destranca();
        porta2.tranca();
        porta2.abre();
        porta2.destranca();
        porta2.abre();
    }
}
