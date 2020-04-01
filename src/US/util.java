package US;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class util {

	
	public static ArrayList<Object[]> getExcelData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//ArrayList<Object[]> myData = new ArrayList<>();
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		FileInputStream fis = new FileInputStream("E:\\sample.xlsx");
		WorkbookFactory wf = new WorkbookFactory();
		Workbook wb = wf.create(fis);
		
		Sheet s1 = wb.getSheet("Sheet1");
		
		for(int row=1;row<=3;row++)
		{
			String UN = s1.getRow(row).getCell(0).getStringCellValue();
			String password = s1.getRow(row).getCell(1).getStringCellValue();
			String station = s1.getRow(row).getCell(2).getStringCellValue();
			System.out.println(UN + password + station);
			Object ob[] = {UN,password,station};
			myData.add(ob);
		}
		
		return myData;
		
		
	}
	

}
