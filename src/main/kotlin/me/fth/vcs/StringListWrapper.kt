package me.fth.vcs

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class StringListWrapper(val items: List<String>)
