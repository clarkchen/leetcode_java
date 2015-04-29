package GasStation;

public class Solution {
	int N;
	int gas[],cost[];
	boolean first;
	int remain;
	int T(int i, int start)
	{
		if(!first && i==start) return start;
		remain = gas[i]+ remain - cost[i];
		if(remain<0) return i;
		if(first) first = false;
		return T((i+1) % N, start);
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		 if(gas.length==1) return gas[0]>=cost[0]?0:-1; 
		 this.gas = gas;
		 this.cost = cost;
		 N =  gas.length;
		 int i = 0;
		 int c= 0;
		 while(c<N)
		 {
			 remain = 0;
			 first = true;
			 int temp = T(i,i);
			 if(!first && temp==i) return i;
			 if(temp<i) break;
			 if(first) c+=1;
			 else c+=temp-i+1;
			 i = temp+1;
		 }
		 return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		int gas[] = new int[]{1,2,3,3};
		int cost[] = new int[]{2,1,5,1};
		  gas = new int[]{2,4};
		  cost = new int[]{3,4};
		  gas = new int[]{1,2};
		  cost = new int[]{2,1};
		System.out.println(s.canCompleteCircuit(gas, cost));
	}

}
