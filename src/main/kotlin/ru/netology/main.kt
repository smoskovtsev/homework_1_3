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
            val amount = time / MINUTE
            "$amount ${spell(amount, "минуту", "минуты", "минут")} назад"
        }
        time < DAY -> {
            val amount = time / HOUR
            "$amount ${spell(amount, "час", "часа", "часов")} назад"
        }
        time < (TWO_DAYS) -> "сегодня"
        time < (THREE_DAYS) -> "вчера"
        else -> "давно"
    }
}

fun spell(amount: Int, one: String, few: String, many: String): String {
    return when {
        (amount % 10) == 1 && (amount % 100) != 11 -> one
        (amount % 10) >= 2 && (amount % 10) <= 4 && (amount % 100 < 10 || amount % 100 >= 20) -> few
        else -> many
    }
}


