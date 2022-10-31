import java.lang.Math;
public class Solution{
	/* 
	This solution worked on 6 out of 10 test cases.
	I figured this was because I was trying to brute force my way to a solution.
	Solving usig linear algebraic expressions worked for 5 out of 10 test cases,
	and I figured the problem may have been complicated by use of irrational
	decimals and the notorius rational decimal (pi).
	*/
	public static int[] solution(int[] pegs){
		int[] ret = new int[]{-1,-1};
		double sum = 0;
		
		for(int i=0;i<pegs.length-1;i++){
			if(i%2==0)
				sum += pegs[i+1] - pegs[i];
			else
				sum += -1*(pegs[i+1] - pegs[i]);
		}
		
		if(pegs.length%2 == 0)
			sum = sum/3;

		if(sum < 1)
			return ret;
		else{
			sum*=2;
			double tol=1.0E-6;
			int minNumerator = (int) Math.floor(sum);
			int minDenominator = 1;
			int maxNumerator = (int) Math.ceil(sum);
			int maxDenominator = 1;
			
			double approximateFloatingNumber;
			int approximateFloatingNumberNumerator;
			int approximateFloatingNumberDenominator;
			
			do{
				approximateFloatingNumberNumerator = minNumerator + maxNumerator;
				approximateFloatingNumberDenominator = minDenominator + maxDenominator;
				approximateFloatingNumber = (double) approximateFloatingNumberNumerator/approximateFloatingNumberDenominator;
				if(approximateFloatingNumber > sum){
					maxNumerator = approximateFloatingNumberNumerator;
					maxDenominator = approximateFloatingNumberDenominator;
				}
				else{
					minNumerator = approximateFloatingNumberDenominator;
					minDenominator = approximateFloatingNumberDenominator;
				}
			}while(Math.abs(approximateFloatingNumber - sum)>tol);
			int _gcd = gcd(approximateFloatingNumberNumerator,approximateFloatingNumberDenominator);
			ret[0]=approximateFloatingNumberNumerator/_gcd;
			ret[1]=approximateFloatingNumberDenominator/_gcd;
			return ret;
		}
	}
	public static int gcd(int a, int b){
		int x = 1;
		for(int i=1;i<=a && i<=b;i++){
			if(a%i==0 && b%i==0)
				x=i;
		}
		return x;
	}
}