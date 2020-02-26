package kata.supermarket.discount;

import kata.supermarket.Item;

import java.util.List;

/**
 * Base interface for discount processors
 */
public interface DiscountProcessor {

    int calculateDiscount(List<Item> discounts);

}