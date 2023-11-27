package Assignments;


import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Uninformed_search {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value at root: ");
        int rootVal = sc.nextInt();

        TreeNode root = new TreeNode(rootVal);

        System.out.println("Enter the value in the format: ");
        System.out.println("\"left <value>\" to add node to the left.");
        System.out.println("\"right <value>\" to add node to the right.");
        System.out.println("\"end\" to stop adding the nodes.");

    }

    private void getValues(TreeNode root){
        Scanner sc = new Scanner(System.in);
        String value = new String();
        do{
            value = sc.next();
            String[] split = value.split(" ");

        }while(!sc.equals("close"));
    }

}
