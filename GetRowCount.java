package allTests;

import java.net.URL;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class GetRowCount {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		URL path = GetRowCount.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		String strQuery="Select * from SalesOrders";
		Recordset recordset=connection.executeQuery(strQuery);
		System.out.println(recordset.getCount());
		while(recordset.next()){
//			System.out.println(recordset.getField("OrderDate"));
			}
		recordset.close();
		connection.close();
	}
}
