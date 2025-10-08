package org.example

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    // Load JSON file from the working directory
    val jsonFile = File("journals.json")
    if (!jsonFile.exists()) {
        println("Journal file does not exist")
        return
    }

    // Read and parse JSON content
    val jsonContent = jsonFile.readText()
    val parsed = Json.decodeFromString<JournalFile>(jsonContent)

    // Create a ledger with accounts mapped by account id
    val ledger = GeneralLedger(parsed.accounts.associateBy { it.id })

    // Post every journal entry into the ledger
    for (journal in parsed.journals) ledger.postJournal(journal)

    // Display the ledger and final balances
    ledger.getLedgerSummary()
    ledger.getBalanceSummary()
}
