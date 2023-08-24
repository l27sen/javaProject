package leetcodeByCategory.jacob;

public class StockPrice2 {


    public int max(int[] price){
        int res =0;
        for (int i = 1; i < price.length ; i++) {

            if(price[i]>price[i-1]){
              res+=price[i]-price[i-1];

            }

        }

        return res;
    }
}
