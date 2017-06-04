package arrayProblems;

import java.util.Arrays;
import java.util.LinkedList;

//
//在一个整型数组arr中，有大小为w的窗口从左滑到右，每次一个位置，求每个窗口最大值数组
public class GetMaxWindow {
	
	public static void main(String[] args) {
		GetMaxWindow gM=new GetMaxWindow();
		int[] a={3,456,76,3,2,2,778,98,564,54,46,36,2,6,678};
		int[] b=gM.getMaxWindow(a, 4);
		System.out.println(Arrays.toString(b));
	}
	public int[] getMaxWindow(int[] arr,int w){
		if(arr==null||w<1||arr.length<w){
			return null;
		}
		LinkedList<Integer> qmax=new LinkedList<>();
		int[] res=new int[arr.length-w+1];
		int index=0;
		for(int i=0;i<arr.length;i++){
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w){
				qmax.pollFirst();
			}
			if(i>=w-1){
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
