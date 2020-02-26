package kata.supermarket.discount.type;

import kata.supermarket.Item;

import java.util.List;

/**
 * Base class for defining a template for processing discounts;
 */
public abstract class Discount {

    private static final Integer ZERO_DISCOUNT = 0;

    /**
     * Implements the basic algorithm for calculating discounts.
     * @param products list of all products in the basket.
     * @return total discount on all products.
     */
    public int calculateDiscount(List<Item> products) {

        if (isActive()) {
            List<Item> eligibleProducts = filter(products);
            return calculate(eligibleProducts);
        }

        return ZERO_DISCOUNT;
    }

    /**
     * calculate discount on all eligibleProducts products.
     * @param eligibleProducts
     * @return total discount on all eligible products.
     */
    public abstract int calculate(List<Item> eligibleProducts);

    /**
     * Although there is no requirement to have discounts as active or inactive,
     * but in real life discouts have a time duration, so this method
     * is just to show that such requirements can be easily modelled in
     * a template and the fuctionality can be extended in a clean way.
     * @return true if the discount is active.
     */
    protected boolean isActive() {
        return true;
    }

    /**
     * @param products List of products on which discounts can be applied.
     * @return list of products which are eligible for pricing discount.
     */
    protected List<Item> filter(List<Item> products) {
        return products;
    }

}