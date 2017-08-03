package view;

import java.util.Scanner;

public class Controller {
    
    public static void main(String[] args) {
        menuPrincipal();
    }
    
    static void menuPrincipal() {
        int num = 0;
        while (num != 13) {
            System.out.println(" --------------- Menu Principal ---------------");
            System.out.println("[1] Menu Cliente");
            System.out.println("[2] Menu Administração");
            System.out.println("[3] Sair");
            System.out.println(" ----------------------------------------------");
            
            num = new Scanner(System.in).nextInt();
            
            switch (num) {
                case 1:
                    ClientView.menuClientView();
                    break;
                case 2:
                    AdminView.menuAdminView();
                case 3:
                    System.out.println("Saindo....");
                    System.exit(0);
                default:
                    System.out.println("valor invalido");
                    menuPrincipal();
                    break;
            }
        }
    }
}
