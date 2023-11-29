package Assignments;

import java.util.HashSet;
import java.util.Set;

public class Test_set {

    public static void main(String args[]){

        int[] mat1 = {1, 2};


        Set<int[]> set = new HashSet<>();
        set.add(mat1);

        int[] mat2 =  {1, 2};

        System.out.println(set.contains(mat2));
    }
}
