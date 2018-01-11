package com.sen.test;
 import org.apache.log4j.*;
/**
 * Created with IntelliJ IDEA.
 * User: senli
 * Date: 14-2-12
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class LogTest {

    public static void testlog(){
        PropertyConfigurator.configure("C:\\Sen\\code_example\\myweb\\conf\\log4j.properties");

        Logger logger =Logger.getLogger("LogTest");
        logger.info("Hello this is an info message");
        logger.debug("debug this is an info message");
    }

    public int add(int a, int b){

        return a+b;
    }
}
