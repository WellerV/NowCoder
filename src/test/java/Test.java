import com.huwei.leetcode.Leetcode29050;
import com.huwei.leetcode.Leetcode29051;
import com.huwei.leetcode.TreeNode;

/**
 * Created by huwei on 17-8-23.
 */
public class Test {
    @org.junit.Test
    public void test29050() throws Exception {
        char boards[][] = {{'X','O','X','O','X','O'},
                {'O','X','X','X','X','X'},
                {'X','X','X','X','X','O'},
                {'O','X','O','X','O','X'}};
        new Leetcode29050().solve(boards);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< boards.length; i++) {
            for (int j=0; j< boards[i].length; j++){
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
}
