package me.fth.vcs

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class Wrapper<T>(val items: T)
