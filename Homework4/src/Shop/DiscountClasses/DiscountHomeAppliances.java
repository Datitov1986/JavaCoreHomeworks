package Shop.DiscountClasses;

import Shop.Classes.Item;

public class DiscountHomeAppliances {
    private static Item.Discount discount;

    public static void setDiscount (Item.Discount newDiscount) {
        discount = newDiscount;
    }

    public static Item.Discount getDiscount () {
        return discount;
    }
}
