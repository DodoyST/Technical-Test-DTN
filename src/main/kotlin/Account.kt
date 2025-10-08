package org.example

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val name: String,
    val type: AccountType = AccountType.OTHER,
    var balance: Double = 0.0,
)