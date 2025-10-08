package org.example

class GeneralLedger(private val accounts: Map<String, Account>) {
    private val postings: MutableMap<String, MutableList<LedgerPosting>> = mutableMapOf()

    init { for (item in accounts.keys) postings[item] = mutableListOf() }

    fun postJournal(journalEntry: JournalEntry) {
        for (line in journalEntry.lines) {
            val list  = postings[line.accountId] ?: throw IllegalArgumentException("Account ${line.accountId} not found")
            list.add(LedgerPosting(journalEntry.date, line.description, line.debit, line.credit))
            accounts[line.accountId]?.balance += (line.debit - line.credit)
        }
    }

    fun getLedgerSummary() {
        println("LEDGER")
        for (account in accounts.values) {
            println("Account: ${account.name}")
            println("Date\t| Description\t| Debit\t| Credit")
            println("----------------------------------------")
            val list = postings[account.id] ?: listOf()
            if (list.isEmpty()) println("No Transaction") else for (item in list) println("${item.date}\t| ${item.description.padEnd(30).take(30)}\t|${formatAmount(item.debit)}\t|${formatAmount(item.credit)}")
            println("----------------------------------------")
            println("Current Balance: ${formatAmount(account.balance)}")
        }
        println()
    }

    fun getBalanceSummary() {
        println("BALANCE SUMMARY")
        for (account in accounts.values) println("${account.name}: ${formatAmount(account.balance)}")
        println()
    }
}
