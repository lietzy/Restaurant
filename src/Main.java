import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    //instantiate global vars
     public static ArrayList<String> ids = new ArrayList<String>();
     public static ArrayList<Manager> managerList = loadManagers();
     public static ArrayList<Table> tableList = loadTables();
     public static ArrayList<Food> menu = loadFood();
     public static Table workingTable = tableList.get(1);
    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        ids.add("0001");
        ids.add("0000");
        boolean hasAccess = false;
        Manager currentUser = managerList.get(1);
        int action = 0;

        String currentId = "0";

        System.out.println("Welcome to Restaruaunt Software");


        //verifying ID
        while(hasAccess == false){
            System.out.println("Enter A Valid User Id:");
            System.out.println("If incorrect you will be asked again");
            currentId = kb.next();

            for(int i =0; i < ids.size(); i++) {
                if (currentId.equals(managerList.get(i).getId())) {
                    currentUser = managerList.get(i);
                    hasAccess = true;

                }
            }
        }

            System.out.println("Welcome " + currentUser.getName());

boolean isCont = true;

    while(isCont){
        System.out.println("How many seats are needed?");
        int seats = 0;
        seats = kb.nextInt();

        do {
            System.out.println("What do you want to do?");
            System.out.println("Enter the number Associated");
            System.out.println("1. Assign Customers to a Table");
            System.out.println("2. Take an Order for Assigned Table");
            System.out.println("3. Edit an Order for Assigned Table");
            System.out.println("6. Change assigned Table");
            System.out.println("4. Tab a Table out");
            System.out.println("5. Log Out and Exit");
            while (!kb.hasNextInt()) {
                System.out.println("That's not a number!");
                kb.next(); // this is important!
            }
            action = kb.nextInt();
        } while (action <= 0 || action > 5);

        System.out.println("Thank you! Got " + action);




        switch (action){
            case 1:{


                assignTable(seats);



                break;
            }
            case 2:{
                makeOrder(seats);
                break;
            }
            case 3:{
                System.out.println("Entered Edit Order Method");
                System.out.println("Finished Method Returning to menu");
                break;
            }
            case 4:{
                System.out.println("Entered Tab Out Method");
                System.out.println("Finished Method Returning to menu");
                break;
            }
            case 5: {
                System.exit(0);
            }

        }


    }








    }

    public static void assignTable( int customers){
        int tableId = 0;
        int tableCount = 0;
        System.out.println("Select the Table you want");
        for(int i = 0; i < tableList.size(); i++){
            if (tableList.get(i).getStatus().equals("no") && tableList.get(i).getSeats() >= customers){
                System.out.println( "Table " + tableList.get(i).getId());
                tableCount ++;
            }
        }
        if (tableCount == 0){
            System.out.println("There are no tables currently available returning to menu");
            return;
        }
        System.out.println("Please Select One of the Available Tables");
        tableId = kb.nextInt();
        for(int d =0; d < tableList.size(); d++){
            if(tableList.get(d).getId() == tableId){
                tableList.get(d).setStatus();
                tableList.get(d).setSeats(customers);
                workingTable = tableList.get(d).getTable();
            }
        }
        System.out.println("Assigned to Table " + workingTable.getId() );
    }

    public static void makeOrder(int customers){
        ArrayList<Food> tempOrder = new ArrayList<Food>();
        ArrayList<String> tempAvailable = new ArrayList<String>();
        String entreeString;
        Food entree =  new Food("temp", 10.0, "entree");
        String app = "";
        String drink = "";
        boolean pass = false;
        for(int i = 0; i < customers; i++){
            System.out.println("Please Select an entree");
            for(int d = 0; d< menu.size(); d++){
                if (menu.get(d).getType().equals("entree")){
                    System.out.println(menu.get(d).getName());
                    tempAvailable.add(menu.get(d).getName());
                }

            }
            do {
                while (!kb.hasNext()) {
                    System.out.println("That is not one of the options... Please match the case of the entree");
                    kb.next(); // this is important!
                }
                entreeString = kb.next();

                for (int g =0; g< menu.size(); g++){
                    if (menu.get(g).getName().equals(entreeString)){
                        entree = menu.get(g);
                        pass = true;
                    }
                }
                if (pass == false){
                    System.out.println("Please match the case of the options given");
                }
            } while (! tempAvailable.contains(entreeString));
            tempOrder.add(entree);
            System.out.println(tempOrder.get(0).getName());
        }
        //assign to table

    }


    public static ArrayList<Table> loadTables() {
        ArrayList<Table> tableList = new ArrayList<Table>();
        Table table1 = new Table(1, 4, "no");
        Table table2 = new Table(2, 4, "no");
        Table table3 = new Table(3, 4, "no");
        Table table4 = new Table(4, 4, "no");
        Table table5 = new Table(5, 4, "no");
        Table table6 = new Table(6, 4, "no");

        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table4);
        tableList.add(table5);
        tableList.add(table6);


    return tableList;

    }

    public static ArrayList<Manager> loadManagers() {
        Manager manager1 = new Manager("Jacob", "0000", 3);
        Manager manager2 = new Manager("Harold", "0001", 3);
        ArrayList<Manager> managerList = new ArrayList<Manager>();
        managerList.add(manager1);
        managerList.add(manager2);
        return managerList;
    }

    public static  ArrayList<Food> loadFood(){
        ArrayList<Food> tempMenu = new ArrayList<Food>();
        Food food1 = new Food("Steak", 18.00, "entree");
        Food food2 = new Food("Chicken", 12.00, "entree");
        Food food3 = new Food("Hamburger", 8.00, "entree");
        Food food4 = new Food("Pasta", 10.00, "entree");



        tempMenu.add(food1);
        tempMenu.add(food2);
        tempMenu.add(food3);
        tempMenu.add(food4);
        return tempMenu;
    }

}
