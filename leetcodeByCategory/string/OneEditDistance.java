package leetcodeByCategory.string;

/**
 * Input:  s1 = "geeks", s2 = "geek" Output: yes Number of edits is 1
 * <p>
 * Input:  s1 = "geeks", s2 = "geeks" Output: no Number of edits is 0
 */
public class OneEditDistance {

  public static void main(String[] args) {
    String s1 = "gfg";
    String s2 = "gfee";
    if (isEditDistanceOne2(s1, s2)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

  //youtube
  //https://www.youtube.com/watch?v=nDstaiEUljY&list=PLH_ZFS7tFxk68-1kLMFL9oUqnFnVMY56U&index=68

  static boolean isEditDistanceOne2(String s,
      String t) {
    if (s == null || t == null) {
      return false;
    }
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (s.length() == t.length()) {
          // abef  with 'acef', if b!=c, the compare rest.
          //replace case
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else if (s.length() > t.length()) {
          // abcef  with 'acef', if b!=c, the compare rest.
          //add or remove case
          return s.substring(i + 1).equals(t.substring(i));
        } else if (s.length() < t.length()) {
          // acef  with 'abcef', if b!=c, the compare rest.
          return s.substring(i).equals(t.substring(i + 1));
        }
      }

    }
    return Math.abs(s.length() - t.length()) == 1;

  }

  // Returns true if edit distance
// between s1 and s2 is one, else false
  static boolean isEditDistanceOne(String s,
      String t) {
    if (s == null || t == null) {
      return false;
    }

    int m = s.length();
    int n = t.length();

    if (Math.abs(m - n) > 1) {
      return false;
    }

    int i = 0;
    int j = 0;
    int count = 0;

    while (i < m && j < n) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        count++;
        if (count > 1) {
          return false;
        }

        //if the length is different
        if (m > n) {
          i++;
        } else if (m < n) {
          j++;
        } else {
          i++;
          j++;
        }
      }
    }

    if (i < m || j < n) {
      count++;
    }

    if (count == 1) {
      return true;
    }

    return false;
  }
}
