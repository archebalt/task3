package task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class countDeliveryCost
{

    @Test
    fun countDeliveryCostTest()
    {
        val Delivery = DeliveryMethod.CourierDelivery("home",1000.0)
        assertEquals(1000,Delivery)
    }

    @Test
    fun countDeliveryCostTest2()
    {
        val Delivery = DeliveryMethod.SelfPickup
        assertEquals(0,Delivery)
    }
}
