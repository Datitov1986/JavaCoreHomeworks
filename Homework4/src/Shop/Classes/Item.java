package Shop.Classes;

import Shop.DiscountClasses.*;
import Shop.Shop;
import java.util.Random;

public class Item {
    private String name;
    private int price;
    private Category category;
    private Discount discount;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        assignRandomDiscount();
    }

    public Item(String name, int price, Category category, Discount discount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.discount = discount;
        assignRandomDiscount();
    }

    public enum Category {
        BEAUTY,
        HOME_APPLIANCES,
        CLOTHING,
        FOOD,
        ELECTRONICS,
        BOOKS,
        CARS
    }

    public enum Discount {
        FIVE_PERCENT(0.05),
        TEN_PERCENT(0.10),
        FIFTEEN_PERCENT(0.15),
        TWENTY_PERCENT(0.20),
        ZERO_PERCENT(0.00);

        private double value;
        Discount(double value) {
            this.value = value;
        }
        public double getValue() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void assignRandomDiscount() {
        Discount[] discounts = Discount.values();
        int randomIndex = new Random().nextInt(discounts.length);
        Discount randomDiscount = discounts[randomIndex];

            switch (category) {
                case CARS:
                    DiscountCars.setDiscount(randomDiscount);
                    break;
                case FOOD:
                    DiscountFood.setDiscount(randomDiscount);
                    break;
                case BOOKS:
                    DiscountBooks.setDiscount(randomDiscount);
                    break;
                case BEAUTY:
                    DiscountBeauty.setDiscount(randomDiscount);
                    break;
                case CLOTHING:
                    DiscountClothing.setDiscount(randomDiscount);
                    break;
                case ELECTRONICS:
                    DiscountElectronics.setDiscount(randomDiscount);
                    break;
                case HOME_APPLIANCES:
                    DiscountHomeAppliances.setDiscount(randomDiscount);
                    break;

            }
    }
}
