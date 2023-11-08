import java.lang.*;
import java.util.*;

public class Fibbonaci_series{
        public static Scanner sc = new Scanner(System.in);
        
        public void Fibo_iterative(int n){
                int[] arr = new int[n+1];
                arr[0] = 0;
                arr[1] = 1;
                System.out.println("1. 0\n2. 1");
                
                int i = 2;
                while(i<(n+1)){
                        arr[i] = arr[i-1] + arr[i-2];
                        System.out.println(i + ". " + arr[i]);
                        i++;
                }
        }
        
        public int Fibo_recursive(int n){
                if(n==0 || n==1){
                        return n;
                }
                return Fibo_recursive(n-1) + Fibo_recursive(n-2);
        }
        
        public void Fibo_recursive_util(int nums){     
                int i = 0; 
                while(i<(nums+1)){
                        System.out.println(i +  ". " + Fibo_recursive(i)+ " " );
                        i++;

                }
        
        }

        public static void main(String[] args){
                Fibbonaci_series obj = new Fibbonaci_series();

                while(true){
                        System.out.println("1. Iterative fibonacci. \n2. Recursive fibonacci.\n0. To Exit. ");
                        int ch = sc.nextInt();
                        
                        if(ch == 0){
                                System.exit(0);
                        }

                        int nums = 0; 
                        System.out.println("Enter Number of Fibonacci series required : ");
                        nums = sc.nextInt();
                        
                        
                        
                        switch(ch){
                                case 1:
                                        System.out.println("Fibonacci series : ");
                                        obj.Fibo_iterative(nums);
                                        break;
                                case 2: 
                                        System.out.println("Fibonacci series : ");
                                        obj.Fibo_recursive_util(nums);
                                        break;
                                default: 
                                        System.out.println("Invalid Input !!!");
                                        break;
                        }
                
                }
        
        
        }



}
