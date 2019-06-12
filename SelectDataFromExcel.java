package allTests;

import java.net.URL;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectDataFromExcel {

	public static void main(String[] args) throws FilloException {
		
		//Now you can set table start row and column
		System.setProperty("ROW", "5");//Table start row
		System.setProperty("COLUMN", "3");//Table start column
		
		Fillo fillo=new Fillo();
		URL path = SelectDataFromExcel.class.getResource("sample.xlsx");
		Connection connection=fillo.getConnection(path.getFile());
		
		String strQuery="Select * from SalesOrders where Units<100 and Rep='Smith'";
		Recordset recordset=connection.executeQuery(strQuery);
		//Or
		String strQuery1="Select * from SalesOrders";
		Recordset recordset1=connection.executeQuery(strQuery1).where("Units<100").where("Rep='Smith'");
		//Or
		String strQuery2="Select * from SalesOrders where Region like 'Sou%'";
		Recordset recordset2=connection.executeQuery(strQuery2);
		
		while(recordset2.next()){
			System.out.println(recordset2.getField("Item"));
			}
		recordset.close();
		connection.close();
	}
}
