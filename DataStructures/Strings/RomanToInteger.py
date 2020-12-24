'''
    Question: Convert Roman number to Integer

    Constraints:
        1 <= s.length <= 15
        s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
        It is guaranteed that s is a valid roman numeral in the range [1, 3999].

    Source: leetcode
'''

class Solution:
    def romanToInt(self, s: str) -> int:
        '''
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Maintain a mapping of basic roman to integer. Do subtraction of i+1 and i if number at i+1 greater than
            number at i.
        '''
        subLeft = 'IXC'
        subRight = 'VXLCDM'
        mapping = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        i = 0
        result = 0
        while i < len(s):
            if i+1 < len(s) and mapping[s[i]] < mapping[s[i+1]]:
                result += (mapping[s[i+1]] - mapping[s[i]])
                i = i + 2
                continue
            result += mapping[s[i]]
            i+=1
        return result