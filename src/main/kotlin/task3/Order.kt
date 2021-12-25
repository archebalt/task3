package task3



data class Order(val deliveryMethod:DeliveryMethod,val itemEntry: ItemEntry, val totalDiscount: Double)
{
    fun getTotalPrice(): Double
    {
        val deliveryCost: Double = when(deliveryMethod) {
            is DeliveryMethod.CourierDelivery -> deliveryMethod.cost
            DeliveryMethod.SelfPickup -> 0.0
        }
        val itemCost = itemEntry.item.price * itemEntry.amount
        val withDiscount = ((100 - totalDiscount) * 0.01)
        return (deliveryCost + itemCost) * withDiscount
    }
}