package com.alteryx.beans.utils;

import com.alteryx.beans.FileInfo;

import java.util.List;


public interface IFileReader {
    List<FileInfo> getFilesInfo(String directory, String[] extensions);
}
