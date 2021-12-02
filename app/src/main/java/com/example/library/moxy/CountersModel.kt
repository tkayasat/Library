package com.example.library.moxy

import androidx.annotation.IntRange

class CountersModel {

    private val counters = Counters(0, 0, 0)

    fun increment1(): Int {
        counters.counters1 += 1
        return counters.counters1
    }

    fun increment2(): Int {
        counters.counters2 += 1
        return counters.counters2
    }

    fun increment3(): Int {
        counters.counters3 += 1
        return counters.counters3
    }

    fun set(@IntRange(from = 0, to = 2) index: Int, value: Int) = when (index) {
        0 -> counters.counters1 = value
        0 -> counters.counters2 = value
        0 -> counters.counters3 = value
        else -> error("Wrong index")
    }

    data class Counters(
        var counters1: Int,
        var counters2: Int,
        var counters3: Int,
    )
}
