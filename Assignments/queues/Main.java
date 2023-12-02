import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class Main{
    public static void main(String[] args){
        RandomizedQueue<String> raq = new RandomizedQueue<>();
        raq.enqueue("apple");
        raq.enqueue("mango");
        raq.enqueue("sugarcane");
        raq.enqueue("jackfruit");
        raq.enqueue("pineapple");
        raq.dequeue();
        raq.dequeue();
        raq.dequeue();
        raq.dequeue();
        raq.dequeue();
        raq.enqueue("orenge");
        raq.enqueue("jaguar");
        raq.enqueue("bmw");
        raq.enqueue("audi");
        raq.enqueue("jackfruit");
        raq.enqueue("marshmellow");



        
       
        // System.out.println(raq.sample());
        // System.out.println(raq.sample());
        // System.out.println(raq.sample());
        // System.out.println(raq.sample());
        // System.out.println(raq.sample());
        // System.out.println(raq.sample());

        Iterator itr = raq.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



        

    }
}