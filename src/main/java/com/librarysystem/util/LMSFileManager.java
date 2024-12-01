package com.librarysystem.util;

import java.util.List;

public class LMSFileManager implements LMSFileMangerOperations {

    @Override
    public boolean readFromFile(String path) {
        return false;
    }
    @Override
    public boolean writeToFile(String path, List<String> lines) {
        return false;
    }

    @Override
    public boolean appendToFile(String filePath, List<String> lines) {
        return false;
    }

    @Override
    public List<String> searchInFile(String filePath, String keyword) {
        return List.of();
    }

    @Override
    public void updateLineInFile(String filePath, String oldLine, String newLine) {

    }

    @Override
    public boolean removeLineFromFile(String filePath, String lineToRemove) {
        return false;
    }

    @Override
    public boolean clearFile(String filePath) {
        return false;
    }

}
