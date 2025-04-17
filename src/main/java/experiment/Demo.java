package experiment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {
	public static void main(String[] args) {
		FileInputStream fip;
		Workbook workbook = null;
		try {
			fip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\experiment\\SampleData.xlsx");
			workbook = new XSSFWorkbook(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet("employees");
		int rows = sheet.getLastRowNum() + 1;
		System.out.println(rows);
		int cells = sheet.getRow(0).getLastCellNum();
		System.out.println(cells);

		for (int r = 0; r < rows; r++) {
			Row row = sheet.getRow(r);
			for (int c = 0; c < cells; c++) {
				Cell cell = row.getCell(c);
				CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
					System.out.print(cell.getStringCellValue() + "---");
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue() + "---");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + "---");
					break;
				default:

					System.out.print("no matching");

				}

			}
			System.out.println();

		}
	}

}
