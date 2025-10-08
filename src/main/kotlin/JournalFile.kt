package org.example

import kotlinx.serialization.Serializable

@Serializable
data class JournalFile(
    val accounts: List<Account>,
    val journals: List<JournalEntry>,
)
