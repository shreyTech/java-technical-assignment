package kata.supermarket;

import kata.supermarket.discount.DiscountProcessor;
import kata.supermarket.discount.DiscountProcessorFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {

        private DiscountProcessor discountProcessor;
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
            this.discountProcessor = DiscountProcessorFactory.getInstance().getDiscountProcessor();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }


        private BigDecimal discounts() {
            return BigDecimal.ZERO;
        }

        private BigDecimal calculate() {
            BigDecimal discount = discountProcessor.calculateDiscount(items);
            return subtotal().subtract(discount);
        }
    }
}
