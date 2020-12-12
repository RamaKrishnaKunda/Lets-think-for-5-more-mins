import java.util.LinkedList;

public class NextSmaller {

	public static void main(String[] args) {
		int result[] = nextSmaller(new int[]{5,3,8,20,11,-1,1,8});
		for(int i=0;i<result.length;i++)
			System.out.print(result[i] + " ");

    }
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: O(n)
        Desc: Maintain stack of relevant elements. For each element a[i] for elements in stack > a[i] => pop from stack
        If stack is empty then it doesnot have smaller element. 
    */
	public static int[] nextSmaller(int[] array) {
		LinkedList<Integer> stack = new LinkedList<>();
		int n = array.length;
		int[] output = new int[array.length];
		//PreCalculations
		output[n-1] = array[n-1];
		stack.add(array[n-1]);
		
		for(int i=n-2;i>=0;i--) {
			while(!stack.isEmpty() && stack.getLast()>array[i]) {
				stack.removeLast();
			}
			if(!stack.isEmpty())
				output[i]=stack.getLast();
			else
				output[i]=array[i];
			stack.add(array[i]);
		}
		return output;
	}

}
