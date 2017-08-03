/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.simples;

/**
 *
 * @author martin
 */
public class Porta {

    public enum EstadoPorta {
        Aberta, Fechada, Trancada,
    }
    private EstadoPorta estado;

    public Porta() {
        this.estado = EstadoPorta.Aberta;
    }

    public void abre() {
        switch (this.estado) {
            case Aberta:
                System.out.println("A porta já está aberta!");
                break;
            case Fechada:
                System.out.println("Abriu!");
                this.estado = EstadoPorta.Aberta;
                break;
            case Trancada:
                System.out.println("A porta deve ser primeiro destrancada!");               
                break;
        }
    }

    public void fecha() {              
        switch (this.estado) {
            case Aberta:
                System.out.println("Fechou!");
                this.estado = EstadoPorta.Fechada;
                break;
            case Fechada:
                System.out.println("A porta já está fechada!");
                break;
            case Trancada:
                System.out.println("A porta já está fechada!");              
                break;
        }
    }

    public void tranca() {
        switch (this.estado) {
            case Aberta:
                System.out.println("A porta deve ser primeiro fechada!");
                break;
            case Fechada:
                this.estado = EstadoPorta.Trancada;
                System.out.println("Trancou!");
                break;
            case Trancada:
                System.out.println("A porta já está trancada!");
                break;           
        }
    }

    public void destranca() {
        switch (this.estado) {
            case Aberta:
                System.out.println("A porta deve ser primeiro fechada!");
                break;
            case Fechada:
                System.out.println("A porta deve ser primeiro trancada!");
                break;
            case Trancada:
                System.out.println("Destrancou!");
                this.estado = EstadoPorta.Fechada;
                break;
        }
    }
}