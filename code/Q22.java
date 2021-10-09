package com.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    //Generate Parentheses
    public List<String> generateParenthesis (int n) {
        if (n < 1) {
            return null;
        }
        List<String> result = new ArrayList<>();
        //Moving the decimal to the left one spot, the actual result is divide by 2
        char[] partialResult = new char[n<<1];

        generate(partialResult, n, n, 0, result);

        return result;
    }

    public void generate (char[] partialResult, int leftRemain, int rightRemain, int count, List<String> result) {
        if (leftRemain < 0 || rightRemain < leftRemain) {
            //return to the previous level
            return;
        } else if (leftRemain == 0 && rightRemain == 0) {
            result.add(new String(partialResult));
        } else {
            if (leftRemain > 0) {
                partialResult[count] = '(';
                generate(partialResult, leftRemain-1, rightRemain, count+1, result);
            }
            if (rightRemain > leftRemain) {
                partialResult[count] = ')';
                generate(partialResult, leftRemain, rightRemain-1, count+1, result);
            }
        }
    }
}
