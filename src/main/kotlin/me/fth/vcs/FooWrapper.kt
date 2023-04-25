package me.fth.vcs

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class FooWrapper(val item: Foo)
