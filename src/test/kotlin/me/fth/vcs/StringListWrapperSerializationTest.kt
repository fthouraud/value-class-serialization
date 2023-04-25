package me.fth.vcs

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class StringListWrapperSerializationTest {
    private val wrapper = StringListWrapper(listOf("foo", "bar"))

    private val jsonValue = """["foo","bar"]"""

    @Test
    fun `should serialize a JSON array of strings from a value class wrapper`() {
        assertEquals(jsonValue, Json.encodeToString(wrapper))
    }

    @Test
    fun `should deserialize a JSON array of strings to a value class wrapper`() {
        assertEquals(wrapper, Json.decodeFromString(jsonValue))
    }
}
