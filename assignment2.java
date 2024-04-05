import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class RestaurantStaff extends User {
    public RestaurantStaff(String username, String password) {
        super(username, password);
    }

}

class AuthSystem {
    private List<User> users;

    public AuthSystem() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

abstract class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayInfo();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

interface Orderable {
    int getQuantity();

    void setQuantity(int quantity);

    void incrementQuantity();

    void decrementQuantity();

    double calculateTotalPrice();

    String getName();
}

class MenuItem extends FoodItem implements Orderable {
    private int quantity;

    public MenuItem(String name, double price) {
        super(name, price);
        this.quantity = 0;
    }

    public MenuItem(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    @Override
    public void displayInfo() {
        System.out.println("MenuItem: " + getName() + " - Rs." + getPrice() + " per item");
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void incrementQuantity() {
        quantity++;
    }

    @Override
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }
}

class Restaurant {
    protected List<MenuItem> menu;
    private List<Orderable> orders;

    public Restaurant() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - Rs." + menu.get(i).getPrice());
        }
    }

    public void placeOrder(MenuItem item, int quantity) {
        if (quantity > 0) {
            MenuItem existingItem = findExistingOrder(item);
            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
            } else {
                item.setQuantity(quantity);
                orders.add(item);
            }
        }
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Orderable order : orders) {
            System.out.println(
                    order.getQuantity() + " x " + order.getName() + " - Total: Rs." + order.calculateTotalPrice());
        }
    }

    public double calculateTotalBill() {
        double total = 0.0;
        for (Orderable order : orders) {
            total += order.calculateTotalPrice();
        }
        return total;
    }

    private MenuItem findExistingOrder(MenuItem item) {
        for (Orderable order : orders) {
            if (order.getName().equals(item.getName())) {
                return (MenuItem) order;
            }
        }
        return null;
    }
}

public class assignment2 {
    public static void main(String[] args) {
        AuthSystem authSystem = new AuthSystem();
        Restaurant restaurant = new Restaurant();

        MenuItem item1 = new MenuItem("Veg Burger", 100);
        MenuItem item2 = new MenuItem("Veg Cheese Burger", 125);
        MenuItem item3 = new MenuItem("Veg Pizza", 150);
        MenuItem item4 = new MenuItem("Margerita Pizza", 100);
        MenuItem item5 = new MenuItem("Chhole Puri", 60);
        MenuItem item6 = new MenuItem("Maggi", 50);
        MenuItem item7 = new MenuItem("Puff", 20);
        MenuItem item8 = new MenuItem("French Fries", 100);
        MenuItem item9 = new MenuItem("Samosa", 50);
        MenuItem item10 = new MenuItem("Aloo Paratha", 150);
        MenuItem item11 = new MenuItem("Pav Bhaji", 120);
        MenuItem item12 = new MenuItem("Pasta", 150);
        MenuItem item13 = new MenuItem("Masala Dosa", 100);
        MenuItem item14 = new MenuItem("Hakka Noodles", 120);
        MenuItem item15 = new MenuItem("Manchurian", 100);
        MenuItem item16 = new MenuItem("Garlic Bread", 100);
        MenuItem item17 = new MenuItem("Pani Puri", 70);
        MenuItem item18 = new MenuItem("Samosa Chaat", 65);
        MenuItem item19 = new MenuItem("Cold Coffee", 100);
        MenuItem item20 = new MenuItem("Frankie", 100);
        MenuItem item21 = new MenuItem("Veg Sandwich", 120);
        MenuItem item22 = new MenuItem("Veg Cheese Sandwich", 150);
        MenuItem item23 = new MenuItem("Club Sandwich", 175);
        MenuItem item24 = new MenuItem("Club Cheese Sandwich", 200);
        MenuItem item25 = new MenuItem("Bournvita", 70);
        MenuItem item26 = new MenuItem("Cheese Nachos", 90);

        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item3);
        restaurant.addMenuItem(item4);
        restaurant.addMenuItem(item5);
        restaurant.addMenuItem(item6);
        restaurant.addMenuItem(item7);
        restaurant.addMenuItem(item8);
        restaurant.addMenuItem(item9);
        restaurant.addMenuItem(item10);
        restaurant.addMenuItem(item11);
        restaurant.addMenuItem(item12);
        restaurant.addMenuItem(item13);
        restaurant.addMenuItem(item14);
        restaurant.addMenuItem(item15);
        restaurant.addMenuItem(item16);
        restaurant.addMenuItem(item17);
        restaurant.addMenuItem(item18);
        restaurant.addMenuItem(item19);
        restaurant.addMenuItem(item20);
        restaurant.addMenuItem(item21);
        restaurant.addMenuItem(item22);
        restaurant.addMenuItem(item23);
        restaurant.addMenuItem(item24);
        restaurant.addMenuItem(item25);
        restaurant.addMenuItem(item26);

