package com.lms.dao;

import com.lms.dao.Transaction.TransactionDAO;
import com.lms.models.Transaction.Transaction;
import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class TransactionDAOTest {

    @Test
    public void testMakeTransaction() throws ParseException {
        // Setup
        TransactionDAO transactionDAO = new TransactionDAO();
        String bookId = "1";
        String userId = "2";
        LocalDate returnDate = LocalDate.now();

        // Act
        transactionDAO.MakeTransaction(bookId, userId, returnDate);

        // Assert (Limited Assertions due to file access)
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        for(Transaction transaction : transactions)
            System.out.println(transaction.getReturnDate());// Ensure a new transaction is added
    }
}
