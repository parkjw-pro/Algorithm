package com.ssafy;

import java.util.Scanner; 

class GFG { 
  
    static int LCIS(int arr1[], int n, int arr2[], 
                                         int m) 
    {    
        int table[] = new int[501]; 
        int parent[] = new int[501]; 
        for (int j = 0; j < m; j++) {
        	table[j] = 0; 
        }
            
  
        for (int i = 0; i < n; i++) 
        { 
            int current = 0, last = -1; 
  
            for (int j = 0; j < m; j++) 
            { 
                if (arr1[i] == arr2[j]) 
                {    
                    if (current + 1 > table[j]) 
                    { 
                        table[j] = current + 1; 
                        parent[j] = last; 
                    } 
                } 
  
                if (arr1[i] > arr2[j]) 
                { 
                    if (table[j] > current) 
                    { 
                        current = table[j]; 
                        last = j; 
                    } 
                } 
            } 
        } 
  
        int result = 0, index = -1; 
        for (int i = 0; i < 500; i++) 
        { 
            if (table[i] > result) 
            { 
            result = table[i]; 
            index = i; 
            } 
        } 
  
        int lcis[] = new int[result]; 
        
        for (int i = 0; index != -1; i++) 
        { 
            lcis[i] = arr2[index]; 
            index = parent[index]; 
        } 
  
        System.out.println(result);
        for (int i = result - 1; i >= 0; i--) 
            System.out.print(lcis[i] + " "); 
      
        return result; 
    } 
  
    public static void main(String[] args)
    { 
    	Scanner sc = new Scanner(System.in);

        
        
		int N = sc.nextInt();
		int arr1[] = new int[501];
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		
		
		int M = sc.nextInt();
		int arr2[] = new int[501];
		for (int i = 0; i < M; i++) {
			arr2[i] = sc.nextInt();
		}

  
  
        
        LCIS(arr1, N, arr2, M); 
    } 
} 
