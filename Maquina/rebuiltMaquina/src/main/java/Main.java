
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Producto> productos = new ArrayList<Producto>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = 0;
        char repeat = 's';
        while (repeat == 's') {
            visualMenu();
            opcion = scan.nextInt();
            switch (opcion) {
            case 1:

                break;

            case 999:

                // Funciones especiales-------------------------------------------

                int choice = 0;
                System.out.println(
                        "\n\t1. Agregar Producto\t\t2. Ver productos\n\n\t3. Editar productos\t\t\t4. \n\n\t5. \t\t\t\t6. \n\n\t");
                choice = scan.nextInt();
                switch (choice) {
                case 1:
                    boolean again = true;
                    while (again == true) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scan.next();
                        System.out.print("Ingrese el precio del producto: ");
                        float precio = scan.nextFloat();
                        System.out.print("Ingrese cuantas unidades de este producto hay en stock: ");
                        int stock = scan.nextInt();

                        productos.add(new Producto(nombre, precio, stock));
                        // System.out.println("From?");
                        // fromFile();
                        System.out.println("Desea agregar otro producto? (S/N): ");
                        char sino = scan.next().charAt(0);
                        if (sino != 's') {
                            again = false;
                        }
                    }
                    toFile();

                    break;

                case 2:
                    fromFile();
                    break;
                case 3:
                    editFile();
                    break;
                }
                break;
            }
        }

    }

    public static void visualMenu() {
        System.out.println("\n\t1. \t\t2. \n\n\t3. \t\t\t4. \n\n\t5. \t\t\t\t6. \n\n\t999. Developer tools");
    }

    public static void toFile() {
        try {
            FileOutputStream f = new FileOutputStream("myProducts.txt", true);
            ObjectOutputStream o = new ObjectOutputStream(f);
            for (int i = 0; i < productos.size(); i++) {
                o.writeObject(productos.get(i));
                o.flush();
            }
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static void fromFile() {

        ArrayList<Producto> objectsList = new ArrayList<Producto>();

        Producto obj = null;
        boolean stop = false;

        try {

            FileInputStream fi = new FileInputStream(("myProducts.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            try {
                obj = (Producto) oi.readObject();
                objectsList.add(obj);
                while (stop == false) {
                    if ((obj) == null) {
                        stop = true;
                    }

                    obj = (Producto) oi.readObject();

                    objectsList.add(obj);

                }
            } catch (IOException ex) {
                System.out.println("\n");
            }

            for (int i = 0; i < objectsList.size(); i++) {
                obj = objectsList.get(i);
                System.out.println(obj.getProduct());
            }

            // System.out.println("borp");

            oi.close();

            pressAnyKeyToContinue();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            stop = true;
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
         * catch (EOFException e){ System.out.println("End of file"); }
         */
    }

    public static void editFile() {

        ArrayList<Producto> objectsList = new ArrayList<Producto>();

        Producto obj;
        // boolean stop = false;

        try {

            FileInputStream fi = new FileInputStream(("myProducts.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            try {
                obj = (Producto) oi.readObject();
                objectsList.add(obj);
                while ((obj) != null) {

                    obj = (Producto) oi.readObject();
                    objectsList.add(obj);

                }
            } catch (IOException ex) {
                System.out.println("\n");
            }

            for (int i = 0; i < objectsList.size(); i++) {
                obj = objectsList.get(i);
                System.out.println("ID: " + (i + 1));
                System.out.print(obj.getProduct());
            }

            System.out.print("Ingrese la ID del producto al que quiere editar: ");
            int s = scan.nextInt();
            obj = objectsList.get((s - 1));
            System.out.println("Editar: 1. Nombre\n\t2. Precio\n\t3. Stock\n");
            int opcion = scan.nextInt();
            switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                String name = scan.next();
                // obj.getNombreProducto;
                break;
            case 2:
                obj = objectsList.get((s - 1));
                obj.getProductNombre();
                break;
            case 3:
                objectsList.get((s - 1));
                break;
            }

            oi.close();

            pressAnyKeyToContinue();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Presione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
