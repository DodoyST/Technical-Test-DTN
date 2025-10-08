package org.example

import kotlinx.serialization.Serializable

// Represents an account in the ledger
@Serializable
data class Account(
    val id: String, // account id (e.g., 101)
    val name: String, // account name (e.g., Member Receivable)
    val type: AccountType = AccountType.OTHER, // optional account type
    var balance: Double = 0.0, // current account balance, updated after posting
)