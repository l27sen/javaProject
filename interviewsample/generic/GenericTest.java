package interviewsample.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    class Fruit {}
    class Apple extends Fruit {}
    public void test(){
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        //<? extends T> which impose an upper bound by ensuring that type must be sub
        List<? extends Fruit> flist = new ArrayList<>();
        //error below compile error
//        flist.add(apple);
        //ok here
        Fruit f = flist.get(0);
//<? super T> where its imposing lower bound by ensuring Type must be super class of T
        List<? super Apple> appleList = new ArrayList<>();
        appleList.add(apple);

        //get hard.
//        Apple apple2 = appleList.get(0);
        //error, 不允许向该 List 放入一个 Fruit 对象， 因为该List的类型可能是List<Apple> ,
        // 这样将会违背泛型的本意
//        appleList.add(fruit);

    }
}
