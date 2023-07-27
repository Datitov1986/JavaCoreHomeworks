package Shop;

import Shop.Classes.*;
import java.util.ArrayList;
import java.util.Currency;

import Shop.Exceptions.*;

import static Shop.Classes.Order.*;

public class Shop {

    final ArrayList<Item> STOCK;
    final ArrayList<Buyer> CUSTOMERS;




    public Shop(ArrayList<Item> STOCK, ArrayList<Buyer> CUSTOMERS) {
        this.STOCK = STOCK;
        this.CUSTOMERS = CUSTOMERS;
    }

    public Order deal(String buyerName, String item, int amount) throws NoBuyerFoundException, NoItemFoundException, IllegalAmountException, NotEnoughtMoneyExceptions {

        if (amount <= 0) {
            throw new IllegalAmountException("Количество " + amount + " должно быть больше 0");
        }
        Buyer tempBuyer = null;
        Item tempItem = null;
        int tempBuyerMoney = 0;


        for (int i = 0; i < CUSTOMERS.size(); i++) {
            if (buyerName.equals(CUSTOMERS.get(i).getName())) {
                tempBuyer = CUSTOMERS.get(i);
                tempBuyerMoney = CUSTOMERS.get(i).getMoney();
                break;
            }
        }
        if (tempBuyer == null) {
            throw new NoBuyerFoundException("Нет пользователя " + buyerName + " зарегистрируйтесть и повортите покупку");
        }

        double cost = 0;
        for (int i = 0; i < STOCK.size(); i++) {
            if (item.equals(STOCK.get(i).getName())) {
                tempItem = STOCK.get(i);
                cost = tempItem.getPrice() * amount;
                break;
            }

        }
        if (tempItem == null) {
            throw new NoItemFoundException("Нет товара " + item + ", мы учтем ваше пожелание");
        }


        if (tempBuyerMoney < cost) {
            throw new NotEnoughtMoneyExceptions("К сожалению у Вас недостаточно денег для покупки.");
        }

        return new Order(tempBuyer, tempItem, amount, cost);

    }
}
