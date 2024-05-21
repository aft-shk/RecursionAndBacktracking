package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String name = "omkar";
        int n = 5;
        printNameNTimes("omkar",n);
        print1ToN(1,10);
        System.out.println();
        printNTo1(1,10);
        System.out.println();
        sumOfFirstNNumbers(10,0);
        System.out.println(sumInFunctionalWay(10));
        System.out.println(factorial(5));
        System.out.println(fibonacciNthNumber(4));
        System.out.println("Recursion");
        int arr [] = {1,2,3,4,5,6};
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<LinkedList<Integer>> ans = new ArrayList<>();
        subsequencesUsingRecursion(0,list,arr,arr.length,ans);
        System.out.println(ans);
        LinkedList<Integer> list1 = new LinkedList<>();
        ArrayList<LinkedList<Integer>> ans1 = new ArrayList<>();
        subsequencesUsingRecursionSum(0,list1,arr,7,ans1,0);
        System.out.println(ans1);
    }


    public static void printNameNTimes(String name, int n){
        if(n==0)return;
        System.out.println(name);
        printNameNTimes(name,n-1);
    }

    public static void print1ToN(int start , int end){
        if(start == end+1)return;;
        System.out.print(start+" ");
        print1ToN(start+1,end);
    }

    public static void printNTo1(int start , int end){
        if(start>end)return;
        System.out.print(end+" ");
        printNTo1(start,end-1);
    }


    public static void sumOfFirstNNumbers(int end,int sum){
        if(end==0){
            System.out.println(sum);
            return ;
        }
        sum+=end;
        sumOfFirstNNumbers(end-1,sum);
    }

    public static int sumInFunctionalWay(int end){
        if(end == 1){
            return 1;
        }
        return end + sumInFunctionalWay(end-1);
    }

    public static int factorial(int end){
        if(end == 1)return 1;
        return end * factorial(end-1);
    }

    public static int fibonacciNthNumber(int n){
        if(n<=1)return n;
        return fibonacciNthNumber(n-1)+fibonacciNthNumber(n-2);
    }


    private static ArrayList<LinkedList<Integer>> subsequencesUsingRecursion(int index, LinkedList<Integer> list, int[] arr, int end, ArrayList<LinkedList<Integer>> ans) {
        if(end==index){
            ans.add(new LinkedList<>(list));
            return ans;
        }
        list.add(arr[index]);
        subsequencesUsingRecursion(index+1,list,arr,end, ans);
        list.removeLast();
        subsequencesUsingRecursion(index+1, list, arr, end, ans);
        return ans;
    }

    public static ArrayList<LinkedList<Integer>> subsequencesUsingRecursionSum(int index, LinkedList<Integer> list, int[] arr, int desiredSum, ArrayList<LinkedList<Integer>> ans,int sum) {
        if(index==arr.length){
            if(sum==desiredSum){
                ans.add(new LinkedList<>(list));
                return ans;
            }
            return ans;
        }
        list.add(arr[index]);
        subsequencesUsingRecursionSum(index+1,list,arr,desiredSum,ans,sum+arr[index]);
        list.removeLast();
        subsequencesUsingRecursionSum(index+1,list,arr,desiredSum,ans,sum);
        return ans;
    }


}