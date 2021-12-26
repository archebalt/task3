import task3.DeliveryMethod
import task3.Item
import task3.ItemEntry
import task3.Order


fun main() {
    val delivery1 = DeliveryMethod.CourierDelivery("home" , 1000.0)
    val itemEntry1 = ItemEntry(Item("phone" , 25000.0) , 3)
    val order1 = Order(delivery1 , itemEntry1 , 20.0)
    val delivery2 = DeliveryMethod.SelfPickup
    val itemEntry2 = ItemEntry(Item("gameboy" , 5000.0) , 3)
    val order2 = Order(delivery2 , itemEntry2 , 20.0)
    println(order1.getTotalPrice() + order2.getTotalPrice())
}