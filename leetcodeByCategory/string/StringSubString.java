package leetcodeByCategory.string;

public class StringSubString {

  public static void main(String a[]) {

    System.out.println(subStringIndex("abc", "bc"));
  }

  public static int subStringIndex(String whole, String subInput) {

    for (int i = 0; i <= whole.length() - subInput.length(); i++) {

      if (whole.substring(i, i + subInput.length()).equals(subInput)) {
        return i;
      }

    }
    return -1;
  }
}
