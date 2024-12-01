package com.librarysystem.util;

import com.librarysystem.models.Admin;
import com.librarysystem.models.User;

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
    public User searchInFile(String filePath, String keyword) {
        return null;
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
