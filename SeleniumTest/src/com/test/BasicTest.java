package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
@Test
public void checkAddi(){
	X xx=new X();
	int yy=xx.add(33, 3);
	Assert.assertEquals(yy, 36);
	
}
@Test
public void checkPossitive(){
	X xx=new X();
	int yy=xx.add(-20, 5);
	Assert.assertEquals(yy, -15);
	
}
@Test
public void checknegative(){
	X xx=new X();
	int yy=xx.add(0, 5);
	Assert.assertEquals(yy, 5);
	
}
@Test
public void checkSub(){
	X xx=new X();
	int yy=xx.add(-75, 5);
	Assert.assertEquals(yy, -70);
	
}

}