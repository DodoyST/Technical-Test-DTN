package org.example

import kotlinx.datetime.LocalDate

data class LedgerPosting(
    val date: LocalDate,
    val description: String,
    val debit: Double,
    val credit: Double,
)
