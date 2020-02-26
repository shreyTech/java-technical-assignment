package kata.supermarket.discount.type;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Base class for defining a template for processing discounts;
 */
public abstract class Discount<T> {

    private static final BigDecimal ZERO_DISCOUNT = BigDecimal.ZERO;

    /**
     * Implements the basic algorithm for calculating discounts.
     * @param items list of all products in the basket.
     * @return total discount on all products.
     */
    public BigDecimal calculateDiscount(List<Item> items) {

        if (isActive()) {
            List<T> eligibleProducts = filter(items);
            return calculate(eligibleProducts);
        }

        return ZERO_DISCOUNT;
    }

    /**
     * calculate discount on all eligibleProducts products.
     * @param eligibleProducts
     * @return total discount on all eligible products.
     */
    protected abstract BigDecimal calculate(List<T> eligibleProducts);

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
    abstract protected List<T> filter(List<Item> products);

}