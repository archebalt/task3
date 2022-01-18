package task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OrderTest
{

    @Test
    fun getTotalPriceTest()
    {
        val ordPrice = Order(DeliveryMethod.CourierDelivery("home",2000.0), ItemEntry(Item("phone",20000.0), 3),10.0).getTotalPrice()
        assertEquals(55800.0,ordPrice)
    }

    @Test
    fun getTotalPriceTest2()
    {
        val ordPrice1 = Order(DeliveryMethod.SelfPickup, ItemEntry(Item("computer",35000.0), 2),0.0).getTotalPrice()
        assertEquals(70000.0,ordPrice1)
    }
}