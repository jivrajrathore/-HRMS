package com.meganexus.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	InputStream XlsxFileToRead = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet1;

	public ExcelDataConfig(String excelpath) {
		try {

			File src = new File(excelpath);
			XlsxFileToRead = new FileInputStream(src);
			workbook = new XSSFWorkbook(XlsxFileToRead);

			 for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
				            Row row = rit.next();
				            for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
				                Cell cell = cit.next();
				                // Print the each cell value
				                System.out.println("Output : " + getCellValueAsString(cell));
				            }
				        }

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(String sheetName, int row, int col) {
		sheet1 = workbook.getSheet(sheetName);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
       
}
	 /**
     * This method for the type of data in the cell, extracts the data and
     * returns it as a string.
     */
    public static String getCellValueAsString(Cell cell) {
        String strCellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strCellValue = cell.toString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy");
                    strCellValue = dateFormat.format(cell.getDateCellValue());
                } else {
                    Double value = cell.getNumericCellValue();
                    Long longValue = value.longValue();
                    strCellValue = new String(longValue.toString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCellValue = new String(new Boolean(
                        cell.getBooleanCellValue()).toString());
                break;
            case Cell.CELL_TYPE_BLANK:
                strCellValue = "";
                break;
            }
        }
        return strCellValue;
    }
}
