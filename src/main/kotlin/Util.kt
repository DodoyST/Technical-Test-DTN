package org.example

import java.text.NumberFormat
import java.util.Locale

fun formatAmount(amount: Double) = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID")).format(amount)