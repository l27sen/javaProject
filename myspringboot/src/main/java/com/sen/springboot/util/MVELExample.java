package com.sen.springboot.util;

import org.mvel2.MVEL;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;

import java.util.*;

public class MVELExample {
    public static void main(String[] args) {

        testList();
        Foo foo = new Foo();
        foo.setName("test");
        foo.setAmount(-2);

        ValidationFunction validationFunction = new ValidationFunction();
        ValidationResult validationResult =validationFunction.apply(Arrays.asList(foo));

        System.out.println(validationResult.message);
    }

    public static void testSingle(){
        Foo foo = new Foo();
        foo.setName("test");
        Map context = new HashMap();
        String expression = "foo.name == 'test'";
        VariableResolverFactory functionFactory = new MapVariableResolverFactory(context);
        context.put("foo", foo);
        Boolean result = (Boolean) MVEL.eval(expression, functionFactory);
        System.out.println(result);
    }


    public static void testList(){
        Foo foo = new Foo();
        foo.setName("test");
        Foo foo2 = new Foo();
        foo2.setName("test2");
        List<Foo> fooList = new ArrayList();
        fooList.add(foo);
        fooList.add(foo2);

        Map context = new HashMap();
        VariableResolverFactory functionFactory = new MapVariableResolverFactory(context);
        context.put("fooList", fooList);
        String expression = "($ in fooList if $.name == 'test')";
        List result = (List) MVEL.eval(expression, functionFactory);
        System.out.println(result);
    }
}
