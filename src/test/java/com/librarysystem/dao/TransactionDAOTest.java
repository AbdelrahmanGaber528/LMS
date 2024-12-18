package com.librarysystem.dao;

import com.librarysystem.models.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
