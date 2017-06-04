package hanoiProblem1;

import java.util.Stack;

//hanoi塔修改版，限制游戏规则为不能从左直接到右
public class HanoiProblem1 {
	public static void main(String[] args) {
		String left="left";
		String mid="mid";
		String right="right";
		HanoiProblem1 han=new HanoiProblem1();
		long start=System.currentTimeMillis();
		int num=han.hanoiProblem1(12,left,mid,right);
		long end=System.currentTimeMillis();
		System.out.println(num+" steps");
		System.out.println((end-start)+" milliseconds");
	}
	public int hanoiProblem1(int num,String left,String mid,String right){
		Stack<Integer> lStack=new Stack<Integer>();
		Stack<Integer> mStack=new Stack<>();
		Stack<Integer> rStack=new Stack<>();
		lStack.push(Integer.MAX_VALUE);
		mStack.push(Integer.MAX_VALUE);
		rStack.push(Integer.MAX_VALUE);
		for(int i=num;i>0;i--){
			lStack.push(i);
		}
		Action[] record={Action.No};
		int step=0;
		while(rStack.size()!=num+1){
			step+=fStackTotStack(record, Action.MToL, Action.LToM, lStack, mStack, left, mid);
			step+=fStackTotStack(record, Action.LToM, Action.MToL, mStack, lStack, mid, left);
			step+=fStackTotStack(record, Action.RToM, Action.MToR, mStack, rStack, mid, right);
			step+=fStackTotStack(record, Action.MToR, Action.RToM, rStack, mStack, right, mid);
		}
		return step;
	}
	
	public static int fStackTotStack(Action[] record,Action preNoAct,Action nowAct,
			Stack<Integer> fStack,Stack<Integer> tStack,String from,String to){
		
		if(record[0]!=preNoAct && fStack.peek()<tStack.peek()){
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+from+" to "+to);
			record[0]=nowAct;
			return 1;
		}
		return 0;
	}
}
