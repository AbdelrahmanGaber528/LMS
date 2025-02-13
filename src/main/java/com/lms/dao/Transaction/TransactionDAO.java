package com.lms.dao.Transaction;

import com.lms.models.Transaction.Transaction;
import com.lms.util.ColumnName;
import com.lms.util.LMSFileManager;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class TransactionDAO {

    private final LMSFileManager transactionFileManager;
    private static int transactionIdCounter = 0;

    public TransactionDAO() {
        transactionFileManager  = new LMSFileManager("src/main/docs/Transaction.txt");
        File file = new File("src/main/docs/bookIdCounter.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                transactionIdCounter = Integer.parseInt(reader.readLine().trim());
            } catch (IOException e) {
                System.err.println("Can't read the transaction ID from file: " + e.getMessage());
            }
        }
    }

    public void MakeTransaction(String bookId, String userId, LocalDate returnDate) {
        try {
            int newTransactionId = generateTransactionId();
            Transaction transaction = new Transaction(newTransactionId, bookId, userId,  returnDate, false);
            transactionFileManager.insertRow(mapTransactionToData(transaction));
        } catch (IOException e) {
            System.err.println("Problem in issuing book: " + e.getMessage());
        }
    }

    public void updateTransaction(int transactionId) {

        List<Transaction> transactions = getAllTransactions();
        for(Transaction transaction : transactions){
            if (transaction.getTransactionId() == transactionId){
                transaction.setReturned(true);
                transactionFileManager.updateRow(mapTransactionToData(transaction));
                break;
            }
        }
    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        try{
            List<String> rows = transactionFileManager.getAllRows();
            for(int i = 1;i<rows.size();i++){
                String t = rows.get(i);
                Transaction transaction = mapDataToTransaction(t);
                transactions.add(transaction);
            }
        }catch (IOException e ){
            System.err.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    private int generateTransactionId() {
        transactionIdCounter++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/docs/idCounter.txt"))) {
            writer.write(String.valueOf(transactionIdCounter));
        } catch (IOException e) {
            System.err.println("Can't write new transaction ID to file: " + e.getMessage());
        }
        return transactionIdCounter;
    }

    private Map<ColumnName, String> mapTransactionToData(Transaction transaction) {
        Map<ColumnName, String> data = new TreeMap<>();
        data.put(ColumnName.TRANSACTION_ID, String.valueOf(transaction.getTransactionId()));
        data.put(ColumnName.BOOK_ID, transaction.getBookId());
        data.put(ColumnName.PATRON_ACCOUNT_ID, transaction.getPatronId());
        data.put(ColumnName.ISSUE_DATE, String.valueOf(transaction.getIssueDate()));
        data.put(ColumnName.RETURN_DATE, String.valueOf(transaction.getReturnDate()));
        data.put(ColumnName.RETURNED, String.valueOf(transaction.isReturned()));
        return data;
    }

    private Transaction mapDataToTransaction(String data) throws ParseException {
        String[] values = data.split("\t");

        int transactionId = Integer.parseInt(values[0]);
        String userId = (values[1]);
        String bookId = (values[2]);
        LocalDate issue = LocalDate.parse(values[3]);
        LocalDate returnDate = LocalDate.parse((values[4]));
        boolean isReturned = Boolean.parseBoolean(values[5]);

        Transaction transaction  =  new Transaction(); // new transaction

        transaction.setTransactionId(transactionId);
        transaction.setBookId(bookId);
        transaction.setPatronId(userId);
        transaction.setIssueDate(issue);
        transaction.setReturnDate(returnDate);
        transaction.setReturned(isReturned);

        return transaction;
}}