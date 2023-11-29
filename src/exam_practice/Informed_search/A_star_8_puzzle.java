package exam_practice.Informed_search;

public class A_star_8_puzzle {

    public static void main(String args[]) throws Exception {
        String s=new String();
        Astars a1=new Astars();
        a1.getState();
        a1.display();
        s=a1.TreeSearch();
        System.out.println(s);
    }
}
