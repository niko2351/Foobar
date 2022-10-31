import java.util.ArrayList;
public class Solution{
	public static int solution(int src, int dest){
		if(src < 0 || src>63 || dest<0 || dest >63)
			return 0;
		if(src==0 && dest==7 || src==0 && dest==56 || src==63 && dest==7 || src==63 && dest==56 || dest==0 && src==7 || dest==0 && src==56 || dest==63 && src==7 || dest==63 && src==56)
			return 5;
		int real_src = src, real_dest = dest;
		int steps_1 = 0;
		
		ArrayList<Integer> prev = new ArrayList<Integer>();
		ArrayList<Integer> dist = new ArrayList<Integer>();
		
		while(src != dest){
			dist.clear();
			ArrayList<Integer> moves = possibleMoves(src);
			prev.add(src);
			for(int i=0;i<prev.size();i++){
				moves.remove(prev.get(i));
			}
			for(int i=0;i<moves.size();i++){
				if(moves.get(i)==dest){
					moves.clear();
					dist.clear();
					dist.add(3);
					moves.add(dest);
					break;
				}
				
				
				dist.add(distance(moves.get(i), dest));
			}
			for(int i=0;i<dist.size();i++){
				for(int j=0;j<i;j++){
					if(dist.get(j)>dist.get(i)){
						int t = moves.get(j);
						moves.set(j,moves.get(i));
						moves.set(i,t);
						
						t = dist.get(j);
						dist.set(j,dist.get(i));
						dist.set(i,t);
					}
				}
			}
			if(dist.size()>2){
				for(int i=0;i<dist.size();i++){
					if(dist.get(i)==1){
						dist.remove(i);
						moves.remove(i--);
					}
				}
			}
			if(distance(src,dest)==2){
				ArrayList<Integer> pos = possibleMoves(dest);
				boolean flag = true;
				for(int j=0;j<pos.size();j++){
					if(moves.contains(pos.get(j))){
						flag=false;
						moves.clear();
						moves.add(pos.get(j));
						break;
					}
				}
				if(flag && moves.size()>2){
					moves.remove(0);
					moves.remove(0);
				}
			}
			src = moves.get(0);
			moves.clear();
			steps_1++;
		}
		src=real_dest;
		dest=real_src;
		prev.clear();
		int steps_2 = 0;
		while(src != dest){
			dist.clear();
			ArrayList<Integer> moves = possibleMoves(src);
			prev.add(src);
			for(int i=0;i<prev.size();i++){
				moves.remove(prev.get(i));
			}
			for(int i=0;i<moves.size();i++){
				if(moves.get(i)==dest){
					moves.clear();
					dist.clear();
					dist.add(3);
					moves.add(dest);
					break;
				}
				
				
				dist.add(distance(moves.get(i), dest));
			}
			for(int i=0;i<dist.size();i++){
				for(int j=0;j<i;j++){
					if(dist.get(j)>dist.get(i)){
						int t = moves.get(j);
						moves.set(j,moves.get(i));
						moves.set(i,t);
						
						t = dist.get(j);
						dist.set(j,dist.get(i));
						dist.set(i,t);
					}
				}
			}
			if(dist.size()>2){
				for(int i=0;i<dist.size();i++){
					if(dist.get(i)==1){
						dist.remove(i);
						moves.remove(i--);
					}
				}
			}
			if(distance(src,dest)==2){
				ArrayList<Integer> pos = possibleMoves(dest);
				boolean flag = true;
				for(int j=0;j<pos.size();j++){
					if(moves.contains(pos.get(j))){
						flag=false;
						moves.clear();
						moves.add(pos.get(j));
						break;
					}
				}
				if(flag && moves.size()>2){
					moves.remove(0);
					moves.remove(0);
				}
			}
			src = moves.get(0);
			moves.clear();
			steps_2++;
		}
		prev.clear();
		if(steps_2<steps_1)
			return steps_2;
		return steps_1;
	}
	public static  ArrayList<Integer> possibleMoves(int x){
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int curr = x, _d;
		int[] arr = new int[]{-10,-17,-15,-6,10,17,15,6};
		for(int i=0;i<arr.length;i++){
			_d = distance(x,x+arr[i]);
			if(_d==3)
				moves.add(x+arr[i]);
		}
		return moves;
	}
	public static int distance(int x, int y){
		if(x==y || x<0 || x>63 || y<0 || y>63)
			return 0;
		int dist = 0,
		src = x,
		dest = y;
		while(src%8 > dest%8){
			dist++;
			src--;
		}
		while(src%8 < dest%8){
			dist++;
			src++;
		}
		while(src>dest){
			dist++;
			src-=8;
		}
		while(src<dest){
			dist++;
			src+=8;
		}
		while(src>dest){
			dist++;
			src-=8;
		}
		return dist;
	}
}