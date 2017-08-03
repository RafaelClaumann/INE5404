/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Card;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nathancezar
 */
public class Client implements Serializable {

    private String name;
    private int cpf;
    private Card card;
    private double income;
    private ArrayList<Ticket> tickets = new ArrayList();

    public Client(String name, int cpf, Card card, double income) {
        this.name = name;
        this.cpf = cpf;
        this.card = card;
        this.income = income;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "name: " + name + ", cpf: " + cpf + ",income: " + income + "\ncard: " + card;
    }
}
