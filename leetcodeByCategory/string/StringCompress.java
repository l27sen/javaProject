package leetcodeByCategory.string;

/**
 * abbbcc-> a1b3c3
 */
public class StringCompress {

  public static void main(String[] a) {
    System.out.println(compress("abbccd"));
  }

  public static String compress(String input) {

    StringBuilder compressed = new StringBuilder();

    int counter = 0;
    for (int i = 0; i < input.length(); i++) {
      counter++;
      //next on is outof array, or compare next one with current one.
      if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
        compressed.append(input.charAt(i));
        compressed.append(counter);
        counter = 0;
      }
    }
    return compressed.toString();
  }
}
