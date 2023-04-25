package me.fth.vcs

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class FooListWrapper(val items: List<Foo>)
