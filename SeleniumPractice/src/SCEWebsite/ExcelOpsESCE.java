package SCEWebsite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelOpsESCE {
	public  String filelocation;
	public  FileInputStream ipstr = null;
	public  FileOutputStream opstr =null;
	private HSSFWorkbook wb = null;
	private HSSFSheet ws = null;
	private HSSFRow Row=null;
	private static HSSFCell Cell;

	 public ExcelOpsESCE(String filelocation) {		
		 System.out.println("Inside Constructor ExcelOpsESCE");
		this.filelocation=filelocation;
		try {
			ipstr = new FileInputStream(filelocation);
			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		System.out.println("Leaving Constructor ExcelOpsESCE");
	}
	 
	 //to retrieve number of Rows in the excel file
		public int retrieveNoOfRows(String wsName){		
			int sheetIndex=wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return 0;
			else{
				ws = wb.getSheetAt(sheetIndex);
				int rowCount=ws.getLastRowNum()+1;		
				return rowCount;		
			}
		}
		
		
		//To retrieve No Of Columns from .cls file's sheets.
		public int retrieveNoOfCols(String wsName){
			int sheetIndex=wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return 0;
			else{
				ws = wb.getSheetAt(sheetIndex);
				int colCount=ws.getRow(0).getLastCellNum();			
				return colCount;
			}
		}
		
	
public static String cellToString(HSSFCell cell){
			int type;
			Object result;
			type = cell.getCellType();			
			switch (type){
				case 0 :
					result = cell.getNumericCellValue();
					break;
					
				case 1 : 
					result = cell.getStringCellValue();
					break;
					
				default :
					throw new RuntimeException("Unsupportd cell.");			
			}
			return result.toString();
		}

//To retrieve test data from test case data sheets.
public Object[][] retrieveTestData(String wsName){
	int sheetIndex=wb.getSheetIndex(wsName);
	if(sheetIndex==-1)
		return null;
	else{
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
	
			Object data[][] = new Object[rowNum-1][colNum];
	
			for (int i=0; i<rowNum-1; i++){
				HSSFRow row = ws.getRow(i+1);
				for(int j=0; j< colNum; j++){					
					if(row==null){
						data[i][j] = "";
					}
					else{
						HSSFCell cell = row.getCell(j);	
				
						if(cell==null){
							data[i][j] = "";							
						}
						else{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = cellToString(cell);
							data[i][j] = value;						
						}
					}
				}				
			}			
			return data;		
	}

}

//Method to write into Test Execution Sheet .
public void WriteintoTestExecutionSheet(String SheetName,String TestCaseName,String Status,String TimeStamp,String SSName) throws IOException
{
	System.out.println("inside WriteintoTestExecutionSheet() ");
	int colNum=retrieveNoOfCols(SheetName);
	int r=1;
	Row  = ws.getRow(1);
	Cell = Row.getCell(0, Row.RETURN_BLANK_AS_NULL);
	while(Cell!=null)
	{
		r++;
		Row  = ws.getRow(r);
		Cell = Row.getCell(0, Row.RETURN_BLANK_AS_NULL);
		
		
	}
		
System.out.println("The row in which the data is going to be inserted "+ r);
	for(int i =0;i<colNum;i++)
	{
		Cell = Row.getCell(i, Row.RETURN_BLANK_AS_NULL);
		if (Cell == null) {

			Cell = Row.createCell(i);
			Cell.setCellValue(i);

			} 
		else {
			Cell.setCellValue(i);

	}
		
	}
	opstr = new FileOutputStream(filelocation);
	wb.write(opstr);
	opstr.close();
	
	System.out.println("Leaving WriteintoTestExecutionSheet() ");
}
}
