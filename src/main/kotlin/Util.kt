package org.example

import java.text.NumberFormat
import java.util.Locale

// Format string like table
const val formatString = "%-15s | %-30s | %-15s | %-15s"

// Format number with thousands separator (e.g., Rp 30.000.000)
fun formatAmount(amount: Double): String? = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID")).format(amount)

// Show whether a balance is debit or credit based on its sign
fun displayBalance(balance: Double): String {
    return if (balance == 0.0) {
        formatAmount(balance) + " (Zero)"
    } else if (balance > 0) {
        formatAmount(balance) + " (Debit)"
    } else {
        formatAmount(-balance) + " (Credit)"
    }
}