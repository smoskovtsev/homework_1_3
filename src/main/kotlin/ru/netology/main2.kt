package ru.netology

val masterMaestroFeeVar: Double = 0.006
val masterMaestroFeeFix: Int = 20_00
val masterMaestroNoFeeLimit: Int = 75_000_00
val visaMirFeeVar: Double = 0.0075
val visaMirFeeMin: Int = 35_00

fun main() {
    val transferAmount = 5100_00
    val feeAmount = calculateFee(transferAmount)
    println("Сумма перевода: $transferAmount копеек")
    println("Сумма комиссии: $feeAmount копеек")
}

fun calculateFee (
    transferAmount: Int,
    accountType: String = "Visa",
    monthlyAmount: Int = 10000000
): Int {
    return when (accountType) {
        "VK" -> 0
        "MasterCard","Maestro" -> if (monthlyAmount < masterMaestroNoFeeLimit) 0 else ((transferAmount * masterMaestroFeeVar).toInt() + masterMaestroFeeFix)
        "Visa","Mir" -> {
            val visaMirFeeThreshold = transferAmount * visaMirFeeVar
            if (visaMirFeeThreshold.toInt() < visaMirFeeMin) visaMirFeeMin else (visaMirFeeThreshold.toInt())
        }
            else -> 0
    }
}