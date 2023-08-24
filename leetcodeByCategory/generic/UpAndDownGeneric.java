package leetcodeByCategory.generic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 泛型上下界
 * 上界 <? extend Fruit> ，表示所有继承Fruit的子类，但是具体是哪个子类，无法确定，所以调用add的时候，要add什么类型，谁也不知道。
 * 但是get的时候，不管是什么子类，不管追溯多少辈，肯定有个父类是Fruit，所以，我都可以用最大的父类Fruit接着，也就是把所有的子类向上转型为Fruit。
 *
 * 下界 <? super Apple>，表示Apple的所有父类，包括Fruit，一直可以追溯到老祖宗Object 。
 * 那么当我add的时候，我不能add Apple的父类，因为不能确定List里面存放的到底是哪个父类。但是我可以add Apple及其子类。
 * 因为不管我的子类是什么类型，它都可以向上转型为Apple及其所有的父类甚至转型为Object
 * 。但是当我get的时候，Apple的父类这么多，我用什么接着呢，除了Object，其他的都接不住。
 */
public class UpAndDownGeneric {

  /**
   * 1、上界可以读取成上界类型Date,但是不能存储，因为这个实际类型有可能是子类，而你指定Date不行,Date的下级也不行，依次同理。
   */
  public void upperBound(List<? extends Date> list, Date date) {
    Date now = list.get(0);  //这里当然也可以用Object接受。
    System.out.println("now==>" + now);
//     list.add(date); //这句话无法编译
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    list.add(null); //这句可以编译，null没有类型信息
  }

  /**
   * 比如下面这个方法，泛型是Timestamp类型，而add的时Date类型。 上界读不能存，因为泛型类型可能无限小，任何参数的类型都不能直接使用。
   */
  public void testUpperBound() {
    List<Timestamp> list = new ArrayList<Timestamp>();
    Date date = new Date();
    upperBound(list, date);
  }

  /**
   * 解决,声明List泛型为T,在方法定义T为Date子类，那么传递的类型永远符合T的类型了。就可以添加了。
   */
  public <T extends Date> void upperBound2(List<T> list, T date) {
    T now = list.get(0);
    System.out.println("now==>" + now);
    list.add(date); //这句话无法编译
    list.add(null); //这句可以编译，null没有类型信息
  }

  /**
   * 2、下界不能够读，可以写，因为泛型实际类型都大于Timestamp,所以放心的写，而读的话，不知道返回什么类型了。
   */
  public void lowerBound(List<? super Date> list) {
    Date now = new Date(System.currentTimeMillis());
    list.add(now);
    list.add(new Timestamp(System.currentTimeMillis())); //可以添加比Date小的类型。
//    Date time = list.get(0); //需要强转成Object,才能读。
  }

  /**
   * 比如下面这个：list符合泛型限制，但是添加的是一个Object，所以在lowerBound调用时，get要强转成Object.
   */
  public void testLowerBound() {
    List<Object> list = new ArrayList<>();
    list.add(new Object());
    lowerBound(list);
  }

}