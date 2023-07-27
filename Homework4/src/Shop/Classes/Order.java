package Shop.Classes;

import Shop.DiscountClasses.*;

public class Order {
    Buyer buyer;
    Item item;
    private int amountItems;
    private static int counter;
    private static double cost;

    public Order(Buyer buyer, Item item, int amountItems ) {
        this.buyer = buyer;
        this.item = item;
        this.amountItems = amountItems;
        counter++;
    }

    public Order(Buyer buyer, Item item, int amountItems, double cost) {
        this.buyer = buyer;
        this.item = item;
        this.amountItems = amountItems;
        this.cost = cost;
        counter++;
    }

    public void recalculateCost() {
        cost = 0;
        double itemPrice = item.getPrice();
        Item.Category category = item.getCategory();
        switch (category) {
            case ELECTRONICS:
                itemPrice -= (itemPrice * DiscountElectronics.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountElectronics.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case CLOTHING:
                itemPrice -= (itemPrice * DiscountClothing.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountClothing.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case BOOKS:
                itemPrice -= (itemPrice * DiscountBooks.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountBooks.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case FOOD:
                itemPrice -= (itemPrice * DiscountFood.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountFood.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case CARS:
                itemPrice -= (itemPrice * DiscountCars.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountCars.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case BEAUTY:
                itemPrice -= (itemPrice * DiscountBeauty.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountBeauty.getDiscount().getValue() * 100), '%', itemPrice);
                break;
            case HOME_APPLIANCES:
                itemPrice -= (itemPrice * DiscountHomeAppliances.getDiscount().getValue());
                System.out.printf("Итого стоимость вашего товара %s с учетом скидки %.0f %c составит: %.2f\n",
                        item.getName(), (DiscountHomeAppliances.getDiscount().getValue() * 100), '%', itemPrice);
                break;
        }
        cost += itemPrice * amountItems;
        System.out.println("Стоимость вашей покупки: " + cost);
    }


    public int getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public static int getCounter() {
        return counter;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public static double getCost() {
        return cost;
    }



    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", item=" + item +
                ", amountItems=" + amountItems +
                ", order cost =" + cost +
                '}';
    }


}
