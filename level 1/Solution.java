import java.util.*;

public class Solution{
	public static void main(String[] args){
		int x[] = new int[]{14, 27, 1, 4, 2, 50, 3, 1},
		y[] = new int[]{2, 4, 51, 3, 1, 1, 14, 27, 50};
		System.out.println(solution(x,y));
	}
	public static int solution(int[] x, int[] y){
		sort(x);
		sort(y);
		for(int i=0;i<x.length && i<y.length;i++){
			if(x[i]!=y[i]){
				if(x.length>y.length)
					return x[i];
				return y[i];
			}
		}
		if(x.length>y.length)
			return x[y.length];
		return y[x.length];
	}
	public static void sort(int[] arr){
		int t=1;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]<arr[j]){
					t=arr[j];
					arr[j]=arr[i];
					arr[i]=t;
				}
			}
		}
	}
}