        Scanner scanner = new Scanner(System.in);

        RestaurantStaff staff = new RestaurantStaff("soha", "sahil");
        authSystem.addUser(staff);
        System.out.println("Welcome to your favourite restaurant!!!");
        System.out.println("===========================================");
        System.out.println("");
        while (true) {
            try {
                label: {
                    System.out.println(
                            "Enter 1 to view the menu, 2 to place an order, 3 to log in as staff, or 4 to exit:");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        restaurant.displayMenu();
                        System.out.println("");
                    } else if (choice == 2) {
                        Boolean b = true;

                        while (b) {
                            System.out.println("Enter the item number to order:");
                            int itemNumber = scanner.nextInt();

                            if (itemNumber >= 1 && itemNumber <= restaurant.menu.size()) {
                                System.out.println("Enter the quantity:");
                                int quantity = scanner.nextInt();
                                restaurant.placeOrder(restaurant.menu.get(itemNumber - 1), quantity);
                                System.out.println(
                                        "Press 1 if your order is completed or press 2 to if you want to order more items:");
                                int y = scanner.nextInt();
                                if (y == 1) {
                                    b = false;
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    restaurant.displayOrders();
                                    double totalBill = restaurant.calculateTotalBill();
                                    System.out.println("Total Bill: Rs." + totalBill);
                                    System.out.println("");
                                }
                            } else {
                                System.out.println("Invalid item number.");
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break label;
                            }
                        }
                    } else if (choice == 3) {
                        System.out.println("Enter your username:");
                        String username = scanner.next();
                        User user = authSystem.findUser(username);

                        if (user != null && user instanceof RestaurantStaff) {

                            System.out.println("");
                            System.out.println("Enter your password:");
                            String password = scanner.next();
                            if (user.getPassword().equals(password)) {
                                System.out.println("Login successful.");
                                System.out.println("");
                                handleStaffMenu(restaurant, scanner);
                            } else {
                                System.out.println("Incorrect password.");

                            }

                        } else {
                            System.out.println("Staff not found.");
                        }
                    } else if (choice == 4) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        scanner.close();
    }

    private static void handleStaffMenu(Restaurant restaurant, Scanner scanner) {
        while (true) {
            System.out.println("Staff Menu Options:");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Display Menu");
            System.out.println("4. Exit");
            System.out.println("");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the item name:");
                    String name = scanner.next();
                    System.out.println("Enter the item price:");
                    double price = scanner.nextDouble();
                    MenuItem newItem = new MenuItem(name, price);
                    restaurant.addMenuItem(newItem);
                    System.out.println("Menu item added.");
                    System.out.println("");

                    break;
                case 2:

                    System.out.println("");
                    System.out.println("Enter the item number to remove:");
                    int itemNumber = scanner.nextInt();
                    if (itemNumber >= 1 && itemNumber <= restaurant.menu.size()) {
                        restaurant.menu.remove(itemNumber - 1);
                        System.out.println("Menu item removed.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    System.out.println("");

                    break;
                case 3:

                    restaurant.displayMenu();
                    System.out.println("");

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
