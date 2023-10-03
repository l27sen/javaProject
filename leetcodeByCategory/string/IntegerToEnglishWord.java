package leetcodeByCategory.string;

public class IntegerToEnglishWord {

    private final String[] belowTen
            = new String[]{"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"};

    private final String[] belowTwenty
            = new String[]{"Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    private final String[] belowHundred
            = new String[]{"", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result = null;
        // 1 - 9
        if (num < 10) {
            result = belowTen[num];
            // 10 - 19
        } else if (num < 20) {
            result = belowTwenty[num - 10];
            // 20 - 99
        } else if (num < 100) {
            // 几十几 + 几
            result = belowHundred[num / 10] + " " + helper(num % 10);
            // 100 - 999
        } else if (num < 1000) {
            // 几百 + 几十几
            result = helper(num / 100) + " Hundred " + helper(num % 100);
            // 1000 - 999,999
        } else if (num < 1000000) {
            // 几千 + 百
            result = helper(num / 1000) + " Thousand " + helper(num % 1000);
            // 1,000,000 -  999,999,999
        } else if (num < 1000000000) {
            result = helper(num / 1000000) + " Million " + helper(num % 1000000);
            // 1,000,000,000+
        } else {
            result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }

        return result.trim();
    }
}
