/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_parta;

/**
 *
 * @author Admin
 */
class Phone {

    int ID;
    String Name;
    double price;
    int amount;
    int yearOfProduct;

    public Phone(int ID, String Name, double price, int amount, int yearOfProduct) {
        this.ID = ID;
        this.Name = Name;
        this.price = price;
        this.amount = amount;
        this.yearOfProduct = yearOfProduct;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(int yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

}

class Node {

    Phone p;
    Node p_Next;

    public Node() {
    } ;
    
   

    public Node(Phone info, Node p_Next) {
        this.p = info;
        this.p_Next = p_Next;
    }

    public Phone getP() {
        return p;
    }

    public void setP(Phone p) {
        this.p = p;
    }

    public Node getP_Next() {
        return p_Next;
    }

    public void setP_Next(Node p_Next) {
        this.p_Next = p_Next;
    }

    @Override
    public String toString() {
        return "[Node] PhoneID: " + p.getID(); //+" Name: " + p.getName() + " Amount: " + p.amount  + " Price: " + p.getPrice() + " Year of product: " + p.getYearOfProduct();
    }

}

public class List {

    Node p_Head = null;
    int size = 0;

    public List() {

    }

    public List(Node n_Head) {
        this.p_Head = n_Head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isExisting(int PhoneID) {
        Node current = p_Head;
        while (current != null) {
            if (current.p.getID() == PhoneID) {
                return true;
            }
            current = current.p_Next;
        }
        return false;
    }

    void clear() {
        p_Head = null;
        size = 0;
    }

    public void show() {
        if (isEmpty()) {
            System.err.println("List empty");
            return;
        }
        Node current = p_Head;
        
        while (current != null) {
            System.out.println("IDPhone: " + current.p.getID());
            current = current.p_Next;
        }
    }

    public void show2() {
        if (isEmpty()) {
            System.err.println("List empty");
            return;
        }
        Node current = p_Head;
        while (current != null) {
            if (current.p.getYearOfProduct() > 2020) {
                System.out.println("IDPhone: " + current.p.ID);
            }
            current = current.p_Next;
        }
    }

    public void add_First(Node data) { // adds element e to the front of the list
        if (isEmpty()) {
            p_Head = data;
        } else {
            if (isExisting(data.p.getID())) {
                System.err.println("Already exist!!!!");
                return;
            }
            data.p_Next = p_Head;
            p_Head = data;
        }
        size++;
    }

    public void add_Last(Node data) {
        if (isEmpty()) {
            p_Head = data;
        } else {
            if (isExisting(data.p.getID())) {
                System.err.println("Already exist!!!!");
                return;
            }

            Node current = p_Head;
            while (current.p_Next != null) {
                current = current.p_Next;
            }
            current.setP_Next(data);
        }
        size++;

    }

    public void add_Node(Node data, int PhoneID) {

        if (isEmpty()) {
            p_Head = data;
        } else {

            if (isExisting(data.p.getID())) {
                System.err.println("Already exist ID");
            } else {
                Node current = p_Head;
                Node save = null;

                while (current != null && current.p.getID() != PhoneID) {
                    save = current;
                    current = current.p_Next;
                }

                if (current != null) {
                    data.setP_Next(current.getP_Next());
                    current.setP_Next(data);
                } else {
                    save.setP_Next(data);
                }
            }
        }

        size++;

    }

    public void delete_First() {
        if (isEmpty()) {
            System.err.println("List is empty");
        } else {
            p_Head = p_Head.p_Next;
            size--;

        }
    }

    public void delete_Last() {
        if (isEmpty()) {
            return;
        }

        if (p_Head.getP_Next() == null) {

            p_Head = null;

        } else {
            Node current = p_Head;
            while (current.p_Next.p_Next != null) {
                current = current.p_Next;
            }
            current.p_Next = null;
        }
        size--;

    }

    public void deleteNode(int PhoneID) {
        Node current = p_Head;

        if (!isExisting(PhoneID)) {
            System.err.println("Does not exist Node");
        }

        if (isEmpty()) {
            System.err.println("Empty");
        } else {

            if (current.p.getID() == PhoneID) {
                delete_First();
            }
            while (current != null) {
                if (current.p_Next == null) {
                    break;
                }

                if (current.p_Next.getP().getID() == PhoneID) {

                    current.p_Next = current.p_Next.p_Next;

                    size--;
                    continue;

                }

                current = current.p_Next; //xét các phần tử của List

            }

        }

    }

    public int search(String name) {
        Node current = p_Head;

        int count = 0;

        while (current != null) {
            if (current.p.getName().equals(name)) {
                count++;
            }
            current = current.p_Next;
        }
        return count;
    }

    public Node MaxValue() {
        Node current = p_Head;
        Node maxNode = null;

        double maxValue = 0;

        while (current != null) {
            double value = (current.getP().getPrice() * current.getP().getAmount());
            if (value > maxValue) {
                
                maxValue = value;
                maxNode = current;
            }
            
            current = current.p_Next;
        }
        return maxNode;
    }
    
    public void displayAllInfo() {
        Node current = p_Head;
        
        if (isEmpty()) return;
        
        System.out.println("ID    |  Name      | Price   | Amount |  Year");
        while (current != null) {
            System.out.printf("%-5d | %-10s | %8f | %5d | %8d |\n", current.p.getID(), current.p.getName(), current.p.getPrice(), current.p.getAmount(), current.p.getYearOfProduct());
            current = current.p_Next;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List l = new List();
//
//        Phone p1 = new Phone(1, "Vinh", 20, 1, 1999);
//        Phone p2 = new Phone(2, "Vinh", 20, 1, 2021);
//        Phone p3 = new Phone(3, "Vinh", 20, 1, 2021);
//        Phone p4 = new Phone(100, "Vinh", 10, 1, 2022);
//        Phone p5 = new Phone(5, "Vinh", 40, 2, 1999);
//        Phone p6 = new Phone(6, "Vinh", 40, 2, 2000);
//
//
//        Node n1 = new Node(p1, null);
//        Node n2 = new Node(p2, null);
//        Node n3 = new Node(p3, null);
//        Node n4 = new Node(p4, null);
//        Node n5 = new Node(p5, null);
//        Node n6 = new Node(p6, null);
//
//        l.add_First(n1);
//        l.add_First(n2);
//        l.add_Last(n3);
//        l.add_Last(n4);
//        l.add_First(n5);
//        l.add_Last(n6);
//
//        //System.out.println(l.MaxValue());
//        //l.deleteLast();
//        //l.deleteNode(6);
//        //l.clear();
//        //System.out.println(l.search("Vinh"));
//
//        //l.show();
//        l.show2();

//        Phone p7 = new Phone(7, "Nam", 20, 2, 2000); 
//         Node n7 = new Node(p7, null);
//         l.add_Node(n7, 5);
            
            Menu mn = new Menu();
            mn.displayMenu();

    }

}
