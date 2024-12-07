package com.librarysystem.util;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LMSFileMangerOperations {

    public void insertRow( Map<ColumnName , String> lines) throws IOException;
    public String ReadRow ();
    public List<String> ReadAllRows ();
    public void deleteRow(ColumnName id);

}
//private Map<Integer, Book> booksMap = new HashMap<>();