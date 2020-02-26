package kata.supermarket.discount.type;

import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of BuyOneGetOne pricing discount,
 * all products sold by unit are eligible for this discount,
 * the list of products eligible for discount can be narrowed by overriding filter method.
 */
public class BuyOneGetOneDiscount extends Discount<ItemByUnit> {

    @Override
    public BigDecimal calculate(List<ItemByUnit> eligibleProducts) {

        BigDecimal discount = BigDecimal.ZERO;
        if (eligibleProducts.size() >1) {
            int numberOfFreeProducts = eligibleProducts.size()/2;
            BigDecimal priceOfItem = eligibleProducts.get(0).price();
            discount = discount.add(priceOfItem.multiply(BigDecimal.valueOf(numberOfFreeProducts)));
        }
        return discount;
    }

    @Override
    protected List<ItemByUnit> filter(List<Item> items) {
        List<ItemByUnit> productList = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof ItemByUnit) {
                productList.add((ItemByUnit) item);
            }
        }
        return productList;
    }
}