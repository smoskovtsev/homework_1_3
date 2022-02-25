package ru.netology

const val MASTER_MAESTRO_FEE_VAR: Double = 0.006
const val MASTER_MAESTRO_FEE_FIX: Int = 20_00
const val MASTER_MAESTRO_FEE_NO_LIMIT: Int = 75_000_00
const val VISA_MIR_FEE_VAR: Double = 0.0075
const val VISA_MIR_FEE_MIN: Int = 35_00

fun main() {
    val transferAmount = 3100_00
    val feeAmount = calculateFee(transferAmount)
    println("Сумма перевода: $transferAmount копеек")
    println("Сумма комиссии: $feeAmount копеек")
}

fun calculateFee (
    transferAmount: Int,
    accountType: String = "VK",
    monthlyAmount: Int = 0
): Int {
    return when (accountType) {
        "VK" -> 0
        "MasterCard","Maestro" -> if (monthlyAmount < MASTER_MAESTRO_FEE_NO_LIMIT) 0 else ((transferAmount * MASTER_MAESTRO_FEE_VAR).toInt() + MASTER_MAESTRO_FEE_FIX)
        "Visa","Mir" -> {
            val visaMirFeeThreshold = transferAmount * VISA_MIR_FEE_VAR
            if (visaMirFeeThreshold < VISA_MIR_FEE_MIN) VISA_MIR_FEE_MIN else (visaMirFeeThreshold.toInt())
        }
            else -> error("Неподдерживаемый тип счёта: $accountType")
    }
}