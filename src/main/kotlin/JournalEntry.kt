package org.example

import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate

// One journal entry (transaction) that may involve multiple accounts
@Serializable
data class JournalEntry(
    val date: LocalDate, // transaction date in ISO format (YYYY-MM-DD)
    val description: String, // general transaction description
    val lines: List<JournalLine>, // list of debit/credit lines
)
