/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author h
 */
package opnsrc.fcih.trainrsys.backend;

import java.util.Scanner;

 
/** class Task **/
class Queueinput
{
    String passenger;
    int priority;
 
    /** Constructor **/
    public Queueinput(String  passenger , int priority)
    {
        this.passenger = passenger ;
        this.priority = priority; 
    }
    /** toString() **/
    public String toString() 
    {
        return "passenger Name : "+ passenger +"\nPriority : "+ priority;
    }
}
 
/** Class PriorityQueue **/
class PriorityQueue
{
    private Queueinput[] Reseptionqueue; 
    private int ReseptionqueueSize, capacity;
 
    /** Constructor **/
    public PriorityQueue(int capacity)
    {    
        this.capacity = capacity;
        Reseptionqueue = new Queueinput[this.capacity];
        ReseptionqueueSize = -1;
    }
    /** function to clear **/
    public void clear()
    {
        Reseptionqueue = new Queueinput[capacity];
        ReseptionqueueSize = -1;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return ReseptionqueueSize == -1;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return ReseptionqueueSize == capacity ;
    }
    /** function to get Size **/
    public int size()
    {
        return ReseptionqueueSize;
    }
    /** function to insert task **/
    public void insert(String passenger, int priority)
    {
        Queueinput newJob = new Queueinput(passenger, priority);
 if(ReseptionqueueSize== -1){
        Reseptionqueue[++ReseptionqueueSize] = newJob;}
   
 // int pos = heapSize;
 else{
       int i;
        if(newJob.priority > Reseptionqueue[ReseptionqueueSize].priority)
        {
          Reseptionqueue[++ReseptionqueueSize] = newJob;   
            /*heap[pos] = heap[pos/2];
            pos /=2;*/
        }
        else
        {
          for(i=ReseptionqueueSize;i>=0;i--)
          {
              Reseptionqueue[i+1]=Reseptionqueue[i];
              
          }
          Reseptionqueue[0]=newJob;
          ReseptionqueueSize++;
        }
        
      //  heap[pos] = newJob;    
    }}
    public Queueinput remove()
    {
        if(ReseptionqueueSize==-1)
        {
             System.out.println("Heap is empty");
            return null;
        }
        
         Queueinput item;
         item=Reseptionqueue[0];
         int i;
         for(i=1;i<=ReseptionqueueSize;i++)
         {
             Reseptionqueue[i-1]=Reseptionqueue[i];
         }
         ReseptionqueueSize--;
         return item;
        
    }

    /** function to remove task **/
 /*  public Task remove()
    {
        
        int parent, child;
        Task item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }
}
 
/** Class PriorityQueueTest **/
public class PriorityQueueTest
{ 
    public void Prio(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Test\n");   
 
        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(scan.nextInt() );
 
        char ch;
        /*  Perform Priority Queue operations */
       do    
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. clear");
            System.out.println("6. size");
 
            int choice = scan.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter job name and priority");
                pq.insert(scan.next(), scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("\nJob removed \n\n"+ pq.remove()); 
                break;        
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
            case 5 : 
                System.out.println("\nPriority Queue Cleared");
                pq.clear();
                break;    
            case 6 : 
                System.out.println("\nSize = "+ pq.size() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');            
    }
}}