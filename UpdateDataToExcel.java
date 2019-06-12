package allTests;

import java.net.URL;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class UpdateDataToExcel {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		URL path = UpdateDataToExcel.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		
		String strQuery="Update SalesOrders set Item='Staple' where Rep='Smith'";
		connection.executeUpdate(strQuery);
		connection.close();
	}
}
