/*
 * <aside>

💡 **Question 5**
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.

Given the integer n, return *the number of **complete rows** of the staircase you will build*.

**Example 1:**

[]()

![v2.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4bd91cfa-d2b1-47b3-8197-a72e8dcfff4b/v2.jpg)

**Input:** n = 5

**Output:** 2

**Explanation:** Because the 3rd row is incomplete, we return 2.

</aside>
 * 
 */
package in.ineuron.gouthami;

public class StaircaseRows {
    public static int arrangeCoins(int n) {
        int rows = 0;
        int coins = n;
        int currentRow = 1;

        while (coins >= currentRow) {
            coins -= currentRow;
            currentRow++;
            rows++;
        }

        return rows;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = arrangeCoins(n);
        System.out.println("StaircaseRows are ::" +result);
    }
}
