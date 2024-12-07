package com.librarysystem.util;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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

        Map<ColumnName , String > transactionMap = new LinkedHashMap<>();

        // format date into string
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        transactionMap.put(ColumnName.PATRON_ACCOUNT_ID,"1");
        transactionMap.put(ColumnName.LIBRARIAN_ACCOUNT_ID,"2");
        transactionMap.put(ColumnName.DATE_TIME, formattedDateTime);
        transactionMap.put(ColumnName.BOOK_TITLE,"What");
        transactionMap.put(ColumnName.TOTAL_AMOUNT, "50");

        return transactionMap;
    }

    private String readTransactionRow(String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            // Skip the first line
            scanner.nextLine();

            // Read the second line directly
            return scanner.nextLine().trim();
        }
    }
}
