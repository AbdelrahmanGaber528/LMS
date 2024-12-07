package com.librarysystem.util;

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
                        newRow.append(value).append("\t\t");
                    // Append newLine to file
                    writer.write(newRow.toString().trim());

                }catch (IOException e ){
                    LOGGER.log(Level.SEVERE,"Can't insert in file " + filePath , e);
                }
            }
    }

    @Override
    public String readRow(String id) throws IOException{
        String[] allRows = readAllRows();
        for (String row : allRows) {
            if (row.contains(id))
                return row;
        }
        return "NOT FOUND";
    }

    @Override
    public String[] readAllRows() throws IOException {
            return loadFile().split("\n");
    }

    private String[] readAllRowsANDNames(){
        return loadAllData().split("\n");
    }

    @Override
    public List<String> getAllRows(String id) throws IOException {
        List<String> targetRows = new ArrayList<>();
        String[] allRows = readAllRows();
        for (String row : allRows)
            if(row.contains(id))
                targetRows.add(row);
        return targetRows;
    }

    @Override
    public void deleteRow(String id ) throws IOException {
        String[] rows = readAllRowsANDNames();
        StringBuilder oldRow = new StringBuilder();
            try (FileWriter writer = new FileWriter(filePath,false)) {
                oldRow.append(rows[0]).append("\n");
                for(int i = 1;i<rows.length;i++){
                    if(!rows[i].contains(id)){
                        oldRow.append(rows[i]).append("\n");
                    }
                }
                writer.write(oldRow.toString().trim());
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Can't insert in file " + filePath, e);
            }
    }

    private String loadFile() throws IOException{
        StringBuilder data = new StringBuilder();
        try(BufferedReader rd = new BufferedReader(new FileReader(filePath))){
            rd.readLine();
            String line;
            while((line = rd.readLine())!=null){
                data.append(line).append("\n");
            }
        }catch (IOException e){
            LOGGER.log(Level.SEVERE,"Can't Load Data from file " + filePath , e);
        }
        return data.toString().trim();
    }

    private String loadAllData(){
        StringBuilder data = new StringBuilder();
        try(BufferedReader rd = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = rd.readLine())!=null){
                data.append(line).append("\n");
            }
        }catch (IOException e){
            LOGGER.log(Level.SEVERE,"Can't Load Data from file " + filePath , e);
        }
        return data.toString().trim();
    }
}
