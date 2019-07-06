package com.alteryx.beans.utils;

import com.alteryx.beans.FileInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;

public class FileReader implements IFileReader {

    private static final String SEPARATOR = ",";

    @Override
    public List<FileInfo> getFilesInfo(String directory, String[] extensions) {
        List<File> files = readFiles(directory, extensions);

        return files.stream().map(file -> {
            try {
                List<String> lines = readLines(file);
                final List<String> emptyCells = new LinkedList<>();
                lines.forEach(line -> Arrays.asList(line.split(SEPARATOR))
                        .forEach(cell -> {
                            if (cell == null || cell.trim().isEmpty()) emptyCells.add(cell);
                        }));
                List<String> columnsNames = Arrays.asList(readLines(file).get(0).split(SEPARATOR));
                return new FileInfo(file.getName(), columnsNames, lines.size(), emptyCells.size());
            } catch (IOException e) {
                throw new IllegalArgumentException("Error in processing file " + file.getName(), e);
            }
        }).collect(Collectors.toList());
    }

    private List<File> readFiles(String directory, String[] extensions) {
        File dir = new File(directory);
        return (List<File>) FileUtils.listFiles(dir, extensions, true);
    }
}
