package org.example

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val jsonFile = File("journals.json")
    if (!jsonFile.exists()) {
        println("Journal file does not exist")
        return
    }
    val jsonContent = jsonFile.readText()
    val parsed = Json.decodeFromString<JournalFile>(jsonContent)
    val ledger = GeneralLedger(parsed.accounts.associateBy { it.id })
    for (journal in parsed.journals) ledger.postJournal(journal)
    ledger.getLedgerSummary()
    ledger.getBalanceSummary()
}
