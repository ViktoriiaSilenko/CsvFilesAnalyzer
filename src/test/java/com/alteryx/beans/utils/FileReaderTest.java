package com.alteryx.beans.utils;

import com.alteryx.beans.FileInfo;
import org.junit.Test;

import java.util.List;

import static com.alteryx.servlets.FilesServlet.FILES_DIRECTORY;
import static com.alteryx.servlets.FilesServlet.FILES_EXTENSIONS;
import static org.junit.Assert.assertEquals;


public class FileReaderTest {

    private static final int COUNT_OF_FILES_IN_DIRECTORY = 3;

    @Test
    public void testGetFilesInfo() {
        // arrange
        FileReader fileReader = new FileReader();

        // act
        List<FileInfo> filesInfo = fileReader.getFilesInfo(FILES_DIRECTORY, FILES_EXTENSIONS);

        // assert
        assertEquals("Count of files should be " + COUNT_OF_FILES_IN_DIRECTORY, COUNT_OF_FILES_IN_DIRECTORY, filesInfo.size());
        FileInfo firstFileInfo = filesInfo.get(0);
        assertEquals("Sacramentorealestatetransactions.csv", firstFileInfo.getFileName());
        assertEquals(12, firstFileInfo.getColumnsNames().size());
        assertEquals(986, firstFileInfo.getRowsNumber());
        assertEquals(0, firstFileInfo.getEmptyCellsNumber());
    }

}