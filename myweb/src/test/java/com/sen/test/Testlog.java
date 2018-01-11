package com.sen.test;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: senli
 * Date: 14-2-12
 * Time: 下午6:27
 * To change this template use File | Settings | File Templates.
 */
public class Testlog {
   @AfterClass
   public static void after(){
           System.out.println("after");
   }

    @Test
    public void testAdd(){
        System.out.println("testAdd");

        LogTest test =new LogTest();
       int result = test.add(2,3);
        Assert.assertEquals(result,5);
    }

    //@Test
    public void testAdd2(){

        System.out.println("testAdd2");

        LogTest test =new LogTest();
        int result = test.add(2,3);
        Assert.assertEquals(result,5);
    }
}
