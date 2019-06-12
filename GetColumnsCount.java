package allTests;

import java.net.URL;
import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class GetColumnsCount {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		URL path = GetColumnsCount.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		String strQuery="Select * from TC_Data";
		Recordset recordset=connection.executeQuery(strQuery).where("TestCase='TC1'");
		
		ArrayList<String> columnLength = recordset.getFieldNames();
		System.out.println("Column Count is : "+ (columnLength.size()));
		
		recordset.close();
		connection.close();
	}
}
