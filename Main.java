public class Main {
    public static void main(String [] args){

       Tree a = new Tree();
       /*
              60
           /     \
          40      90
         /  \    /  \
       20   50  70   100

        */
       // 60 40 20 50 90 70 100
       //20 40 50 60 70 90 100
        //20 50 40 70 100 90 60

       a.add(60);
       a.add(40);
      a.add(20);
       a.add(50);
       a.add(90);
       a.add(70);
       a.add(100);


         a.invertTree();
        // a.postorder();
        //a.delete(40);
         a.bfs();
        //a.preoder();
       //a.inorder();
        //a.postorder();
        //System.out.println(a.find(40));
        //System.out.println(a.findRecursive(90));
        //System.out.println(a.max());
        //System.out.println(a.maxRecursive());





    }
}
