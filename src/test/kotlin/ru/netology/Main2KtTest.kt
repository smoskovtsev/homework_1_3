package ru.netology

import org.junit.Test

import org.junit.Assert.*

class Main2KtTest {

    @Test
    fun calculateFee_VK_account() {
        //Arrange
        val transferAmount = 5100_00
        val type = "VK"
        val monthlyAmount = 10000000
        //Act
        val fee = calculateFee(
            transferAmount = transferAmount,
            accountType = type,
            monthlyAmount = monthlyAmount
        )
        //Assert
        assertEquals(0, fee)
    }

    @Test
    fun calculateFee_Master_Maestro_account_belowNoFee() {
        //Arrange
        val transferAmount = 5100_00
        val type = "MasterCard"
        val monthlyAmount = 70_000_00
        //Act
        val fee = calculateFee(
            transferAmount = transferAmount,
            accountType = type,
            monthlyAmount = monthlyAmount
        )
        //Assert
        assertEquals(0, fee)
    }

    @Test
    fun calculateFee_Master_Maestro_account_aboveNoFee() {
        //Arrange
        val transferAmount = 5100_00
        val type = "MasterCard"
        val monthlyAmount = 100_000_00
        //Act
        val fee = calculateFee(
            transferAmount = transferAmount,
            accountType = type,
            monthlyAmount = monthlyAmount
        )
        //Assert
        assertEquals(5060, fee)
    }

    @Test
    fun calculateFee_Visa_Mir_account_belowThreshold() {
        //Arrange
        val transferAmount = 3100_00
        val type = "Visa"
        val monthlyAmount = 70_000_00
        //Act
        val fee = calculateFee(
            transferAmount = transferAmount,
            accountType = type,
            monthlyAmount = monthlyAmount
        )
        //Assert
        assertEquals(3500, fee)
    }

    @Test
    fun calculateFee_Visa_Mir_account_aboveThreshold() {
        //Arrange
        val transferAmount = 5100_00
        val type = "Visa"
        val monthlyAmount = 100_000_00
        //Act
        val fee = calculateFee(
            transferAmount = transferAmount,
            accountType = type,
            monthlyAmount = monthlyAmount
        )
        //Assert
        assertEquals(3825, fee)
    }
}