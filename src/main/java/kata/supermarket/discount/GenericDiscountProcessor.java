package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.discount.type.BuyOneGetOneDiscount;
import kata.supermarket.discount.type.Discount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * GenericDiscountProcessor which maintains a list of all eligible discounts
 * and applies all the discounts across all products.
 * For now the implementation is simple based on the current requirements but
 * can be changed or a new implementation of DiscountProcessor can be provided.
 */
class GenericDiscountProcessor implements DiscountProcessor {

    private List<Discount> discounts = Arrays.asList(new BuyOneGetOneDiscount());

    @Override
    public BigDecimal calculateDiscount(List<Item> products) {

        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Discount discount : discounts) {
            totalDiscount = totalDiscount.add(discount.calculate(products));
        }
        return totalDiscount;
    }

}