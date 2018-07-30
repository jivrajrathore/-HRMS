package com.meganexus.GenericLib;

public class ReadExcelData {

	public static void main(String[] args) {
		ExcelDataConfig excel = new ExcelDataConfig(
				"E:\\AutomationTestingWorkspace\\App Project\\src\\test\\resources\\Test Data\\Import Spreadsheet v0.10.xlsx");
		System.out.println(excel.getData("Profile", 5, 6));
	}

}
