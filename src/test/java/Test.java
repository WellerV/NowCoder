import com.huwei.leetcode.*;

import java.util.ArrayList;

/**
 * Created by huwei on 17-8-23.
 */
public class Test {
    @org.junit.Test
    public void test29050() throws Exception {
        char boards[][] = {{'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}};
        new Leetcode29050().solve(boards);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                builder.append(boards[i][j]);
            }
            builder.append("\n");
        }
        System.out.print(builder);
        /**
         * [XOXOXO,OXXXXX,XXXXXO,OXOXOX]
         */
    }

    @org.junit.Test
    public void test29051() throws Exception {
        int[] array = new int[]{0, 1, 2};
//        int[] array = new int[]{1, 2, 3, 4, 5};
        TreeNode root = TreeNode.create(array);
        System.out.print(new Leetcode29051().sumNumbers(root));
    }

    @org.junit.Test
    public void test29052() throws Exception {
        int num[] = new int[]{100, 4, 200, 1, 3, 2};
        System.out.print(new Leetcode29052().longestConsecutive(num));
    }

    @org.junit.Test
    public void test29055() throws Exception {
        String s = ".,";
        System.out.print(new Leetcode29055().isPalindrome(s));
    }

    @org.junit.Test
    public void test29060() throws Exception {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        triangle.add(list);

        list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        triangle.add(list);

        list = new ArrayList<Integer>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);

        list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);

        System.out.print(new Leetcode29060().minimumTotal(triangle));
    }

    @org.junit.Test
    public void test29061() throws Exception {
        System.out.print(new Leetcode29061().getRow(3));
    }
}
