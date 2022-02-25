package ru.netology

const val MINUTE: Int = 60
const val HOUR: Int = 3600
const val DAY: Int = 86400
const val TWO_DAYS: Int = DAY * 2
const val THREE_DAYS: Int = DAY * 3

fun main() {
    val timeAgo = 18000
    println("Пользователь был(а) " + agoToText(timeAgo))
}

fun agoToText(time: Int): String {
    return when {
        time < MINUTE -> "только что"
        time < HOUR -> {
            val timeConvert = time / MINUTE
            "$timeConvert ${minutesSpell(timeConvert)} назад"
        }
        time < DAY -> {
            val timeConvert = time / HOUR
            "$timeConvert ${hoursSpell(timeConvert)} назад"
        }
        time < (TWO_DAYS) -> "сегодня"
        time < (THREE_DAYS) -> "вчера"
        else -> "давно"
    }
}

//fun timeConvert(time: Int): Int {
//    return if (time < HOUR) (time / MINUTE) else (time / HOUR)
//}

//fun hoursConvert(time: Int): Int {
//    return if (time < DAY) (time / HOUR)
//    return when {
//        time < DAY -> time / HOUR
//        else -> 0
//    }
//}

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


