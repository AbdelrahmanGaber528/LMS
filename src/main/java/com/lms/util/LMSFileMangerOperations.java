package com.lms.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LMSFileMangerOperations {
    public void insertRow( Map<ColumnName , String> row) throws IOException;
    public void updateRow( Map<ColumnName, String> updateRow);
    public void deleteRow(Map<ColumnName,String> row) throws IOException;
    public List<String> getAllRows() throws IOException;
    public void clearFile() throws IOException;
}
//private Map<Integer, Book> booksMap = new HashMap<>();