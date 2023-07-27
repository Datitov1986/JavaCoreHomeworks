package Shop;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Shop.Classes.Buyer;
import Shop.Classes.Item;
import Shop.Classes.Order;
import Shop.DiscountClasses.DiscountBeauty;
import Shop.DiscountClasses.DiscountElectronics;
import Shop.DiscountClasses.DiscountFood;
import Shop.Exceptions.IllegalAmountException;
import Shop.Exceptions.NoBuyerFoundException;
import Shop.Exceptions.NoItemFoundException;
import Shop.Exceptions.NotEnoughtMoneyExceptions;

public class Main {
    public static void main(String[] args)  {

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Shampoo", 320, Item.Category.BEAUTY));
        items.add(new Item("Milk", 89, Item.Category.FOOD));
        items.add(new Item("Chokolate", 120, Item.Category.FOOD));
        items.add(new Item("MacBook", 1000, Item.Category.ELECTRONICS));
        items.add(new Item("Lada Kalina", 120000, Item.Category.CARS));
        for (int i = 0; i < items.size(); i++) {
            items.get(i).assignRandomDiscount();
        }

        ArrayList<Buyer> buyers = new ArrayList<>();

        buyers.add(new Buyer("Ivan", 200000));
        buyers.add(new Buyer("Ilia", 1000));
        buyers.add(new Buyer("Valery", 3000));

        Shop shop = new Shop(items,buyers);
        try {
            shop.deal("Ivan", "Shampoo", 1).recalculateCost();
            shop.deal("Ivan", "Lada Kalina", 1).recalculateCost();
            shop.deal("Ivan", "Milk", 2).recalculateCost();
            shop.deal("Ilia", "Chokolate", 1).recalculateCost();
//            shop.deal("Ivan", "Shampoo", -1);
//            shop.deal("Dmitri", "Shampoo", 1);
//            shop.deal("Valery", "Brush", 2);
        } catch (NoBuyerFoundException e) {
            e.printStackTrace();
        } catch (NoItemFoundException e) {
            e.printStackTrace();
        } catch (IllegalAmountException e) {
            e.printStackTrace();
        } catch (NotEnoughtMoneyExceptions e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        System.out.println("всего сделок: " + Order.getCounter());


    }
}
