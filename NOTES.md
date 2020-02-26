# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I have used the following patterns for modelling a pricing discount system, the idea is to provide an implementation of
pricing discount schemes with sufficient extension points so it can be extended later but providing a skeleton (algorithm)
for making it easier to understand and maintain the code.

1. Factory  --> For creating different type of discountProcessors, there is only one implementation (GenericDiscountProcessor)
                to start with but this can be changed later to support different types of DiscountProcessors, for instance :
				for different type of stores or for different location etc.
2. Template --> For modelling discount, this would provide a skeleton of an operation in terms of high level steps but
				still provide the flexibility of creating new type of discounts by extending the base template.

Apologies, I was not able to complete a working implementation of the pricing discount system in the given time,
I was looking to implement BuyOneGetOne discount strategy, but further changes would be required in Product and Items
to be able to categorise products so that the products can be grouped by their quantities in BuyOneGetOneDiscount
and discount can be calculated effectively.
But I have managed to provide a high level implementation model in the given time which can be extended to add more
functionality in future.
