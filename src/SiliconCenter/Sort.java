/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiliconCenter;

/**
 *
 * @author Suman Thapa
 */
public class Sort {
    /**
     * This method sorts the table in ascending order according to the price
     * @param a 
     */
    public static void sort(String[] a){
        for(int i = 4; i<a.length-1;i+=7){      //starting the for-loop from price column 
            int minPos = minPosFinder(a,i);
            swap(a, minPos, i);
        }
    }
    
    /**
     * This method returns the position of the minimum value in the array
     * @param a
     * @param from
     * @return int
     */
    public static int minPosFinder(String[] a, int from){
        int minPos = from;
        
        //increasing the value of i by 7 to select only price column from another row
        for (int i  = from+7; i<a.length; i+=7){    
            if(Integer.parseInt(a[i])<Integer.parseInt(a[minPos])){
                minPos  =  i;
            }
        }
        return minPos;
    }
    
    /**
     * This method is used to swap the row with minimum price at minimum position.
     * @param a
     * @param minPos
     * @param from 
     */
    public static void swap(String[]a, int minPos, int from){
       //storing the product details of minimum position on temporary variables.  
       String temp = a[minPos];
       String temp1 = a[minPos+1];
       String temp2 = a[minPos+2];
       String temp3 = a[minPos-1];
       String temp4 = a[minPos-2];
       String temp5 = a[minPos-3];
       String temp6 = a[minPos-4];
       
       //storing the product details with minimum price in the minimimum position.
       a[minPos] = a[from];
       a[from] = temp;
       a[minPos+1] = a[from+1];
       a[from+1] = temp1;
       a[minPos+2] = a[from+2];
       a[from+2] = temp2;
       a[minPos-1] = a[from-1];
       a[from-1] = temp3;
       a[minPos-2] = a[from-2];
       a[from-2] = temp4;
       a[minPos-3] = a[from-3];
       a[from-3] = temp5;
       a[minPos-4] = a[from-4];
       a[from-4] = temp6;
    }
}
