package com.huwei.leetcode;

import java.util.ArrayList;

/**
 * Created by huwei on 17-11-12.
 */
public class Leetcode29132 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                ArrayList<Integer> seqList = new ArrayList<>();
                seqList.add(num[i]);
                resultList.add(seqList);
            } else {
                int len = resultList.size();
                for (int j = 0; j < len; j++) {
                    ArrayList<Integer> prefixSeqList = resultList.get(j);
                    ArrayList<Integer> postFixSeqList = (ArrayList<Integer>) prefixSeqList.clone();
                    resultList.add(postFixSeqList);

                    prefixSeqList.add(0, num[i]);
                    postFixSeqList.add(num[i]);
                }
            }
        }
        return resultList;
    }
}
