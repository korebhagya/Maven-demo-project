package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test(retryAnalyzer = genericUtilities.retryAnalyserImplementtion.class)
	
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
		
		// if(1==0) //fail-validate-fail-script-fail
		// {
	//	System.out.println("Pass");
//	}
//	else
//	{
//		System.out.println("fail");
		
//	}
		
		Assert.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");

	}


@Test

public void smpleSoft()
{
	SoftAssert sp = new SoftAssert();
	
	System.out.println("Step 1");
	System.out.println("Step 2");
	System.out.println("Step 3");
	
	
	sp.assertEquals(0, 1);
	
	System.out.println("Step 4");
	System.out.println("Step 5");
	System.out.println("Step 6");

	sp.assertAll();
	
	
}
}
