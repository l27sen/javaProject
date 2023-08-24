package leetcodeByCategory.jacob;

public class StockPrice1 {

    public int max(int[] price){
        int min = price[0];
        int res =0;
        for (int i = 1; i < price.length ; i++) {

            if(price[i]< min){
                min = price[i];

            }
            res = Math.max(res, price[i]-min);
        }

        return res;
    }
}
