package task3

import countDeliveryCost

data class Order(val deliveryMethod:DeliveryMethod,val itemEntry: ItemEntry, val totalDiscount: Double)
{
    fun getTotalPrice(): Double
    {
        return (countDeliveryCost(deliveryMethod) + itemEntry.item.price * itemEntry.amount) * ((100 - totalDiscount) * 0.01)
    }
}