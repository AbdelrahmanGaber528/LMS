package com.lms.util;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LMSFileManagerTest {

    @Test
    public void testInsertRow() throws IOException{

        // Create the FileManager
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");

        // Create a test map
        Map<ColumnName, String> transactionMap = createTransactionMap();
        fileManager.insertRow(transactionMap);


    }

    private Map<ColumnName,String> createTransactionMap(){

        Map<ColumnName, String> transactionMap = new TreeMap<>();
        // Format the date into string
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = now.format(formatter);

        // Populate the map
        transactionMap.put(ColumnName.TRANSACTION_ID, "12");
        transactionMap.put(ColumnName.BOOK_TITLE, "Welcome");
        transactionMap.put(ColumnName.PATRON_ACCOUNT_ID, "3");
        transactionMap.put(ColumnName.LIBRARIAN_ACCOUNT_ID, "9");
        transactionMap.put(ColumnName.ISSUE_DATE, formattedDateTime);

        return transactionMap;
    }

   @Test
    public void testGetAllRows() throws IOException {
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        ArrayList<String> rows = (ArrayList<String>) fileManager.getAllRows();
       for(String row :rows)
           System.out.println(row);
   }


   @Test
   public void testDeleteSpecificRow() throws IOException {
       LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
       fileManager.deleteRow(createTransactionMap());
   }

   @Test
    public void testClearFile() throws IOException {
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        fileManager.clearFile();
   }

   @Test
    public void testUpdate(){
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        fileManager.updateRow(createTransactionMap());
   }
}
