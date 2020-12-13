/*
	Q; Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix,
	   return an empty string "".

	Constraints:
	0 <= strs.length <= 200
	0 <= strs[i].length <= 200
	strs[i] consists of only lower-case English letters.

	Source: leetcode
*/

public String longestCommonPrefix(String[] strs) {
	/*
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(S), where S are the total no.of charaters in the array
		Desc: Take first string as base and compare with other strings. If found any dissimilarity at strat return
			  empty string, else store index until where they are similar upto.
	*/
    if(strs.length == 0)
        return "";
    if(strs.length == 1)
        return strs[0];
    String base = strs[0];
    int maxIdx = 999999;
    for(int j = 1; j < strs.length; j++){
        int k = 0;
        int i = 0;
        int idx = 0;
        String lookUpString = strs[j];
        while(i < base.length() && k < lookUpString.length()){
            if(i == 0 && (base.charAt(i) != lookUpString.charAt(k)))
                return "";
            if(base.charAt(i) == lookUpString.charAt(k))
                idx++;
            else
                break;
            i++;
            k++;
        }
        if(maxIdx > idx)
            maxIdx = i;
    }
    String result = "";
    for(int h = 0; h < base.length() && h < maxIdx; h++){
        result += base.charAt(h);
    }
        return result;
}