package allTests;

import java.net.URL;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class InsertDataToExcel {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		URL path = InsertDataToExcel.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		
		String strQuery="Insert INTO Sheet1(Item, Value) VALUES('Draw','30')";
		connection.executeUpdate(strQuery);
		connection.close();
	}
}
