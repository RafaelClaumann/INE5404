/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.BankControl;
import control.CardFactory;
import control.ClientControl;
import control.DatabaseControl;
import control.TicketControl;
import control.TimeControl;
import exceptions.EInvalidRequest;
import exceptions.EOverExpectedPayment;
import exceptions.ERefusedTransaction;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;

/**
 *
 * @author rafael
 */
public class ClientView {

    private static ClientControl clientControl = ClientControl.getClientControl();
    private static CardFactory cardFactory = CardFactory.getCardFactory();
    private static BankControl bankControl = BankControl.getBankControl();
    private static TimeControl timeControl = TimeControl.getTimeControl();
    private static DatabaseControl dataBaseControl = DatabaseControl.getDatabaseControl();
    private static Client client;

    public static void cardInformation() {
        System.out.println("------------ ## ------------ ## ------------ ");
        System.out.println("Títular: " + ClientView.client.getName());
        System.out.println("Limite: R$" + ClientView.client.getCard().getLimit());
        System.out.println("Gastos Totais: R$" + ClientView.client.getCard().getSpent());
        System.out.println("Estado: " + ClientView.client.getCard().getState().toString());
        System.out.println("------------ ## ------------ ## ------------ ");
    }

    public static void purchaseItem() {
        try {
            System.out.printf("Insira o local onde o item foi comprado: ");
            String purchaseLocation = new Scanner(System.in).nextLine();

            System.out.printf("Insira o valor da compra: ");
            double purchaseValue = new Scanner(System.in).nextDouble();

            bankControl.releasePurchase(ClientView.client.getCard(), purchaseLocation, purchaseValue);
        } catch (ERefusedTransaction ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
            } catch (IOException ex) {
                System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
            }
        }
    }

    public static void listItems() {
        System.out.println("------------ ## ------------ ## ------------ ");
        System.out.println("Items comprados por: " + ClientView.client.getName() + ", cpf: " + ClientView.client.getCpf());
        System.out.println(ClientView.client.getCard().getItems().toString());
        System.out.println("------------ ## ------------ ## ------------ ");
    }

    public static void registerPayment() {
        try {
            System.out.printf("Insira o valor do pagamento: ");
            double paymentValue = new Scanner(System.in).nextDouble();

            bankControl.registerPayment(ClientView.client.getCard(), paymentValue);
        } catch (EOverExpectedPayment ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
            } catch (IOException ex) {
                System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
            }
        }
    }

    public static void gerenateTicket() {
        try {
            ClientView.client.getTickets().add(new TicketControl().generateTicket(ClientView.client.getCard()));
            System.out.println(ClientView.client.getTickets().toString());
        } catch (EInvalidRequest ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
            } catch (IOException ex) {
                System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
            }
        }
    }

    public static void generateStatement() {
        System.out.println(ClientView.client.getCard().cardStatement(ClientView.client.getCard()));
    }

    public static void desserialize() {
        try {
            clientControl.insertClientSet((Set<Client>) dataBaseControl.loadList("clientes.bin"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chooseClient() {
        System.out.printf("Insira o CPF do títular: ");
        try {
            ClientView.client = clientControl.returnClient(new Scanner(System.in).nextInt());
        } catch (NullPointerException ex) {
            System.out.println("Cliente não encontrado!");
            Controller.menuPrincipal();
        }
    }

    static void menuClientView() {
        desserialize();
        chooseClient();

        int num = 0;
        while (num != 13) {
            System.out.println(" --------------- Menu Cliente ---------------");
            System.out.println("[1] Informações do Cartão");
            System.out.println("[2] Realizar Compra");
            System.out.println("[3] Listar Items do Cartão");
            System.out.println("[4] Gerar Boleto");
            System.out.println("[5] Gerar Extrato");
            System.out.println("[6] Voltar");
            System.out.println(" --------------------------------------------");

            num = new Scanner(System.in).nextInt();

            switch (num) {
                case 1:
                    cardInformation();
                    break;
                case 2:
                    purchaseItem();
                    break;
                case 3:
                    listItems();
                    break;
                case 4:
                    gerenateTicket();
                    break;
                case 5:
                    generateStatement();
                    break;
                case 6:
                    Controller.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inexistente!");
                    break;
            }
        }
    }

}
