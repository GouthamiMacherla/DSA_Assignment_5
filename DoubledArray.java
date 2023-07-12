/*
 * <aside>
💡 **Question 8**

An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.

Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.

**Example 1:**

**Input:** changed = [1,3,4,2,6,8]

**Output:** [1,3,4]

**Explanation:** One possible original array could be [1,3,4]:

- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.

Other original arrays could be [4,3,1] or [3,1,4].

</aside>
 * 
 */

package in.ineuron.gouthami;

import java.util.*;

public class DoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // Empty array if length is odd
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(changed);

        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (countMap.get(num) == 0) {
                continue; // Skip if num has been used before
            }
            
            int doubleNum = num * 2;
            if (countMap.containsKey(doubleNum) && countMap.get(doubleNum) > 0) {
                originalList.add(num);
                countMap.put(num, countMap.get(num) - 1);
                countMap.put(doubleNum, countMap.get(doubleNum) - 1);
            }
        }

        if (originalList.size() != changed.length / 2) {
            return new int[0]; // Empty array if not a doubled array
        }

        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }

        return originalArray;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);

        System.out.println("Doubled Array is  :: " +Arrays.toString(original));
    }
}
