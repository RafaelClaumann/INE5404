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
import control.TimeControl;
import exceptions.EDuplicateClient;
import exceptions.EWrongPassword;
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
public class AdminView {

    private static ClientControl clientControl = ClientControl.getClientControl();
    private static CardFactory cardFactory = CardFactory.getCardFactory();
    private static BankControl bankControl = BankControl.getBankControl();
    private static TimeControl timeControl = TimeControl.getTimeControl();
    private static DatabaseControl dataBaseControl = DatabaseControl.getDatabaseControl();

    public static AdminView instance;

    public static AdminView getAdminView() {
        if (AdminView.instance == null) {
            AdminView.instance = new AdminView();
        }
        return AdminView.instance;
    }

    public static void clientRegister() {
        try {
            Client client = clientControl.newClient();

            System.out.printf("Insira o nome: ");
            client.setName(new Scanner(System.in).nextLine());

            System.out.printf("Insira o cpf: ");
            client.setCpf(new Scanner(System.in).nextInt());

            System.out.printf("Insira a renda mensal: ");
            client.setIncome(new Scanner(System.in).nextDouble());

            client.setCard(cardFactory.getCard(client));

            clientControl.insertClient(client);
        } catch (EDuplicateClient ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
            } catch (IOException ex) {
                System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
            }
        }
    }

    public static void unlockCard() {
        System.out.printf("Insira o CPF do títular: ");
        Client client = clientControl.returnClient(new Scanner(System.in).nextInt());
        bankControl.unlockCard(client.getCard());
        try {
            dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
        } catch (IOException ex) {
            System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
        }
    }

    public static void cardInformation() {
        try {
            System.out.printf("Insira o CPF do títular: ");
            Client client = clientControl.returnClient(new Scanner(System.in).nextInt());

            System.out.println("------------ ## ------------ ## ------------ ");
            System.out.println("Títular: " + client.getName());
            System.out.println("Limite: R$" + client.getCard().getLimit());
            System.out.println("Gastos Totais: R$" + client.getCard().getSpent());
            System.out.println("Estado: " + client.getCard().getState().toString());
            System.out.println("------------ ## ------------ ## ------------ ");
        } catch (NullPointerException e) {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void listItems() {
        try {
            System.out.printf("Insira o CPF do títular: ");
            Client client = clientControl.returnClient(new Scanner(System.in).nextInt());

            System.out.println("------------ ## ------------ ## ------------ ");
            System.out.println("Items comprados por: " + client.getName() + ", cpf: " + client.getCpf());
            System.out.println(client.getCard().getItems().toString());
            System.out.println("------------ ## ------------ ## ------------ ");
        } catch (NullPointerException e) {
            System.out.println("Cliente não encontrado");
        }
    }

    public static void getAllClients() {
        System.out.println(clientControl.returnClients());
    }

    public static void getClient() {
        try {
            System.out.printf("Insira o CPF do títular: ");
            System.out.println(clientControl.returnClient(new Scanner(System.in).nextInt()));
        } catch (NullPointerException e) {
            System.out.println("Cliente não encontrado");
        }
    }

    public static void turnMonths() {
        timeControl.turnMonth(clientControl.returnClientSet());
        try {
            dataBaseControl.WriteList(clientControl.returnClientSet(), "clientes.bin");
        } catch (IOException ex) {
            System.out.println("Ocorreu algum erro durante a gravação dos arquivos!");
        }
    }

    public static void desserialize() {
        try {
            clientControl.insertClientSet((Set<Client>) dataBaseControl.loadList("clientes.bin"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void passwordCheck() {
        System.out.printf("Insira a Password: ");
        try {
            bankControl.passwordCheck(new Scanner(System.in).nextLine());
        } catch (EWrongPassword ex) {
            System.out.println("Password incorreta!");
            Controller.menuPrincipal();
        }
    }

    static void menuAdminView() {
        desserialize();
        passwordCheck();

        int num = 0;
        while (num != 13) {
            System.out.println(" --------------- Menu Administração ---------------");
            System.out.println("[1] Registrar Clientes");
            System.out.println("[2] Desbloquear Cartão");
            System.out.println("[3] Informações do Cartão");
            System.out.println("[4] Listar Items do Cartão");
            System.out.println("[5] Buscar Cliente");
            System.out.println("[6] Listar Clientes");
            System.out.println("[7] Virar Mês");
            System.out.println("[8] Voltar");
            System.out.println(" --------------------------------------------------");

            num = new Scanner(System.in).nextInt();

            switch (num) {
                case 1:
                    clientRegister();
                    break;
                case 2:
                    unlockCard();
                    break;
                case 3:
                    cardInformation();
                    break;
                case 4:
                    listItems();
                    break;
                case 5:
                    getClient();
                    break;
                case 6:
                    getAllClients();
                    break;
                case 7:
                    turnMonths();
                    break;
                case 8:
                    Controller.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inexistente.");
                    menuAdminView();
                    break;
            }
        }
    }
}
