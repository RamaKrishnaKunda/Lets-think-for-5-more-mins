/*
    Q: 
        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
        Return the answer in any order.A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    Constraints: 
        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].

*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: (4^(digits.length))
        Desc: Same as permutations problem
    */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        getCombinations(digits.toCharArray(), map, res, 0);
        return res;
    }
    public void getCombinations(char digits[],Map<Character, String> map, List<String>res, int pos) {
        if(pos>=digits.length){
            res.add(new String(digits));
            return;
        }
        String s = map.get(digits[pos]);
        for(int i=0;i<s.length();i++){
            char c = digits[pos];
            digits[pos] = s.charAt(i);
            getCombinations(digits, map, res, pos+1);
            digits[pos]=c;
        }
    }
}