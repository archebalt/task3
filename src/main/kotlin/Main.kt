fun countDeliveryCost(price: DeliveryMethod): Double = when(price){
    is DeliveryMethod.CourierDelivery -> price.cost
    DeliveryMethod.SelfPickup -> 0.0
}

fun main(args: Array<String>) {
   val item = Item("phone", 25000.0)
    println(item)
    val deliveryCost = DeliveryMethod.CourierDelivery("home", 1000.0)
    println(countDeliveryCost(deliveryCost))
}