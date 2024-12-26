package com.lms.util;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LMSFileManager implements LMSFileMangerOperations{

    private final String filePath;
    private static final Logger LOGGER = Logger.getLogger(LMSFileManager.class.getName());

    public LMSFileManager(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void insertRow( Map<ColumnName, String> row) throws IOException {

            StringBuilder newRow = new StringBuilder();
            if(!new File(filePath).exists()){
                throw new IOException("File NOT FOUND");
            }
            else {
                try(FileWriter writer = new FileWriter(filePath,true)){
                    writer.write("\n");
                    for(String value : row.values())
                        newRow.append(value).append("\t");
                    // Append rows to file
                    writer.write(newRow.toString().trim());

                }catch (IOException e ){
                    LOGGER.log(Level.SEVERE,"Can't insert in file " + filePath , e);
                }
            }
    }

    @Override
    public void updateRow(Map<ColumnName , String> updateRow) {

        List<String> allRows = readAllRows();

        String firstColumn = updateRow.values().iterator().next();

        StringBuilder updatedContent = new StringBuilder();

        // Add the header to the updated content
        updatedContent.append(allRows.getFirst()).append("\n");
        for (int i = 1; i < allRows.size(); i++) {
            //  skipping the header (index 0)
            String[] columns = allRows.get(i).split("\t");
            if (columns[0].equalsIgnoreCase(firstColumn)) {
                // Create a tab-separated row from updateRow values
                String updatedRow = String.join("\t", updateRow.values());
                updatedContent.append(updatedRow).append("\n");
            }else{
                updatedContent.append(allRows.get(i)).append("\n");
            }
        }
        // Write updated content back to the file
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(updatedContent.toString().trim());
        }catch (IOException e){
            LOGGER.log(Level.SEVERE, "Can't delete the row : " + filePath, e);
        }
    }

    @Override
    public List<String> getAllRows() throws IOException {return readAllRows();}

    @Override
    public void clearFile() throws IOException {
        String header = getTheHeader();
        if (header == null) {
            throw new IOException("Header is null. Cannot write to file.");
        }
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.append(header);
        }
    }

    @Override
    public void deleteRow(Map<ColumnName,String> row){

        List<String> allRows = readAllRows();

        if (allRows.getFirst() == null) {
            System.err.println("THe file is empty.");
        }

        String firstColumn =  row.values().iterator().next();
        StringBuilder updatedContent = new StringBuilder();

        // Add the header to the updated content
        updatedContent.append(allRows.getFirst()).append("\n");

        for (int i = 1; i < allRows.size(); i++) {
            //  skipping the header (index 0)
            String[] columns = allRows.get(i).split("\t");
            if (!columns[0].equalsIgnoreCase(firstColumn)) {
                updatedContent.append(allRows.get(i)).append("\n");
            }
        }
        // Write updated content back to the file
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(updatedContent.toString().trim());
        }catch (IOException e){
            LOGGER.log(Level.SEVERE, "Can't delete the row : " + filePath, e);
        }
    }

    private String getTheHeader(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("The error in getHeader method : " + e.getMessage());
        }
        return "NOT FOUND HEADER";
    }

    private List<String> readAllRows() {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't load data from file: " + filePath, e);
        }
        return Arrays.asList(content.toString().split("\n"));
    }

}
