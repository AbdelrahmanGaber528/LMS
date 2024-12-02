package com.librarysystem.util;

import com.librarysystem.models.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LMSFileManager implements LMSFileMangerOperations {

    @Override
    public boolean readFromFile(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
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
