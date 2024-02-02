package guru.qa;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import com.opencsv.CSVReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWorkEleven {


//    @Test
//    void ArchiveReader() {


    public static class ZipFileReader {

        public static void main(String[] args) throws IOException {
            String zipFilePath = "Desktop.zip";
            readAndCheckFilesInZip(zipFilePath);
        }

        public static void readAndCheckFilesInZip(String zipFilePath) throws IOException {
            try (ZipFile zipFile = new ZipFile(zipFilePath)) {

                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();

                    if (!entry.isDirectory()) {

                        byte[] content = IOUtils.toByteArray(zipFile.getInputStream(entry));

                        String contentAsString = new String(content, StandardCharsets.UTF_8);
                        Assertions.assertTrue(
                                contentAsString.contains("52c8e8114c11cfa9e6e668ee652dbf2b, month, file_example_XLS_10"));


                        System.out.println("File: " + entry.getName() + ", Valid: " + isValid);
                    }
                }
            }
        }
    }
}




