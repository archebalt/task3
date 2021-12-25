import task3.DeliveryMethod
import task3.Item
import task3.ItemEntry
import task3.Order

fun countDeliveryCost(price: DeliveryMethod): Double = when(price){
    is DeliveryMethod.CourierDelivery -> price.cost
    DeliveryMethod.SelfPickup -> 0.0
}

fun main() {
    val ord = Order(DeliveryMethod.CourierDelivery("home",1000.0), ItemEntry(Item("phone",25000.0), 3),20.0)
    val ord2 = Order(DeliveryMethod.SelfPickup, ItemEntry(Item("gameboy",5000.0), 3),20.0)
    println(ord.getTotalPrice()+ord2.getTotalPrice())
}