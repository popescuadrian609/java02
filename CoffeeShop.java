package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeShop {
    private String name;
    private ArrayList<MenuItem> menu;
    private ArrayList<String> orders;

    public CoffeeShop(String _name, MenuItem[] _menu, String[] _orders){
        name = _name;
        menu = new ArrayList<MenuItem>(Arrays.asList(_menu));
        orders = new ArrayList<String>(Arrays.asList(_orders));
    }
    public String addOrder(String _name){
        Boolean menu_has_item = false;
        for(int i = 0; i < menu.size(); i++){
            if(menu.get(i).getItem() == _name){
                menu_has_item = true;
            }
        }
        if(menu_has_item == true){
            orders.add(_name);
            return "Order added!";
        } else {
            return "This item is currently unavailable!";
        }
    }
    public String fulfillOrder(){
        if(orders.size() != 0){
            String item = orders.get(0);
            orders.remove(0);
            return String.format("The %s is ready!", item);
        } else {
            return "All orders have been fulfilled!";
        }
    }
    public String[] listOrders(){
        return orders.toArray(new String[orders.size()]);
    }
    public double dueAmount(){
        double amount = 0.00;
        for(int i = 0; i < orders.size(); i++){
            double price = 0.00;
            String item = orders.get(i);
            for(int j = 0; j < menu.size(); j++){
                if(menu.get(j).getItem() == item){
                    price = menu.get(j).getPrice();
                    break;
                }
            }
            amount += price;
        }
        return amount;
    }
    public String cheapestItem(){
        double cheapestItemPrice = menu.get(0).getPrice();
        String cheapestItemName = menu.get(0).getItem();
        for(int i = 1; i < menu.size(); i++){
            if(menu.get(i).getPrice() < cheapestItemPrice){
                cheapestItemName = menu.get(i).getItem();
                cheapestItemPrice = menu.get(i).getPrice();
            }
        }
        return cheapestItemName;
    }
    public String[] drinksOnly(){
        ArrayList<String> drinks = new ArrayList<String> ();
        for(int i = 0 ; i < menu.size(); i++){
            if(menu.get(i).getType() == "drink"){
                drinks.add(menu.get(i).getItem());
            }
        }
        return drinks.toArray(new String[drinks.size()]);
    }
    public String[] foodOnly(){
        ArrayList<String> food = new ArrayList<String> ();
        for(int i = 0 ; i < menu.size(); i++){
            if(menu.get(i).getType() == "food"){
                food.add(menu.get(i).getItem());
            }
        }
        return food.toArray(new String[food.size()]);
    }
}

class MenuItem {
    private String item;
    private String type;
    private double price;

    public MenuItem(String item, String type, double price) {
        this.item = item;
        this.type = type;
        this.price = price;
    }

    public String getItem() { return item; }
    public String getType() { return type; }
    public double getPrice() { return price; }
}