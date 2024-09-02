import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class dataDriven {
	
	public ArrayList<String> getData(String sheetName, String testcasename) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\Dood\\Rest API\\excelDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		ArrayList<String> a = new ArrayList<String>();
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				
				int k = 0;
				int column = 0;
				while(cell.hasNext()) {
					Cell cellValue = cell.next();
					if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext()) {
					Row row = rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> cell1 = row.cellIterator();
						while(cell1.hasNext()) {
							Cell cellv = cell1.next();
							if(cellv.getCellType()==org.apache.poi.ss.usermodel.CellType.STRING) {
								a.add(cellv.getStringCellValue());	
							}
							else {
								a.add(NumberToTextConverter.toText(cellv.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
	return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
}
