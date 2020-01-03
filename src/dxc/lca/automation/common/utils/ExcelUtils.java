package dxc.lca.automation.common.utils;

//package excelExportAndFileIO;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	private XSSFWorkbook excelWBook;
	private XSSFSheet excelWSheet;
	private XSSFCell excelCell;
	//private XSSFR excelRow;

	//public ExcelFactory() {	}

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method
	// public static void initialExcelFile(String Path,String SheetName) throws
	// Exception
	public ExcelUtils(String excelFileName, String sheetName) throws Exception 
	{

		try {
			// Open the Excel file
			File path = new File(excelFileName);
			FileInputStream excelFile = new FileInputStream(path);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile); // NOTE: use "XSSFWorkbook" for .xlsx file. If it's .xls file, use "HSSFWorkbook" object														
			excelWSheet = excelWBook.getSheet(sheetName);			
		} catch (Exception e) {
			throw (e);
		}
	}

	public String getCellData(int rowNum, int colNum) throws Exception 
	{
		try {
			excelCell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = excelCell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";

		}
	}
	
//	public String getExpectedCurrentRTTStatus(int rowNum, Boolean isCurrentRTTStatusEmpty) throws Exception 
//	{
//		String currentRTT;
//		if (isCurrentRTTStatusEmpty == true) 
//		{
//			currentRTT = this.getCellData(rowNum, 2); //get Intend RTT status value 
//		}else
//		{
//			currentRTT = this.getCellData(rowNum, 1); //get Current RTT status value
//		}
//		return currentRTT;
//	}
//	
//	
//	
//	
//	private String[] getInformationAtRow(int row) throws Exception
//	{
//		String[] rowInfo = new String[3];
//		rowInfo[0]= this.getCellData(row, 3); //get PAS-ID
//		rowInfo[1]= this.getCellData(row, 4); //get Mapping sheet name
//		rowInfo[2]= this.getCellData(row, 5); //get screenshot prefix name
//		return rowInfo;
//	}
//	
//	public int getNumberRowData()
//	{
//		int countRow = excelWSheet.getLastRowNum() + 1;
//		return countRow;
//	}
	
	/*
	public static void main(String[] args) throws Exception 
	{
		ExcelFactory RTTList_sheet = new ExcelFactory(Constants.RTTMapping_FilePath, Constants.RTTMapping_SummarySheet);
		System.out.println("Number of row data: " + RTTList_sheet.getNumberRowData());
		
		String[] RTTinfor = RTTList_sheet.get_PASID_MappingSheet(Constants.CurrentRTT_12,Constants.IntendedRTT_30);
		System.out.println("PAS-ID: " + RTTinfor[0]);
		System.out.println("Mapping sheet: " + RTTinfor[1]);
		
		ExcelFactory excelRTTMapping = new ExcelFactory(Constants.RTTMapping_FilePath, RTTinfor[1]);
		String count = excelRTTMapping.getCellData(1,0);
		System.out.println("- Expected New RTT count: " + count);		
		//expectedNewRTTValueCount = Integer.parseInt(count);	
		
	}*/
}