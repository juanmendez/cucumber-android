package cucumber.cukeulator.test

import java.util.Comparator
import java.util.function.Function
import java.util.function.ToDoubleFunction
import java.util.function.ToIntFunction
import java.util.function.ToLongFunction

class SomeClassWithUnsupportedApi : Comparator<Int?> {
    override fun compare(o1: Int?, o2: Int?): Int {
        return 0
    }

    override fun reversed(): Comparator<Int?>? {
        return null
    }

    override fun thenComparing(other: Comparator<in Int?>): Comparator<Int?>? {
        return null
    }

    override fun <U> thenComparing(
        keyExtractor: Function<in Int?, out U?>,
        keyComparator: Comparator<in U?>
    ): Comparator<Int?>? {
        return null
    }

    override fun <U : Comparable<U?>?> thenComparing(keyExtractor: Function<in Int?, out U?>): Comparator<Int?>? {
        return null
    }

    override fun thenComparingInt(keyExtractor: ToIntFunction<in Int?>): Comparator<Int?>? {
        return null
    }

    override fun thenComparingLong(keyExtractor: ToLongFunction<in Int?>): Comparator<Int?>? {
        return null
    }

    override fun thenComparingDouble(keyExtractor: ToDoubleFunction<in Int?>): Comparator<Int?>? {
        return null
    }
}