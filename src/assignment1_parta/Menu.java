/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_parta;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        List l = new List();
        int choice;
        boolean cont = true;

        do {
            System.out.println("\n==========PhoneManagement==========");
            
            System.out.println("1. Add phone");
            System.out.println("2. Delete phone");
            System.out.println("3. Show all IDphone");
            System.out.println("4. Show IDphone after 2020");
            System.out.println("5. Search number of phones with name");
            System.out.println("6. Phone with highest value");
            System.out.println("7. Clear all phone");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    l.displayAllInfo();
                    System.out.print("Enter phone ID (a number): ");
                    int phoneID = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter name of product(IPhonne, Samsung, Nokia,..): ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter amount: ");
                    int amount = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter year of product: ");
                    int yearOfProduct = Integer.parseInt(sc.nextLine());

                    Phone product = new Phone(phoneID, name, price, amount, yearOfProduct);
                    Node node = new Node(product, null);

                    System.out.println("If you wanna Add default(AddNode)- Press 1");
                    System.out.println("If you wanna Add first(top of List)- Press 2");
                    System.out.println("If you wanna Add last(end of List)- Press 3");
                    System.out.print("Your choice: ");
                    int choice1 = Integer.parseInt(sc.nextLine());

                    do {
                        if (choice1 == 1) {
                            System.out.print("Enter phoneID you want to add after: ");
                            int checkPhoneID = Integer.parseInt(sc.nextLine());
                            l.add_Node(node, checkPhoneID);
                            break;
                        } else if (choice1 == 2) {
                            l.add_First(node);
                            break;
                        } else if (choice1 == 3) {
                            l.add_Last(node);
                            break;
                        } else {
                            System.out.println("Please enter 1 - 3");
                        }
                    } while (choice1 < 1 || choice1 > 3);
                    
                    l.displayAllInfo();
                    break;

                case 2:
                     l.displayAllInfo();
                    System.out.print("Enter ID: ");
                    phoneID = Integer.parseInt(sc.nextLine());
                    l.deleteNode(phoneID);
                    l.displayAllInfo();
                    break;

                case 3:
                    l.show();
                    break;

                case 4:
                    l.show2();
                    break;

                case 5:
                     l.displayAllInfo();
                    System.out.print("Enter name of phone: ");
                    name = sc.nextLine();

                    int numberOfPhone = l.search(name);
                    System.out.print("Number of phones with name: " + numberOfPhone);
                    break;

                case 6:
                    l.displayAllInfo();
                    Node maxNode = l.MaxValue();

                    if (maxNode == null) {
                        System.out.println("Empty list");
                    } else {
                        System.out.println("Phone(highest value): " + maxNode.p.getID());
                    }
                    break;
                //case 7:    
                case 7:
                    l.clear();
                    break;
                case 8: 
                    System.out.println("\nGood bye. See ya!!!!!!!\n");
                    cont = false;
                    break;
               

                default:
                    System.out.println("Please enter 1 - 8");
                    break;

            }

        } while (cont);
    }
}
