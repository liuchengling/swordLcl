package lclAlgorithm;

import java.io.BufferedWriter;
import java.security.cert.CertPathBuilderResult;

public class Top7RebuildBinaryTree {
    static class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        Tree tree = ConstructTree(pre, mid);
        PrintPre(tree);
        PrintMid(tree);
    }

    private static void PrintPre(Tree pre) {
        if (pre == null) {
            return;
        }
        System.out.println("pre : " + pre.val);
        PrintPre(pre.left);
        PrintPre(pre.right);
    }

    private static void PrintMid(Tree mid) {
        if (mid == null) {
            return;
        }
        PrintMid(mid.left);
        System.out.println("mid : " + mid.val);
        PrintMid(mid.right);
    }

    private static Tree ConstructTree(int[] pre, int[] mid) {
        if (null == pre || pre.length <= 0 || pre.length != mid.length) {
            return null;
        }
        return BuildTree(pre, mid, 0, pre.length - 1, 0, mid.length - 1);
    }

    private static Tree BuildTree(int[] pre, int[] mid, int pStart, int pEnd, int mStart, int mEnd) {
        Tree root = new Tree(pre[pStart]);
        if (pStart == pEnd && mStart == mEnd) {
            if (pre[pStart] != mid[mStart]) {
                System.out.println("error");
            }
            return root;

        }
        int index = mStart;
        for (; index <= mEnd; index++) {
            if (root.val == mid[index]) {
                break;
            }
        }
        int length = index - mStart;
        if (index - mStart > 0) {
            root.left = BuildTree(pre, mid, pStart + 1, pStart + length + 1, mStart, index - 1);
        }
        if (mEnd - index > 0) {
            root.right = BuildTree(pre, mid, pStart + length + 1, pEnd, index+ 1, mEnd);
        }
        return root;
    }


}
