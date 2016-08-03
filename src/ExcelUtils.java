import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	public static HSSFSheet ExcelWheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;

	/**
	 * set the file path and to open the Excel file
	 * @param Path
	 * @param SheetName
	 * @param string 
	 * @throws Exception
	 */
	public static void setExcelFile(String Path,String SheetName) throws Exception{
		try{
			//opent the excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			
			//Access the required test data sheet
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWheet = ExcelWBook.getSheet(SheetName);
			
		}catch (Exception e){
			throw (e);
		}
	}

	/**
	 * Read the test data from the Excel cell
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @throws exception
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			System.out.println(CellData);
			return CellData;		
		}catch (Exception e){
			throw (e);
		}
	}
}
