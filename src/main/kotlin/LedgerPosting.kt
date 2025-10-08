package org.example

import kotlinx.datetime.LocalDate

// Represents a single posting (record) in the ledger
data class LedgerPosting(
    val date: LocalDate,
    val description: String,
    val debit: Double,
    val credit: Double,
)
