'''
	Q:  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	    An input string is valid if:
		1. Open brackets must be closed by the same type of brackets.
		2. Open brackets must be closed in the correct order.

	Constraints: 
	1 <= s.length <= 10^4
	s consists of parentheses only '()[]{}'

	Source: leetcode
'''
class Solution:
	'''
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(n)
		Desc: Use a stack for pushing open braces. Once closing brace is found compare and pop. If comparision fails
		return False.
	'''
    def isValid(self, s: str) -> bool:
        open_para = {'(', '{', '['}
        close_para = {')', '}', ']'}
        mapping = {'(': ')', '{': '}', '[': ']'}
        stack = []
        for para in s:
            if para in open_para:
                stack.append(para)
                continue
            elif para in close_para:
                if len(stack) > 0 and mapping[stack[-1]] == para:
                    stack.pop()
                else:
                    return False
        if len(stack) > 0:
            return False
        return True