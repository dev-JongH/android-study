package com.android.kotlin


inline fun function(
    inlined: () -> Unit,
    noinline noInlined: () -> Unit,
) {
    inlined()
    noInlined.toString() // ok
}

// decompile
fun functionTest() {
    function(
        inlined = { println("inline function") },
        noInlined = { println("noInlined function") }
    )
}

interface Listener {
    fun notify()
}

inline fun localFunction(crossinline notify: () -> Unit) {
    val listener = object : Listener {
        override fun notify() = notify()
    }

    listener.notify()
}



