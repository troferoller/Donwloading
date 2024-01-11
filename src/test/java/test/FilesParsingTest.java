package test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.InputStreamReader;

import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.pdftest.PDF.containsText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class FilesParsingTest {

    private ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingPDFTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("CSV.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("Quest Character Profile and Worksheets.pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf, containsText("character profile"));
                    return;
                }
            }
            fail("Отсутствует " + "Quest Character Profile and Worksheets.pdf");
        }
    }

    @Test
    void zipFileParsingXLSXTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("CSV.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("prices.xlsx")) {
                    XLS xls = new XLS(zis);
                    String actualValue = xls.excel.getSheetAt(0).getRow(3).getCell(0).getStringCellValue();

                    Assertions.assertTrue(actualValue.contains("ПРЕЙСКУРАНТ"));
                }
            }
        }

    }
    @Test
    void zipFileParsingCSVTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("CSV.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("CSV.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));

                    List<String[]> data = csvReader.readAll();
                    Assertions.assertEquals(5, data.size());
                    Assertions.assertArrayEquals(
                            new String[]{"nothing", " here"},
                            data.get(0)
                    );
                    Assertions.assertArrayEquals(
                            new String[]{"nothing", " here2"},
                            data.get(1)
                    );
                }
            }
        }
    }
}
