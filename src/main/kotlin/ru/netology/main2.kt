package ru.netology

fun main() {
    val transferAmount = 5000_00
    val feeAmount = calculateFee(transferAmount)
    println("Сумма перевода: $transferAmount копеек")
    println("Сумма комиссии: $feeAmount копеек")
}

fun calculateFee (
    transferAmount: Int,
    accountType: String = "VK",
    totalAmount: Int = 0,
    MasterMaestroFeeVar: Double = 0.006,
    MasterMaestroFeeFix: Int = 20_00,
    MasterMaestroNoFeeLimit: Int = 75_000_00,
    VisaMirFeeVar: Double = 0.0075,
    VisaMirFeeMin: Int = 35_00
): Int {
    return when (accountType) {
        "VK" -> 0
        "MasterCard","Maestro" -> if (totalAmount < MasterMaestroNoFeeLimit) 0 else ((transferAmount * MasterMaestroFeeVar).toInt() + MasterMaestroFeeFix)
        "Visa","Mir" -> if ((transferAmount * VisaMirFeeVar).toInt() < VisaMirFeeMin) VisaMirFeeMin else ((transferAmount * VisaMirFeeVar).toInt())
            else -> 0
    }
}