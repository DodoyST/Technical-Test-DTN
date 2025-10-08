package org.example

import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate

@Serializable
data class JournalEntry(
    val date: LocalDate,
    val description: String,
    val lines: List<JournalLine>,
)
