package allTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;


public class ExcelLibTesting {
	
	
	@DataProvider (name="DataFromExcel")
	public Object[][] data() throws Exception {
		ExcelLib excelLib = new ExcelLib("TC_Data", "TC1");
		return excelLib.getTestdata();		
	}

	@Test(dataProvider = "DataFromExcel")
	public void testFillo(String OrderDate, String Region, String Rep, String Item, String Units, String UnitCost, String Total) throws FilloException {
		
		System.out.println(OrderDate);
		System.out.println(Region);
		System.out.println(Rep);
		System.out.println(Item);
		System.out.println(Units);
		System.out.println(UnitCost);
		System.out.println(Total);
	}
}
