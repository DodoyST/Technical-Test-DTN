package org.example

import kotlinx.serialization.Serializable

// Account type enumeration (useful for expansion later)
@Serializable
enum class AccountType {
    ASSET,
    LIABILITY,
    EQUITY,
    REVENUE,
    EXPENSE,
    OTHER,
}