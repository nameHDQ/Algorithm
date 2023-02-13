package DayOne.medium;

public class JZ33 {
    public boolean verifyPostorder(int[] postorder) {


        return backTracing(postorder, 0, postorder.length - 1);
    }

    public boolean backTracing(int[] postorder, int left, int rootIndex){
        if (left >= rootIndex) return true;
        int temp = left;
        while (postorder[temp] < postorder[rootIndex]) temp++;
        int rightStart = temp;
        while (postorder[temp] > postorder[rootIndex]) temp++;


        return temp == rootIndex && backTracing(postorder, left, rightStart - 1)
                && backTracing(postorder, rightStart, rootIndex - 1);
    }
}
