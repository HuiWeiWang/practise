package com.huiwei.leetcode.hot100;

import com.huiwei.leetcode.util.Node;
import com.huiwei.leetcode.util.TreeNode;

import java.util.*;

public class No20 {
    /*1、三数之和
     * 给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，
     * 使得?a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public static List getThreeSumEqual0(int[] arr) {
        //特判
        if (arr == null || arr.length <= 0) return new ArrayList();

        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2 && arr[i] <= 0; i++) {
            if (i == 0 || (i > 0 && arr[i - 1] != arr[i])) {
                int j = i + 1, k = arr.length - 1, sum = 0 - arr[i];
                while (j < k) {
                    if(arr[j]+arr[k]==sum){
                        res.add(Arrays.asList(arr[i],arr[j],arr[k]));
                        while(j<k&&arr[j]==arr[j+1]) j++;
                        while (j<k&&arr[k-1]==arr[k]) k--;
                        j++;
                        k--;
                    }else if(arr[j]+arr[k]>sum){
                        while (j<k&&arr[k-1]==arr[k]) k--;
                        k--;
                    }else {
                        while(j<k&&arr[j]==arr[j+1]) j++;
                        j++;
                    }
                }
            }
        }
        return res;
    }

    /*2、两数之和
     * 给出两个?非空 的链表用来表示两个非负的整数。
     * 其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0?开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public Node getSumNode(Node node1, Node node2) {
        Node head = new Node();
        Node cusor = head;
        int carry = 0;
        int sum = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int val1 = node1 != null ? node1.value : 0;
            int val2 = node2 != null ? node2.value : 0;
            sum = val1 + val2 + carry;
            carry = carry / 10;
            Node newNode = new Node(sum % 10);
            cusor.next = newNode;
            cusor = cusor.next;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        return head.next;
    }

    /*3、买卖股票的最佳时机
     * 给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     *
     * 示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        示例 2:

        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public static int getMaxProfit(int arr[]) {
        if (arr.length <= 0) return 0;
        int min = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return max;
    }

    /**
     * 4、二叉树的中序遍历
     */
    public static void goThroughBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("二叉树为空，不进行遍历~~~");
            return;
        }
        System.out.print(root.value + "--->");
        if (root.left != null) {
            goThroughBinaryTree(root.left);
        }
        if (root.right != null) {
            goThroughBinaryTree(root.right);
        }
    }

    /**
     * 5、二叉树的层序遍历
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 6、爬楼梯
     * 假设你正在爬楼梯。需要 n?阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    /**
     * todo
     * 7、 零钱兑换(使用DP动态规划)
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：coins = [1], amount = 1
     * 输出：1
     * 示例 5：
     * <p>
     * 输入：coins = [1], amount = 2
     * 输出：2
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // f[i][j] 表示前 i 种硬币凑成总数为 j 时所需的最少硬币数
        int f[][] = new int[n + 1][amount + 1];
        // 初始状态：前 0 种硬币凑成总数 > 0 时不可能凑成，初始化为 0x3f3f3f3f
        for (int j = 1; j <= amount; j++) f[0][j] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 能凑就选择凑还是不凑
                if (j >= coins[i - 1]) f[i][j] = Math.min(f[i - 1][j], f[i][j - coins[i - 1]] + 1);
                    // 不能凑就只好不凑
                else f[i][j] = f[i - 1][j];
            }
        }
        return f[n][amount] == Integer.MAX_VALUE ? -1 : f[n][amount];
    }

    /**
     * 8、组合总和 todo
     * 给定一个无重复元素的数组?candidates?和一个目标数?target?，
     * 找出?candidates?中所有可以使数字和为?target?的组合。
     * <p>
     * candidates?中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括?target）都是正整数。
     * 解集不能包含重复的组合。?
     * 示例?1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例?2：
     * <p>
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     * ? [2,2,2,2],
     * ? [2,3,3],
     * ? [3,5]
     * ]
     * <p>
     * 提示：
     * <p>
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    public static void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        //递归的终点
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0]) return;
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            //拷贝一份，不影响下次递归
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }

    /**9、从前序与中序遍历序列构造二叉树 todo
     *根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder =?[3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     */


    /**
     * 10、盛水最多的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
     * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为?49。
     * <p>
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * <p>
     * 示例 4：
     * 输入：height = [1,2,1]
     * 输出：2
     */

    public static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**11、字符串解码
     *给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像?3a?或?2[4]?的输入。
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     */
    /**
     * 使用双栈法实现
     *
     * @param s
     * @return
     */
    public static String decodeStr(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        strStack.push(new StringBuilder());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是数字
            if (Character.isDigit(c)) {
                int number = c - '0';
                while (Character.isDigit(s.charAt(i + 1))) {
                    c = s.charAt(++i);
                    number = number * 10 + c - '0';
                }
                intStack.push(number);
            }
            //如果是'['
            else if (c == '[') {
                strStack.push(new StringBuilder());
            }
            //如果是']'
            else if (c == ']') {
                StringBuilder strPop = strStack.pop();
                Integer intPop = intStack.pop();
                while (intPop > 0) {
                    strStack.peek().append(strPop);
                    intPop--;
                }
            }
            //如果是字符
            else {
                strStack.peek().append(c);
            }
        }
        return strStack.pop().toString();
    }

    /**
     * 12、每日温度
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
     * 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用?0 来代替。
     * <p>
     * 例如，给定一个列表?temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     * 你的输出应该是?[1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是?[1, 30000]。每个气温的值的均为华氏度，都是在?[30, 100]?范围内的整数。
     */
    //利用单调栈
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 13、课程表
     * 你这个学期必须选修 numCourse 门课程，记为?0?到?numCourse-1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。?例如，想要学习课程 0 ，
     * 你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释:?总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     * <p>
     * 输入: 3, [[1,0],[1,2]]
     * 输出: false
     * 解释:?总共有 2 门课程。学习课程 1 之前，你需要先完成?课程 0；
     * 并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //特判
        if (numCourses <= 0) {
            return true;
        }
        if (prerequisites.length <= 0) {
            return true;
        }
        //初始化辅助入度数组
        int[] inDegree = new int[numCourses];
        //初始化邻接表
        HashSet<Integer>[] adjacency = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new HashSet<>();
        }

        //填入数据
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjacency[prerequisite[1]].add(prerequisite[0]);
        }

        //初始化一个队列用于循环处理入度为零的数据
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //循环处理入度为零的数据
        int count = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            count++;
            for (Integer integer : adjacency[top]) {
                inDegree[integer]--;
                if (inDegree[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        return count == numCourses;
    }

    /**14、二叉树的直径
     *给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回?3, 它的长度是路径 [4,2,1,3] 或者?[5,2,1,3]。
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     */

    //记录最大值
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        depth(root);
        return max;
    }
    private static int depth(TreeNode node) {
        if(node==null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(left+right,max);
        return Math.max(left,right)+1;
    }

    /**15、比特位计数
     *给定一个非负整数?num。对于?0 ≤ i ≤ num 范围中的每个数字?i?，
     * 计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * 示例 1:
     *
     * 输入: 2
     * 输出: [0,1,1]
     * 示例?2:
     *
     * 输入: 10
     * 输出: [0,1,1,2,1,2]
     * 进阶:
     *
     * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     * 要求算法的空间复杂度为O(n)。
     * 你能进一步完善解法吗？
     * 要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的?__builtin_popcount）来执行此操作。
     */

    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0]=0;
        for (int i = 1; i <= num; i++) {
            if(i%2==1){
                result[i] = result[i-1]+1;
            }else {
                result[i] = result[i/2];
            }
        }
        return result;
    }




    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(15)));
    }
}
