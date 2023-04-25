package me.fth.vcs

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class WrapperSerializationTest {
    private val wrapper = Wrapper(Foo(42))

    private val jsonObject = """{"bar":42}"""

    @Test
    fun `should serialize a JSON object from a value class wrapper`() {
        assertEquals(jsonObject, Json.encodeToString(wrapper))
    }

    @Test
    fun `should deserialize a JSON object to a value class wrapper`() {
        assertEquals(wrapper, Json.decodeFromString(jsonObject))
    }
}
