package edu.neu.coe.info6205.union_find;
import java.util.Random;
public class WeightedQuickUnion {
    public static int count(int N){

        Random Random=new Random();
        int Times=0;


      for(int i=0;i<100;i++){
        UF_HWQUPC uf=new UF_HWQUPC(N);
        while(uf.count()>1){

            int p=Random.nextInt(N);
            int q=Random.nextInt(N);
            Times+=1;
            if(uf.isConnected(p,q)==false) {

                uf.union(p, q);

            }
        }
        }//end while
        System.out.println("N   is  "+N+"   M   is   "+Times/100);

        return Times/100;
    }

    public static void main(String[] args)
    {int N=20;
        for(int i=0;i<100;i++) {
            N*=2;
            WeightedQuickUnion.count(N);
      /*      System.out.println("M is  " + WeightedQuickUnion.count(N));*/
        }
    }
}
