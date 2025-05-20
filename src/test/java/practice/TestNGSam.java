package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSam {
	
	@Test(dataProvider = "getData")
	public void createEmpData(String name, int id)
	{
		System.out.println("Name is -"+name);
		System.out.println("id is -"+id);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2] ;//3*2 three data sets and each consists of 2 info
		
				// 1ST data set
				data[0][0] = "Bhagya";
		        data[0][1] = 31;
		        
		     // 2 nd data set
				data[1][0] = "Anup";
		        data[1][1] = 9;
		        
		     // 3 rd data set
				data[2][0] = "Satvik";
		        data[2][1] = 7;
		        return data;
 	}
}
