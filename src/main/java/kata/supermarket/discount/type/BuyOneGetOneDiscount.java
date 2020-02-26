package kata.supermarket.discount.type;

import kata.supermarket.Item;

import java.util.List;

/**
 * Simple implementation of BuyOneGetOne pricing discount,
 * all products sold by unit are eligible for this discount,
 * the list of products eligible for discount can be narrowed by overriding filter method.
 */
public class BuyOneGetOneDiscount extends Discount {

    /**
     * Calculate the discount on all eligible products.
     * @param eligibleProducts
     * @return total discount on all eligible products.
     */
    @Override
    public int calculate(List<Item> eligibleProducts) {

        return 0;
    }

}