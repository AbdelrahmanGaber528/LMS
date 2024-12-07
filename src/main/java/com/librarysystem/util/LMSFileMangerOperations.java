package com.librarysystem.util;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LMSFileMangerOperations {

    public void insertRow( Map<ColumnName , String> lines) throws IOException;
    public String readRow (String id)throws IOException;
    public String[] readAllRows () throws IOException;
    public void deleteRow(String id) throws IOException;
    public List<String> getAllRows(String id ) throws IOException;
}
//private Map<Integer, Book> booksMap = new HashMap<>();