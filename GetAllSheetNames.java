package allTests;

import java.net.URL;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class GetAllSheetNames {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		URL path = GetAllSheetNames.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		System.out.println(connection.getMetaData().getTableNames());
		connection.close();
	}
}
