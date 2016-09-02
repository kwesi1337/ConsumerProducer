/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerproducer;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author josephawwal
 */
public class Producer implements Runnable {
    
    
    BlockingQueue bq1;
    BlockingQueue bq2;
    
    public Producer(BlockingQueue bq1, BlockingQueue bq2){
        
        this.bq1 = bq1;
        this.bq2 = bq2;
        
    }
    
    
   @Override 
   
   public void run(){
       
       while (!bq1.isEmpty())
       {
           
           try {
               
               int no = (int) bq1.poll();
               long temp = fib( (long)no );
               bq2.put(temp);
               
           }
           
           catch (InterruptedException e){
               
               System.out.println(e);
           }
       }
   }
   
   private long fib(long n){
       
       if ((n == 0) || (n == 1)) {
           
           return n;
           
           
       } else {
           
           return fib(n-1) + fib(n-2);
           
       }
   }
}
