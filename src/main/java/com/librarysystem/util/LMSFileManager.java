package com.librarysystem.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LMSFileManager implements LMSFileMangerOperations{

    private final String filePath;
    private static final Logger LOGGER = Logger.getLogger(LMSFileManager.class.getName());
    public LMSFileManager(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void insertRow(String filePath, Map<ColumnName, String> row) throws IOException {
            StringBuilder newRow = new StringBuilder();

            if(!new File(filePath).exists()){
                throw new IOException("File NOT FOUND");
            }
            else {
                try(FileWriter writer = new FileWriter(filePath,true)){
                    for(String value : row.values())
                        newRow.append(value).append("\t");
                    // Append newLine to file
                    writer.write(newRow.toString().trim());
                    writer.flush();
                }catch (IOException e ){
                    LOGGER.log(Level.SEVERE,"Can't insert in file "+filePath , e);
                }
            }
    }

    @Override
    public String ReadRow(String filePath) {

        return "";
    }

    @Override
    public List<String> ReadAllRows(String filePath) {
        return List.of();
    }

    @Override
    public void deleteRow(String filePath, ColumnName id) {

    }

}
