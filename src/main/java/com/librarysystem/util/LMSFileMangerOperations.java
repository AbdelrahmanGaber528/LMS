package com.librarysystem.util;

import com.librarysystem.models.User;

import java.util.List;
import java.util.Map;

public interface LMSFileMangerOperations {
    public boolean readFromFile(String filePath);
    public boolean writeToFile(String filePath, List<String> lines);
    public boolean appendToFile(String filePath, List<String> lines);
    public User searchInFile(String filePath, String keyword);
    public void updateLineInFile(String filePath, String oldLine, String newLine);
    public boolean removeLineFromFile(String filePath, String lineToRemove);
    public boolean clearFile(String filePath);
}
//private Map<Integer, Book> booksMap = new HashMap<>();