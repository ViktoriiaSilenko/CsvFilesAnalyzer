package com.alteryx.beans;

import java.util.List;

public class FileInfo {

    private String fileName;

    private List<String> columnsNames;

    private long rowsNumber;

    private long emptyCellsNumber;

    public FileInfo(String fileName, List<String> columnsNames, long rowsNumber, long emptyCellsNumber) {
        this.fileName = fileName;
        this.columnsNames = columnsNames;
        this.rowsNumber = rowsNumber;
        this.emptyCellsNumber = emptyCellsNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getColumnsNames() {
        return columnsNames;
    }

    public long getRowsNumber() {
        return rowsNumber;
    }

    public long getEmptyCellsNumber() {
        return emptyCellsNumber;
    }
}
