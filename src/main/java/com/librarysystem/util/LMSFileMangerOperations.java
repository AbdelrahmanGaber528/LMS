package com.librarysystem.util;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LMSFileMangerOperations {

    public void insertRow(String filePath , Map<ColumnName , String> lines) throws IOException;
    public String ReadRow (String filePath );
    public List<String> ReadAllRows (String filePath);
    public void deleteRow(String filePath , ColumnName id);

}
//private Map<Integer, Book> booksMap = new HashMap<>();