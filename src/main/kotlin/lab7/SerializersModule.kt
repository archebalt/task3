package lab7

import kotlinx.serialization.*
import lab3.*
import kotlinx.serialization.modules.*
import kotlinx.serialization.json.Json

class SerializersModule {
    private val json = Json {
        prettyPrint = true

        serializersModule = SerializersModule {
            polymorphic(Shape::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
                subclass(Triangle::class)
            }
        }
    }

    fun encode(arr: List<Shape>) = json.encodeToString(arr)

    fun decode(str: String) = json.decodeFromString<List<Shape>>(str)
}