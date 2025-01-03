package com.android.patterns.delegation


fun delegationPattern() {
    val impl = IntValueImpl(value = 10)
    val subImpl = StringValueImpl(value = "Hi")

    Derived(impl = impl).method()
    Derived(impl = subImpl).method()
}

interface Interface {
    val tag: String

    fun method()
}

internal class IntValueImpl(private val value: Int): Interface {
    override val tag: String = "IntValueImpl [$value]"

    override fun method() {
        println(tag)
        println("implement: $value")
    }
}

internal class StringValueImpl(private val value: String): Interface {
    override val tag: String = "StringValueImpl [$value]"

    override fun method() {
        println(tag)
        println("implement: $value")
    }

}

class Derived(impl: Interface): Interface by impl