import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (firstList, secondList) = input.map {
            val line = it.split(" ").filter { it.isNotBlank() }
            Pair(line[0], line[1])
        }.unzip()

        val sotedFirstList = firstList.map { it.toInt() }.sorted()
        val sotedSecondList = secondList.map { it.toInt() }.sorted()

        return sotedFirstList.zip(sotedSecondList).map {
            abs(it.first - it.second)
        }.sum()
    }

fun part2(input: List<String>): Int {
    val (firstList, secondList) = input.map {
        val line = it.split(" ").filter { it.isNotBlank() }
        Pair(line[0], line[1])
    }.unzip()

    return firstList.sumOf { it1 ->
        secondList.count { it2 -> it1 == it2 } * it1.toInt()
    }
}

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01/Day01_test")
    println(part1(testInput))
    println(part2(testInput))

//    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01/Day01")
    part1(input).println()
    part2(input).println()
}
