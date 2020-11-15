package com.huiwei.leetcode.hot100;

import com.huiwei.leetcode.util.Node;
import com.huiwei.leetcode.util.TreeNode;

import java.util.*;

public class No20 {
    /*1������֮��
     * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��
     * ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
     *
     * ע�⣺���в����԰����ظ�����Ԫ�顣
     *
     * ʾ����
     *
     * �������� nums = [-1, 0, 1, 2, -1, -4]��
     *
     * ����Ҫ�����Ԫ�鼯��Ϊ��
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public static List getThreeSumEqual0(int[] arr) {
        //����
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

    /*2������֮��
     * ��������?�ǿ� ������������ʾ�����Ǹ���������
     * ���У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
     *
     * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
     *
     * �����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
     *
     * ʾ����
     *
     * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * �����7 -> 0 -> 8
     * ԭ��342 + 465 = 807
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

    /*3��������Ʊ�����ʱ��
     * ����һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
     * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
     * ע�⣺�㲻���������Ʊǰ������Ʊ��
     *
     * ʾ�� 1:
        ����: [7,1,5,3,6,4]
        ���: 5
        ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
         ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
        ʾ�� 2:

        ����: [7,6,4,3,1]
        ���: 0
        ����: �����������, û�н������, �����������Ϊ 0��
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
     * 4�����������������
     */
    public static void goThroughBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("������Ϊ�գ������б���~~~");
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
     * 5���������Ĳ������
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
     * 6����¥��
     * ������������¥�ݡ���Ҫ n?������ܵ���¥����
     * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
     * <p>
     * ע�⣺���� n ��һ����������
     * <p>
     * ʾ�� 1��
     * <p>
     * ���룺 2
     * ����� 2
     * ���ͣ� �����ַ�����������¥����
     * 1.  1 �� + 1 ��
     * 2.  2 ��
     * ʾ�� 2��
     * <p>
     * ���룺 3
     * ����� 3
     * ���ͣ� �����ַ�����������¥����
     * 1.  1 �� + 1 �� + 1 ��
     * 2.  1 �� + 2 ��
     * 3.  2 �� + 1 ��
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
     * 7�� ��Ǯ�һ�(ʹ��DP��̬�滮)
     * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
     * ���û���κ�һ��Ӳ�����������ܽ����� -1��
     * <p>
     * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
     * <p>
     * ʾ�� 1��
     * <p>
     * ���룺coins = [1, 2, 5], amount = 11
     * �����3
     * ���ͣ�11 = 5 + 5 + 1
     * ʾ�� 2��
     * <p>
     * ���룺coins = [2], amount = 3
     * �����-1
     * ʾ�� 3��
     * <p>
     * ���룺coins = [1], amount = 0
     * �����0
     * ʾ�� 4��
     * <p>
     * ���룺coins = [1], amount = 1
     * �����1
     * ʾ�� 5��
     * <p>
     * ���룺coins = [1], amount = 2
     * �����2
     * <p>
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // f[i][j] ��ʾǰ i ��Ӳ�Ҵճ�����Ϊ j ʱ���������Ӳ����
        int f[][] = new int[n + 1][amount + 1];
        // ��ʼ״̬��ǰ 0 ��Ӳ�Ҵճ����� > 0 ʱ�����ܴճɣ���ʼ��Ϊ 0x3f3f3f3f
        for (int j = 1; j <= amount; j++) f[0][j] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // �ܴվ�ѡ��ջ��ǲ���
                if (j >= coins[i - 1]) f[i][j] = Math.min(f[i - 1][j], f[i][j - coins[i - 1]] + 1);
                    // ���ܴվ�ֻ�ò���
                else f[i][j] = f[i - 1][j];
            }
        }
        return f[n][amount] == Integer.MAX_VALUE ? -1 : f[n][amount];
    }

    /**
     * 8������ܺ� todo
     * ����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?��
     * �ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
     * <p>
     * candidates?�е����ֿ����������ظ���ѡȡ��
     * <p>
     * ˵����
     * <p>
     * �������֣�����?target��������������
     * �⼯���ܰ����ظ�����ϡ�?
     * ʾ��?1��
     * <p>
     * ���룺candidates = [2,3,6,7], target = 7,
     * ����⼯Ϊ��
     * [
     * [7],
     * [2,2,3]
     * ]
     * ʾ��?2��
     * <p>
     * ���룺candidates = [2,3,5], target = 8,
     * ����⼯Ϊ��
     * [
     * ? [2,2,2,2],
     * ? [2,3,3],
     * ? [3,5]
     * ]
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate �е�ÿ��Ԫ�ض��Ƕ�һ�޶��ġ�
     * 1 <= target <= 500
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        //����
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    public static void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        //�ݹ���յ�
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0]) return;
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            //����һ�ݣ���Ӱ���´εݹ�
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            //�ݹ����㣬��i��������һ��������Ϊ�˱������ظ���
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }

    /**9����ǰ��������������й�������� todo
     *����һ������ǰ�������������������������
     *
     * ע��:
     * ����Լ�������û���ظ���Ԫ�ء�
     *
     * ���磬����
     *
     * ǰ����� preorder =?[3,9,20,15,7]
     * ������� inorder = [9,3,15,20,7]
     * �������µĶ�������
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     */


    /**
     * 10��ʢˮ��������
     * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ��
     * �������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0) ��
     * �ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
     * <p>
     * ˵�����㲻����б������
     * <p>
     * ʾ�� 1��
     * ���룺[1,8,6,2,5,4,8,3,7]
     * �����49
     * ���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]��
     * �ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ?49��
     * <p>
     * ʾ�� 2��
     * ���룺height = [1,1]
     * �����1
     * <p>
     * ʾ�� 3��
     * ���룺height = [4,3,2,1,4]
     * �����16
     * <p>
     * ʾ�� 4��
     * ���룺height = [1,2,1]
     * �����2
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

    /**11���ַ�������
     *����һ������������ַ������������������ַ�����
     *
     * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
     *
     * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
     *
     * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������?3a?��?2[4]?�����롣
     *
     * ʾ�� 1��
     *
     * ���룺s = "3[a]2[bc]"
     * �����"aaabcbc"
     * ʾ�� 2��
     *
     * ���룺s = "3[a2[c]]"
     * �����"accaccacc"
     * ʾ�� 3��
     *
     * ���룺s = "2[abc]3[cd]ef"
     * �����"abcabccdcdcdef"
     * ʾ�� 4��
     *
     * ���룺s = "abc3[cd]xyz"
     * �����"abccdcdcdxyz"
     */
    /**
     * ʹ��˫ջ��ʵ��
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
            //���������
            if (Character.isDigit(c)) {
                int number = c - '0';
                while (Character.isDigit(s.charAt(i + 1))) {
                    c = s.charAt(++i);
                    number = number * 10 + c - '0';
                }
                intStack.push(number);
            }
            //�����'['
            else if (c == '[') {
                strStack.push(new StringBuilder());
            }
            //�����']'
            else if (c == ']') {
                StringBuilder strPop = strStack.pop();
                Integer intPop = intStack.pop();
                while (intPop > 0) {
                    strStack.peek().append(strPop);
                    intPop--;
                }
            }
            //������ַ�
            else {
                strStack.peek().append(c);
            }
        }
        return strStack.pop().toString();
    }

    /**
     * 12��ÿ���¶�
     * �����ÿ�� ���� �б���������һ���б���Ӧλ�õ����Ϊ��Ҫ��۲⵽���ߵ����£�
     * ������Ҫ�ȴ��������������������֮�󶼲������ߣ����ڸ�λ����?0 �����档
     * <p>
     * ���磬����һ���б�?temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��
     * ������Ӧ����?[1, 1, 4, 2, 1, 1, 0, 0]��
     * <p>
     * ��ʾ������ �б��ȵķ�Χ��?[1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�������?[30, 100]?��Χ�ڵ�������
     */
    //���õ���ջ
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
     * 13���γ̱�
     * �����ѧ�ڱ���ѡ�� numCourse �ſγ̣���Ϊ?0?��?numCourse-1 ��
     * <p>
     * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡�?���磬��Ҫѧϰ�γ� 0 ��
     * ����Ҫ����ɿγ� 1 ��������һ��ƥ������ʾ���ǣ�[0,1]
     * <p>
     * �����γ������Լ����ǵ��Ⱦ������������ж��Ƿ����������пγ̵�ѧϰ��
     * <p>
     * ʾ�� 1:
     * <p>
     * ����: 2, [[1,0]]
     * ���: true
     * ����:?�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ��ɿγ� 0���������ǿ��ܵġ�
     * ʾ�� 2:
     * <p>
     * ����: 3, [[1,0],[1,2]]
     * ���: false
     * ����:?�ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ�����?�γ� 0��
     * ����ѧϰ�γ� 0 ֮ǰ���㻹Ӧ����ɿγ� 1�����ǲ����ܵġ�
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //����
        if (numCourses <= 0) {
            return true;
        }
        if (prerequisites.length <= 0) {
            return true;
        }
        //��ʼ�������������
        int[] inDegree = new int[numCourses];
        //��ʼ���ڽӱ�
        HashSet<Integer>[] adjacency = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new HashSet<>();
        }

        //��������
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjacency[prerequisite[1]].add(prerequisite[0]);
        }

        //��ʼ��һ����������ѭ���������Ϊ�������
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //ѭ���������Ϊ�������
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

    /**14����������ֱ��
     *����һ�ö�����������Ҫ��������ֱ�����ȡ�
     * һ�ö�������ֱ�������������������·�������е����ֵ��
     * ����·�����ܴ���Ҳ���ܲ���������㡣
     *
     * ʾ�� :
     * ����������
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * ����?3, ���ĳ�����·�� [4,2,1,3] ����?[5,2,1,3]��
     *
     * ע�⣺�����֮���·��������������֮��ߵ���Ŀ��ʾ��
     */

    //��¼���ֵ
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

    /**15������λ����
     *����һ���Ǹ�����?num������?0 �� i �� num ��Χ�е�ÿ������?i?��
     * ��������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
     *
     * ʾ�� 1:
     *
     * ����: 2
     * ���: [0,1,1]
     * ʾ��?2:
     *
     * ����: 10
     * ���: [0,1,1,2,1,2]
     * ����:
     *
     * ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ��������
     * Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
     * ���ܽ�һ�����ƽⷨ��
     * Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е�?__builtin_popcount����ִ�д˲�����
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
