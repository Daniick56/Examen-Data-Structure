import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {
    ArrayList <String> products = new ArrayList<String>();
    ArrayList <Integer> amount = new ArrayList<Integer>();


    //Creacion de metodo para proyectar el menú:
    public void menu() {
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar producto por nombre");
            System.out.println("3. Actualizar cantidad de producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");

            option = Integer.parseInt(input.next());

            switch (option) {
                case 1:
                    AddProduct();
                    break;
                case 2:
                    SearchProduct();
                    break;
                case 3:
                    UpdateAmount();
                    break;
                case 4:
                    DeleteProduct();
                    break;
                case 5:
                    ShowInventory();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private void ShowInventory() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < amount.size(); j++) {
                
            }
        }
    }

    private void DeleteProduct() {
        Scanner input = new Scanner(System.in);
        String producto;

        System.out.println("Ingresa el producto a eliminar: ");
        producto = input.next();

        for (int i = 0; i <= products.indexOf(producto); i++) {
            if (products.get(i).equals(producto)) {
                products.remove(i);
            }
            System.out.println("La nueva cantidad de " + products.get(i) + " es: " + amount.get(i));
        }
    }

    private void UpdateAmount() {
        Scanner input = new Scanner(System.in);
        String producto;

        System.out.println("Ingresa el producto a actualizar su cantidad: ");
        producto = input.next();
        int cantidad = 0;

        for (int i = 0; i <= products.indexOf(producto); i++) {
            if (products.get(i).equals(producto)) {
                System.out.println("Ingresa la nueva cantidad: ");
                cantidad  = input.nextInt();
                amount.add(i, cantidad);
            }
            System.out.println("La nueva cantidad de " + products.get(i) + " es: " + amount.get(i));
        }
    }

    private void SearchProduct() {
        Scanner input = new Scanner(System.in);
        String producto;

        System.out.println("Ingresa el producto a buscar: ");
        producto = input.next();
        int counter = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).contains(producto)) {
                System.out.println("Se encontró el producto.");
                counter++;
            }
        }
        if (counter==0) {
            System.out.println("No se encontró");
        }
    }

    private void AddProduct() {

        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de productos a ingresar: ");
        int cant = Integer.parseInt(input.next());
        for (int i = 0; i < cant; i++) {
            String producto;
            int cantidad;
            while (true) {
                System.out.println("Ingresa el producto " + (i + 1));
                producto = input.next();
                boolean verify = false;

                for (int j = 0; j < products.size(); j++) {
                    if (products.get(j) == producto) {
                        verify = true;
                    }
                }
                if (!verify) {
                    products.add(producto);
                    //preguntamos la cantidad y la ingresamos:
                    System.out.println("Ingresa la cantidad que hay de ese producto: ");
                    cantidad = Integer.parseInt(input.next());
                    amount.add(cantidad);
                    break;
                } else {
                    System.out.println("El producto ya existe.");
                }
            }
        }

    }
}
