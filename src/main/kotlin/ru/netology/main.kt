package ru.netology

const val MINUTE: Int = 60
const val HOUR: Int = 3600
const val DAY: Int = 86400

fun main() {
    val timeAgo = 54000
    println("Пользователь был(а) " + agoToText(timeAgo))
}

fun agoToText(time: Int): String {
    return when {
        time < MINUTE -> "только что"
        time < HOUR -> "${minutesConvert(time)} ${minutesSpell(minutesConvert(time))} назад"
        time < DAY -> "${hoursConvert(time)} ${hoursSpell(hoursConvert(time))} назад"
        time < (DAY * 2) -> "сегодня"
        time < (DAY * 3) -> "вчера"
        else -> "давно"
    }
}

fun minutesConvert(time: Int): Int {
    return when {
        time < HOUR -> time / 60
        else -> 0
    }
}

fun hoursConvert(time: Int): Int {
    return when {
        time < DAY -> time / HOUR
        else -> 0
    }
}

fun minutesSpell(time: Int): String {
    return when {
        (time % 10) == 1 && (time % 100) != 11 -> "минуту"
        (time % 10) >= 2 && (time % 10) <= 4 && (time % 100 < 10 || time % 100 >= 20) -> "минуты"
        else -> "минут"
    }
}

fun hoursSpell(time: Int): String {
    return when {
        (time % 10) == 1 && (time % 100) != 11 -> "час"
        (time % 10) >= 2 && (time % 10) <= 4 && (time % 100 < 10 || time % 100 >= 20) -> "часа"
        else -> "часов"
    }
}


