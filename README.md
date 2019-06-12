# Fillo is an Excel API Library for Java
This library helps treat the excel tabs as database tables and the sheet content as table rows and columns. This helps to treat the excel as a database and using sql query-like syntax we can retrieve the data from excel sheets. We can use this in the DataProvider method of TestNG framework to fetch data from local excel to fed to the test scripts

* Dependancy to be added,
<!-- https://mvnrepository.com/artifact/com.codoid.products/fillo -->
<dependency>
    <groupId>com.codoid.products</groupId>
    <artifactId>fillo</artifactId>
    <version>1.21</version>
</dependency>

## To use as DataProvider in TestNG

* Refer the 'ExcelLib.java' in this repo to get the data as 2-D array
* The excel has a column named "ToRun" with values Yes/No to indicate whether the data row to be fed to the test case or not
* The sheet name and the test case name to be fed from the calling @DataProvide script to this file
* Sample test script to use this DataProvide method,

```java
public class ExcelLibTesting {	
	@DataProvider (name="DataFromExcel")
	public Object[][] data() throws Exception {
		ExcelLib excelLib = new ExcelLib("TC_Data", "TC1");
		return excelLib.getTestdata();		
	}
	@Test(dataProvider = "DataFromExcel")
	public void testFillo(String OrderDate, String Region, String Rep, String Item, String Units, String UnitCost, String Total) throws FilloException {
		System.out.println(OrderDate);
	}
}
```
## Code Snippets

* To select data from excel
```java
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
```

* To update data to excel
```java
Fillo fillo=new Fillo();
URL path = UpdateDataToExcel.class.getResource("sample.xlsx");
Connection connection=fillo.getConnection(path.getFile());
	
String strQuery="Update SalesOrders set Item='Staple' where Rep='Smith'";
connection.executeUpdate(strQuery);
connection.close();
```

* To insert rows to excel
```java
Fillo fillo=new Fillo();
URL path = InsertDataToExcel.class.getResource("sample.xlsx");
Connection connection=fillo.getConnection(path.getFile());
		
String strQuery="Insert INTO Sheet1(Item, Value) VALUES('Draw','30')";
connection.executeUpdate(strQuery);
connection.close();
```

* To get row count from an excel sheet
```java
String strQuery="Select * from SalesOrders";
Recordset recordset=connection.executeQuery(strQuery);
int rowCount = recordset.getCount();
```

* To get column count from an excel sheet
```java
String strQuery="Select * from TC_Data";
Recordset recordset=connection.executeQuery(strQuery).where("TestCase='TC1'");
		
ArrayList<String> columnLength = recordset.getFieldNames();
int columnCount = columnLength.size();
```

* To get sheet names from an excel workbook as an array
```java
Connection connection=fillo.getConnection(path.getFile());
System.out.println(connection.getMetaData().getTableNames());
```



