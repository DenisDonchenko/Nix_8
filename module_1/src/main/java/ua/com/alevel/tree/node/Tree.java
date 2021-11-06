package ua.com.alevel.tree.node;

import ua.com.alevel.tree.node.util.ValideInputString;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {

    private List<String> arrayTreeElements = new ArrayList<>();
    private BufferedReader reader;
    private TreeNode root;
    private String inputStringElement = "";

    public Tree(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() {
        preview();
        readString();
        addNumberToTree();
        printMaximumDepth();
    }

    private void printMaximumDepth() {
        System.out.println("Maximum tree depth " + arrayTreeElements + " - " + treeDepth(root));
    }

    private void addNumberToTree() {
        root = new TreeNode(Integer.parseInt(arrayTreeElements.get(0)));
        for (int i = 1; i < arrayTreeElements.size(); i++) {
            addElement(root, Integer.parseInt(arrayTreeElements.get(i)));
        }
    }

    private void readString() {
        System.out.println("Enter numbers separated by spaces, the first number will be the root of the tree.\n" + "Example - 1 2 3 4 5 6 ");

        try {
            inputStringElement = reader.readLine().trim();
            if (!ValideInputString.valideString(inputStringElement)) {
                throw new Exception();
            }
        } catch (Exception e) {
            readString();
        }
        arrayTreeElements = new ArrayList<String>(Arrays.asList(inputStringElement.split(" ")));
    }

    public static int treeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int nLeft = treeDepth(pRoot.left);
        int nRight = treeDepth(pRoot.right);
        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }

    private void preview() {
        System.out.println("\nThe program calculates the maximum depth of the binary tree.");
        System.out.println("if you want exit, select - 0");
    }

    private void addElement(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                addElement(node.left, value);
            } else node.left = new TreeNode(value);
        } else if (value > node.val) {
            if (node.right != null) {
                addElement(node.right, value);
            } else node.right = new TreeNode(value);
        }
    }

}
