/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltazar_exam4;

import java.util.Scanner;
import java.util.Stack;

public class baltazar_exam4 {
    class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}   
    private Stack<Product> inventoryStack;

    public baltazar_exam4() {
        inventoryStack = new Stack<>();
    }
    public void addProduct(String productName, int quantity) {
        Product product = new Product(productName, quantity);
        inventoryStack.push(product);
    }
    public void sellProduct(String name, int quantity) throws Exception {
        Product product = inventoryStack.pop();
        if (product != null && product.getName().equals(name)) {
            product.setQuantity(product.getQuantity() - quantity);
            if (product.getQuantity() > 0) {
                inventoryStack.push(product);
            }
        } else {
            throw new Exception(name + " IS NOT FOUND IN THE INVENTOR: ");
        }
    }
    public void display() {
        System.out.println("\t YOUR INVENTORY: ");
        for (Product product : inventoryStack) {
            System.out.println(product.getName() + " : " + product.getQuantity());
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        baltazar_exam4 InventoryManagementStack = new baltazar_exam4();
         boolean start=true;
     while(start){
         System.out.println("\tINVENTORY MANAGEMENT: ");
         System.out.println("\t[1]ADD PRODUCT");
         System.out.println("\t[2]SELL PRODUCT");
         System.out.println("\t[3]DISPLAY PRODUCTS");
         System.out.println("\t[4]EXIT");
        
        int a = scanner.nextInt();
        scanner.nextLine();

        switch (a) {
            case 1:           
                System.out.println("\tENTER NAME OF THE PRODUCT: ");
                String name = scanner.nextLine();
                System.out.println("\tENTER QUANTITY: ");
                int quantity = scanner.nextInt();
                InventoryManagementStack.addProduct(name, quantity);
                break;
            case 2:             
                System.out.println("ENTER NAME OF THE PRODUCT: ");
                name = scanner.next();
                System.out.println("ENTER QUANTIY: ");
                quantity = scanner.nextInt();
                InventoryManagementStack.sellProduct(name, quantity);
                break;
            case 3:            
                InventoryManagementStack.display();
                break;
            case 4:
                start=false;
                break;
            default:
                System.out.println("ERROR");
            }
        }
    }
}
