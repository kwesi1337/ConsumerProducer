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
public class Consumer implements Runnable {
    
    
    BlockingQueue s2;
    
    private long sum;
    
    public Consumer(BlockingQueue S2){
        
        this.s2 = s2;
        
    }
    
    public long getSum(){
        
        return sum;
    }
    
    
    @Override
    
    public void run(){
        
        long temp;
        
        while (!s2.isEmpty()){
            
            try {
                
                temp = (long) s2.take();
                
                sum += temp;
                System.out.println("Number.. " + temp);
                
                
            } catch (Exception ex){
                System.out.println(ex);
                
                
            }
        }
        
        System.out.println("Sum. " + sum);
    }
}
