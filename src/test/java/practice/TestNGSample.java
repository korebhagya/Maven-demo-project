package practice;

import org.testng.annotations.Test;

public class TestNGSample {
	@Test
	public void createSample()
	{
		// Assert.fail(); // forcefully fail
		System.out.println("create");
	}

	@Test(dependsOnMethods = "createSample")
	public void modifySample()
	{
		System.out.println("modify");
	}
	
	@Test(enabled = false) // this cannot be execute 
	public void deleteSample()
	{
		System.out.println("delete");
	}
}
