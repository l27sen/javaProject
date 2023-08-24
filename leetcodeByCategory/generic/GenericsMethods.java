package leetcodeByCategory.generic;

public class GenericsMethods {

  public static <T> boolean isEquals(GenericsType<T> t1, GenericsType<T> t2) {
    return t1.get().equals(t2.get());
  }

  public static void main(String args[]){
    GenericsType<String> g1 = new GenericsType<>();
    g1.set("aa");

    GenericsType<String> g2 = new GenericsType<>();
    g2.set("bb");

    boolean isEqual = GenericsMethods.<String>isEquals(g1, g2);
    //above statement can be written simply as
    isEqual = GenericsMethods.isEquals(g1, g2);
    //This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
    //Compiler will infer the type that is needed
  }
}
