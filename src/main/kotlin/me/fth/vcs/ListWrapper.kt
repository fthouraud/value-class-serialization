package me.fth.vcs

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class ListWrapper<T>(val items: List<T>)

typealias StringListWrapperAlias = ListWrapper<String>
