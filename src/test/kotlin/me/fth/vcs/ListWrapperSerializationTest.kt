package me.fth.vcs

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ListWrapperSerializationTest {
    private val stringsWrapper = ListWrapper(listOf("foo", "bar"))
    private val aliasedWrapper = StringListWrapperAlias(listOf("foo", "bar"))
    private val fooWrapper = ListWrapper(listOf(Foo(42), Foo(13)))

    private val jsonStringsArray = """["foo","bar"]"""
    private val jsonObjectsArray = """[{"bar":42},{"bar":13}]"""

    @Test
    fun `should serialize a JSON array of strings from a value class wrapper`() {
        assertEquals(jsonStringsArray, Json.encodeToString(stringsWrapper))
    }

    @Test
    fun `should deserialize a JSON array of strings to a value class wrapper`() {
        assertEquals(stringsWrapper, Json.decodeFromString(jsonStringsArray))
    }

    @Test
    fun `should serialize a JSON array of strings from a value class wrapper (alias)`() {
        assertEquals(jsonStringsArray, Json.encodeToString(aliasedWrapper))
    }

    @Test
    fun `should deserialize a JSON array of strings to a value class wrapper (alias)`() {
        assertEquals(aliasedWrapper, Json.decodeFromString(jsonStringsArray))
    }

    @Test
    fun `should serialize a JSON array of objects from a value class wrapper`() {
        assertEquals(jsonObjectsArray, Json.encodeToString(fooWrapper))
    }

    @Test
    fun `should deserialize a JSON array of objects to a value class wrapper`() {
        assertEquals(fooWrapper, Json.decodeFromString(jsonObjectsArray))
    }
}
