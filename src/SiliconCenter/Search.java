/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiliconCenter;

import javax.swing.JOptionPane;

/**
 *
 * @author Suman Thapa
 */
public class Search {
    
    /**
     * This method finds the product details from the given price.
     * @param a
     * @param s 
     */
    public static void binarySearchPrice(String[] a,String s){
        String find = s;
        int priceIndex = 4;
        int [] valueIndex = new int[a.length/7];
        String b[] = new String[a.length/7];    //storing only the price column
        for(int i =0; i<b.length; i++){
           b[i] = a[priceIndex];
           valueIndex[i] = priceIndex;    
           priceIndex+=7;
        }
        int low = 0;
        int high  = b.length-1;
        int result = -1;
        int index = binarySearch(b,low,high,find,result);
        
        //displaying the product details if the price is found
        if(index>=0){
            JOptionPane.showMessageDialog(null,"Product number: "+ a[valueIndex[index]-4] + "\n"
            +"Name: " + a[valueIndex[index]-3] + "\n" + "Category: " +  a[valueIndex[index]-2] +"\n"
            +"Company: " + a[valueIndex[index]-1] + "\n" + "Price: " + a[valueIndex[index]] + "\n"
            +"Availability: " + a[valueIndex[index]+1] + "\n" + "Rating: " + a[valueIndex[index]+2]
            );
        } else{
            JOptionPane.showMessageDialog(null, "The item does not exist. Please enter another value.");
        }
    }
    
    /**
     * This method implements the binary search to find the required price.
     * @param a
     * @param low
     * @param high
     * @param find
     * @param result
     * @return int
     */
    public static int binarySearch(String[] a,int low, int high, String find,int result){
      
        if(low<=high){
            int mid =(low+high)/2;
            
            if(Integer.parseInt(a[mid])==Integer.parseInt(find)){
                result = mid;
                return binarySearch(a,low,mid-1,find,result);   //for displaying the first occurence of data if price is repeated 
                
            }else if(Integer.parseInt(a[mid])< Integer.parseInt(find)){
                return binarySearch(a,mid+1,high,find,result);
            }else{
                return binarySearch(a,low,mid-1,find,result);
            }
        }
        return result;
    }
    
    /**
     * This method finds the products available in a category. 
     * @param a
     * @param s 
     */
    public static void searchCategory(String[] a, String s){
       String b = ""; 
       int countData = 0;   //for counting the number of products
       for(int i = 2; i<a.length; i+=7){
           if(s.equals(a[i])){
                b = b + ("\nProduct Number: " + a[i-2] +"\n" + "Name: " + a[i-1] + "\n");
                countData++;
           }
       }
       if (!b.isEmpty()){
            JOptionPane.showMessageDialog(null,  s + " category contains " + countData + " product.\n" + b);
       } else{
            JOptionPane.showMessageDialog(null, "Data not found. Please select another category");
       }
    }
}
