package Test;

public class Distance {

    public static void main(String args[]){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.rigth = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.rigth = new TreeNode(6);
        root.rigth.left = new TreeNode(9);
        root.rigth.rigth = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        int dis = findDistance(root,3,11,0);
        System.out.print(dis);
    }

    public static int findDistance(TreeNode root, int n1, int n2, int level){
        if(root == null){
            return  -1;
        }
        if(root.val == n1){
            return findLevel(root,n2,0);
        }
        else if(root.val == n2){
            return findLevel(root,n1,0);
        }

        else if(root.val > n1 && root.val > n2){
            return findDistance(root.left,n1,n2,level+1);
        }
        else if(root.val < n1 && root.val < n2){
            return findDistance(root.rigth,n1,n2,level+1);
        }
        else if(root.val > n1 && root.val < n2){
            int left=  findLevel(root.left,n1,1);
             int right = findLevel(root.rigth, n2, 1);
             if(left == -1 || right == -1){
                 return -1;
             }
             return left+ right;
        }
        else{
            int left = findLevel(root.left,n2,1);
            int right = findLevel(root.rigth,n1,1);
            if(left == -1 || right == -1){
                return -1;
            }
            return left+ right;
        }

    }

    public static int findLevel(TreeNode root, int n, int level){
        if(root == null){
            return -1;
        }
        if(root.val == n){
            return  level;
        }
        if(root.val > n){
            return findLevel(root.left,n,level+1);
        }
        return findLevel(root.rigth,n,level+1);
    }
}

