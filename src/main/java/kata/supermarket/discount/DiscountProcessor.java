package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Base interface for discount processors
 */
public interface DiscountProcessor {

    BigDecimal calculateDiscount(List<Item> discounts);
}