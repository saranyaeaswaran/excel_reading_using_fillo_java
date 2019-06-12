package allTests;

import java.net.URL;
import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelLib {
		
		public Connection connection = null;
		private String testCaseName;
		private String workSheetName;
		

	public ExcelLib(String workSheetName, String testCaseName) throws FilloException {
		URL path = ExcelLib.class.getResource("sample.xlsx");
		Fillo fillo=new Fillo();
		connection=fillo.getConnection(path.getFile());
		this.testCaseName = testCaseName;
		this.workSheetName = workSheetName;	
		
	}
	
	/*Return Two Dimensional Array to DataProvider*/	
	public Object[][] getTestdata() throws FilloException{
		String strQuery="Select * from "+workSheetName+" where Testcase = '"+testCaseName+"' and ToRun='Yes'";
		Recordset recordset=connection.executeQuery(strQuery);
		
		int iterationCount = recordset.getCount();
		ArrayList<String> columnLength = recordset.getFieldNames();
		int columnsCount = columnLength.size();
		
		String data[][] = new String[iterationCount][columnsCount-2];
		
		recordset.next();
		for(int i=0;i<iterationCount;i++) {
			for(int j = 2; j < columnsCount; j++){
//				System.out.println("Value is : "+recordset.getField(j).value());
				data[i][j-2] = recordset.getField(j).value();
			}
			recordset.next();
		}
		connection.close();
		return data;
	}
	
}
