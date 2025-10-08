package org.example

import kotlinx.serialization.Serializable

// Structure of the JSON file containing accounts and journal entries
@Serializable
data class JournalFile(
    val accounts: List<Account>,
    val journals: List<JournalEntry>,
)
