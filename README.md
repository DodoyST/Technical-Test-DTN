# 🧾 General Ledger Journal Processor (Kotlin)

This project is a **Kotlin console application** that processes accounting journal entries from a **JSON file** and automatically posts them into a **general ledger**.

Each journal entry updates the related account balances (assets, liabilities, revenue, etc.), producing a detailed ledger report and final account balance summary.


---

## 🧠 Features

- Read journal entries and accounts from a JSON file  
- Post each journal line (debit/credit) into a ledger  
- Update account balances directly inside the `Account` objects  
- Display formatted ledger reports in the console  
- Calculate and print final balances for each account  

---

## 📄 JSON Input Format (`journals.json`)

Below is an example of the input file structure used by the program.

> 🔸 You can name your file `journals.json` or modify the Kotlin program to load from another file path.

```json
{
  "accounts": [
    { "id": "101", "name": "Member Receivables", "type": "ASSET" },
    { "id": "102", "name": "Cash", "type": "ASSET" },
    { "id": "201", "name": "Member Loan Interest Income", "type": "REVENUE" }
  ],
  "journals": [
    {
      "date": "2025-06-15",
      "description": "Disbursement of financing for Member A (5 month term)",
      "lines": [
        { "accountId": "101", "description": "Loan Disbursement - Member Receivables", "debit": 30000000, "credit": 0 },
        { "accountId": "102", "description": "Loan Disbursement - Cash", "debit": 0, "credit": 30000000 }
      ]
    },
    {
      "date": "2025-07-14",
      "description": "Month 1 installment payment by Member A",
      "lines": [
        { "accountId": "102", "description": "Installment Payment - Cash", "debit": 6750000, "credit": 0 },
        { "accountId": "101", "description": "Installment Payment - Principal Repayment", "debit": 0, "credit": 6000000 },
        { "accountId": "201", "description": "Installment Payment - Interest Income", "debit": 0, "credit": 750000 }
      ]
    }
  ]
}
```

---

## 📊 Result (Program Output)

The following is an example of the program result code.

```bash
Journal on 2025-06-15 successfully posted.
Journal on 2025-07-14 successfully posted.
---------- LEDGER ----------
Account: 101 - Member Receivables
Date            | Description                    | Debit           | Credit         
--------------------------------------------------------------------------------
2025-06-15      | Loan Disbursement - Member Rec | Rp30.000.000,00 | Rp0,00         
2025-07-14      | Installment Payment - Principa | Rp0,00          | Rp6.000.000,00 
--------------------------------------------------------------------------------
Current Balance: Rp24.000.000,00 (Debit)

Account: 102 - Cash
Date            | Description                    | Debit           | Credit         
--------------------------------------------------------------------------------
2025-06-15      | Loan Disbursement - Cash       | Rp0,00          | Rp30.000.000,00
2025-07-14      | Installment Payment - Cash     | Rp6.750.000,00  | Rp0,00         
--------------------------------------------------------------------------------
Current Balance: Rp23.250.000,00 (Credit)

Account: 201 - Member Loan Interest Income
Date            | Description                    | Debit           | Credit         
--------------------------------------------------------------------------------
2025-07-14      | Installment Payment - Interest | Rp0,00          | Rp750.000,00   
--------------------------------------------------------------------------------
Current Balance: Rp750.000,00 (Credit)

---------- BALANCE SUMMARY ----------
101 - Member Receivables: Rp24.000.000,00 (Debit)
102 - Cash: Rp23.250.000,00 (Credit)
201 - Member Loan Interest Income: Rp750.000,00 (Credit)
```
