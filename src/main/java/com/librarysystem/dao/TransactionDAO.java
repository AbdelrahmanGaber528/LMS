package com.librarysystem.dao;

import com.librarysystem.models.Transaction;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionDAO {

    private final LMSFileManager transactionFileManager = new LMSFileManager("src\\main\\docs\\Transactions.txt");
    private static int transactionIdCounter = 0;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TransactionDAO() {
        File file = new File("src\\main\\docs\\transactionIdCounter.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                transactionIdCounter = Integer.parseInt(reader.readLine().trim());
            } catch (IOException e) {
                System.err.println("Can't read the transaction ID from file: " + e.getMessage());
            }
        }
    }

    public void MakeTransaction(int bookId, int userId, Date returnDate) {
        try {
            int newTransactionId = generateTransactionId();
            Transaction transaction = new Transaction(newTransactionId, bookId, userId,  returnDate, false);
            transactionFileManager.insertRow(mapTransactionToData(transaction));
        } catch (IOException e) {
            System.err.println("Problem in issuing book: " + e.getMessage());
        }
    }

    public void returnBook(int transactionId) {
        try {
            List<String> allTransactions = transactionFileManager.getAllRows();
            for (String t : allTransactions) {
                Transaction transaction = mapDataToTransaction(t);
                if (transaction.getTransactionId() == transactionId) {
                    transaction.setReturned(true);
                    transactionFileManager.updateRow(mapTransactionToData(transaction));
                    break;
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error in returning book: " + e.getMessage());
        }
    }

    public List<Transaction> getTransactionsByUser(int userId) {
        List<Transaction> userTransactions = new ArrayList<>();
        try {
            List<String> allTransactions = transactionFileManager.getAllRows();
            for (String t : allTransactions) {
                Transaction transaction = mapDataToTransaction(t);
                if (transaction.getUserId() == userId) {
                    userTransactions.add(transaction);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error in fetching user transactions: " + e.getMessage());
        }
        return userTransactions;
    }

    private int generateTransactionId() {
        transactionIdCounter++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\docs\\transactionIdCounter.txt"))) {
            writer.write(String.valueOf(transactionIdCounter));
        } catch (IOException e) {
            System.err.println("Can't write new transaction ID to file: " + e.getMessage());
        }
        return transactionIdCounter;
    }

    private Map<ColumnName, String> mapTransactionToData(Transaction transaction) {
        Map<ColumnName, String> data = new TreeMap<>();
        data.put(ColumnName.TRANSACTION_ID, String.valueOf(transaction.getTransactionId()));
        data.put(ColumnName.BOOK_ID, String.valueOf(transaction.getBookId()));
        data.put(ColumnName.USER_ID, String.valueOf(transaction.getUserId()));
        data.put(ColumnName.ISSUE_DATE, dateFormat.format(transaction.getIssueDate()));
        data.put(ColumnName.RETURN_DATE, dateFormat.format(transaction.getReturnDate()));
        data.put(ColumnName.IS_AVAILABLE, String.valueOf(transaction.isReturned()));
        return data;
    }

    private Transaction mapDataToTransaction(String data) throws ParseException {
        String[] values = data.split("\t");
        int transactionId = Integer.parseInt(values[0]);
        int bookId = Integer.parseInt(values[1]);
        int userId = Integer.parseInt(values[2]);
        Date issueDate = dateFormat.parse(values[3]);
        Date returnDate = dateFormat.parse(values[4]);
        boolean isReturned = Boolean.parseBoolean(values[5]);
        return new Transaction(transactionId, bookId, userId, returnDate, isReturned);
}}