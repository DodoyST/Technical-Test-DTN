package org.example

import kotlinx.serialization.Serializable

@Serializable
enum class AccountType {
    ASSET,
    LIABILITY,
    EQUITY,
    REVENUE,
    EXPENSE,
    OTHER,
}