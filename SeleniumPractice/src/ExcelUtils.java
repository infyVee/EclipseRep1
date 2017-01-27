import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelfile(String Path,String SheetName) throws Exception
	{
		FileInputStream ExcelFile=new FileInputStream(Path);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
	}
	public static int getRowsFromExcel() 
	{
		
		return ExcelWSheet.getPhysicalNumberOfRows();
	}
	public static int getColumnsFromExcel(int RowNum)
	{
		Row  = ExcelWSheet.getRow(RowNum);
		return Row.getLastCellNum();
	}
	
	public static String readExcelFile(int Rownum,int Colnum)
	{
		Cell=ExcelWSheet.getRow(Rownum).getCell(Colnum);
		//String CellData=Cell.getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String CellData=formatter.formatCellValue(Cell);
		//int num= Integer.parseInt(CellData);
		return CellData;
	}
	
/*	public static void writetoExcel(String result,int RowNum,int ColNum) throws Exception
	{
		try
		{
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {

				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);

				} 
			else {
						Cell.setCellValue(result);

				}
		// Accessing Test Data path and test data file.
		FileOutputStream file=new FileOutputStream(ConstantDataDrivenTest.Path_TestData+ConstantDataDrivenTest.File_TestData);
		ExcelWBook.write(file);
		}
		
		catch (Exception e)
		{
			throw(e);
		}
	}*/
	
}
