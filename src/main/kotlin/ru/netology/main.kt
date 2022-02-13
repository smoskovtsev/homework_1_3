package ru.netology

fun main() {
    val timeAgo = 97200
    agoToText(timeAgo)
}

fun timeText(time: Int): String {
    return when {
        time < 60 -> "только что"
        time < (60 * 60) -> "" + secondsConvert(time) + " " + minutesSpell(secondsConvert(time)) + " назад"
        time < (24 * 60 * 60) -> "" + secondsConvert(time) + " " + hoursSpell(secondsConvert(time)) + " назад"
        time < (48 * 60 * 60) -> "сегодня"
        time < (72 * 60 * 60) -> "вчера"
        else -> "давно"
    }
}

fun agoToText(time: Int) {
    println("Пользователь был(а) " + timeText(time))
}

fun secondsConvert(time: Int): Int {
    return when {
        time < 3600 -> time / 60
        time < (24 * 3600) -> time / 3600
        else -> 0
    }
}

fun minutesSpell(time: Int): String {
    return when (time) {
        1,21,31,41,51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..59 -> "минут"
        else -> ""
    }
}

fun hoursSpell(time: Int): String {
    return when (time) {
        1,21,31,41 -> "час"
        in 2..4,in 22..24,in 32..34, in 42..44 -> "часа"
        in 5..20, in 25..30, in 35..40, in 45..47 -> "часов"
        else -> ""
    }
}


