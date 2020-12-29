/*
    Q: 
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Constraints: 
        1 <= n <= 8
*/
class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: 2^(2n)
        Desc: Use binary format from minnum to maxnum. 0 represents '(' and 1 represents ')'. Check if number in binary format is forming valid parenthesis or not 
    */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if(n==1){
            res.add("()");
            return res;
        }
        int min = (1<<n)-1; // first number to have n numbers of zeros and n number of one's(in binary format)
        int max = (1<<(n*2))-min-1; // last number to have n numbers of zeros and n number of one's(in binary format)
        for(int i=min;i<=max;i++){
            int pat[]=new int[2*n];
            char combination[]=new char[2*n];
            int zeroCount=0;
            int oneCount=0;
            for(int j=0;j<2*n;j++){
                if(((i>>j)&1)==1){
                    pat[j]=1;
                    combination[2*n-j-1]='(';
                    oneCount++;
                }
                else{
                    pat[j]=0;
                    combination[2*n-j-1]=')';
                    zeroCount++;
                }
            }
            if(oneCount==zeroCount && isValidParenthesis(pat)){
                res.add(new String(combination));
            }
        }
        return res;
    }
    public boolean isValidParenthesis(int pat[]) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<pat.length;i++) {
            if(pat[i]==0)
                stack.add(pat[i]);
            else{
                if(!stack.isEmpty() && stack.getLast()==0)
                    stack.removeLast();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis2(int n) {
    	/*
    		Solution-2
			Author: RamaKrishnaKunda
			TimeComplexity: 2^(2n)
			Desc: Use DFS algorithm. Initialize open and close to 0. They will go upto n. Add ( until open is
			less than n. Once done until close is less tha open, append ). Perform this in recurssive fassion.
    	*/
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "",  n, 0, 0);
        return result;
    }

    public void generateParenthesis(List<String> result, String comb, int max, int open, int close){
        if(comb.length() == max * 2){
            result.add(comb);
            return;
        }
        if(open < max)
            generateParenthesis(result, comb + "(", max, open + 1, close);
        if(close < open)
            generateParenthesis(result, comb + ")", max, open, close + 1);
    }
}


