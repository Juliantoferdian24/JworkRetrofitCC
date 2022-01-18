package com.ferdian.jworkretrofitcc

data class Bonus(
    val active: Boolean,
    val extraFee: Int,
    val id: Int,
    val minTotalFee: Int,
    val referralCode: String
)