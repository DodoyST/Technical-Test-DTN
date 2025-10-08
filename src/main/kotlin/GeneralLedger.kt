package org.example

// Main class that handles journal posting and account balance updates
class GeneralLedger(private val accounts: Map<String, Account>) {
    // Stores all ledger postings per account
    private val postings: MutableMap<String, MutableList<LedgerPosting>> = mutableMapOf()

    // Initialize an empty list of postings for each account
    init {
        for (item in accounts.keys) postings[item] = mutableListOf()
    }

    // Post a single journal entry to the ledger
    fun postJournal(journalEntry: JournalEntry) {
        // Validate debit and credit balance
        val totalDebit = journalEntry.lines.sumOf { it.debit }
        val totalCredit = journalEntry.lines.sumOf { it.credit }
        if (totalDebit != totalCredit) {
            println("Journal on ${journalEntry.date} (${journalEntry.description}) is unbalance! Debit: ${formatAmount(totalDebit)} | Credit: ${formatAmount(totalCredit)}")
            throw IllegalArgumentException("Journal on ${journalEntry.date} is unbalanced! Please fix it before posting.")
        }

        // Validate accounts
        val invalidAccounts = journalEntry.lines.map { it.accountId }.filter { !accounts.containsKey(it) }
        if (invalidAccounts.isNotEmpty()) {
            throw IllegalArgumentException("Journal on ${journalEntry.date} contains INVALID account id : ${invalidAccounts.joinToString(", ")}")
        }

        // Passed validations, continue posting to ledger
        for (line in journalEntry.lines) {
            val list  = postings[line.accountId] ?: throw IllegalArgumentException("Account ${line.accountId} not found")
            list.add(LedgerPosting(journalEntry.date, line.description, line.debit, line.credit))
            accounts[line.accountId]?.balance += (line.debit - line.credit)
        }

        println("Journal on ${journalEntry.date} successfully posted.")
    }

    // Print a detailed ledger per account
    fun getLedgerSummary() {
        println("---------- LEDGER ----------")
        for (account in accounts.values) {
            println("Account: ${account.id} - ${account.name}")
            println(String.format(formatString, "Date", "Description", "Debit", "Credit"))
            println("--------------------------------------------------------------------------------")
            val list = postings[account.id] ?: listOf()
            if (list.isEmpty()) println("No Transaction") else for (item in list) println(String.format(formatString, item.date, item.description.padEnd(30).take(30), formatAmount(item.debit), formatAmount(item.credit)))
            println("--------------------------------------------------------------------------------")
            println("Current Balance: ${displayBalance(account.balance)}")
            println()
        }
    }

    // Print a summary of all account balances
    fun getBalanceSummary() {
        println("---------- BALANCE SUMMARY ----------")
        for (account in accounts.values) println("${account.id} - ${account.name}: ${displayBalance(account.balance)}")
        println()
    }
}
