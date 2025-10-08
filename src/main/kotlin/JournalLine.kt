package org.example

import kotlinx.serialization.Serializable

// A single line inside a journal entry (debit or credit to an account)
@Serializable
data class JournalLine(
    val accountId: String, // reference to the account id
    val description: String, // description of the transaction
    val debit: Double = 0.0, // debit amount
    val credit: Double = 0.0, // credit amount
)
