package me.fth.vcs

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class FooListWrapperSerializationTest {
    private val wrapper = FooListWrapper(listOf(Foo(42), Foo(13)))

    private val jsonValue = """[{"bar":42},{"bar":13}]"""

    @Test
    fun `should serialize a JSON array of objects from a value class wrapper`() {
        assertEquals(jsonValue, Json.encodeToString(wrapper))
    }

    @Test
    fun `should deserialize a JSON array of objects to a value class wrapper`() {
        assertEquals(wrapper, Json.decodeFromString(jsonValue))
    }
}
