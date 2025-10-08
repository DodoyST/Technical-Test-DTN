package org.example

import kotlinx.serialization.Serializable

@Serializable
data class JournalLine(
    val accountId: String,
    val description: String,
    val debit: Double = 0.0,
    val credit: Double = 0.0,
)
