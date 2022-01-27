package lab7

import lab3.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SerializersModuleTest {
    @Test
    fun testEncode() {
        val a = Triangle(1.2, 1.3, 1.3)
        val b = Circle(2.4)
        val c = Rectangle(2.4, 5.3)
        val k = SerializersModule()
        val l: List<Shape> = listOf(a, b, c)
        val t: String = "[\n" +
                "    {\n" +
                "        \"type\": \"lab3.Triangle\",\n" +
                "        \"sideA\": 1.2,\n" +
                "        \"sideB\": 1.3,\n" +
                "        \"sideC\": 1.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"type\": \"lab3.Circle\",\n" +
                "        \"radius\": 2.4\n" +
                "    },\n" +
                "    {\n" +
                "        \"type\": \"lab3.Rectangle\",\n" +
                "        \"sideA\": 2.4,\n" +
                "        \"sideB\": 5.3\n" +
                "    }\n" +
                "]"
        val q: String = k.encode(l)
        Assertions.assertEquals(q, t)
    }

    @Test
    fun testDecode() {
        val a = Triangle(1.2, 1.3, 1.3)
        val b = Circle(2.4)
        val c = Rectangle(2.4, 5.3)
        val k = SerializersModule()
        val l: List<Shape> = listOf(a, b, c)
        val f = FileIO()
        val t = "C:\\task31\\src\\test\\kotlin\\lab7\\Test.json"
        k.decode(f.read(t)).toMutableList()
        f.write(t, k.encode(l))
    }
}