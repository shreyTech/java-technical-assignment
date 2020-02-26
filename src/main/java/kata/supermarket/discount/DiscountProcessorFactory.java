package kata.supermarket.discount;

/**
 * Factory class for getting discountProcessors, this is a simple implementation for now but
 * can be changed to accommodate complex requirements.
 * For instance, creating different type of DiscountProcessors for different type of stores
 * or for different cities or geographical location.
 */
public final class DiscountProcessorFactory {

    private static DiscountProcessorFactory factory = new DiscountProcessorFactory();
    private DiscountProcessor discountProcessor = new GenericDiscountProcessor();

    private DiscountProcessorFactory() {
    }

    /**
     * @return a singleton instance of DiscountProcessorFactory.
     */
    public static DiscountProcessorFactory getInstance() {
        return factory;
    }

    /**
     * @return a generic discount processor.
     */
    public DiscountProcessor getDiscountProcessor() {
        return discountProcessor;
    }
}
