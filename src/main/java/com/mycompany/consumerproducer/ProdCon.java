/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerproducer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author josephawwal
 */
public class ProdCon {
    
    public static void main(String[] args) throws InterruptedException {
        
        BlockingQueue bq1 = new ArrayBlockingQueue(11);
        BlockingQueue bq2 = new ArrayBlockingQueue(11);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Type amount of threads to use: ");
        int threadsNo = scan.nextInt();
        
        ArrayList<Thread> threads = new ArrayList<>();
        
        
        bq1.put(4);
        bq1.put(5);
        bq1.put(8);
        bq1.put(12);
        bq1.put(21);
        bq1.put(22);
        bq1.put(34);
        bq1.put(35);
        bq1.put(36);
        bq1.put(37);
        bq1.put(42);
        
        for (int i = 0; i < threadsNo; i++){
            
            Thread t = new Thread(new Producer(bq1, bq2));
            threads.add(t);
            threads.get(i).start();
            threads.get(i).join();
            
            
        
        }
        
        Thread t = new Thread(new Consumer(bq2));
        
        t.start();
        t.join();
        
        
        
    }
}
