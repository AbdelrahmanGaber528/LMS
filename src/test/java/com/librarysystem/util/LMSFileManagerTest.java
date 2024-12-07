package com.librarysystem.util;
import org.junit.Test;

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

        Map<ColumnName , String > transactionMap = new TreeMap<>();

        // format date into string
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        transactionMap.put(ColumnName.TRANSACTION_ID,"30");
        transactionMap.put(ColumnName.BOOK_TITLE,"what");
        transactionMap.put(ColumnName.PATRON_ACCOUNT_ID,"10");
        transactionMap.put(ColumnName.LIBRARIAN_ACCOUNT_ID,"12");
        transactionMap.put(ColumnName.DATE_TIME, formattedDateTime);
        transactionMap.put(ColumnName.TOTAL_AMOUNT, "522");
        return transactionMap;
    }

   @Test
    public void testReadRow() throws IOException{
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        String firstName = fileManager.readRow("23");
       System.out.println(firstName);
   }
   @Test
    public void testGetAllRows() throws IOException {
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        ArrayList<String> rows = (ArrayList<String>) fileManager.getAllRows("11");
       for(String row :rows)
           System.out.println(row);
   }

   @Test
    public void testDeleteRow(){
        LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Transaction.txt");
        try{
            fileManager.deleteRow("30");
        }catch(IOException e ){
            System.err.println("Problem in : "+ e.getMessage());
        }
   }
}
