import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		// 如果是"",则是有效字符串
		if ("".equals(s) || s == null) {
			return true;
		}

		// 将字符串转换为字符数组
		char[] chars = s.toCharArray();

		// 定义字符栈
		Stack<Character> charStack = new Stack<Character>();

		// 循环遍历字符数组
		for (int i = 0; i < chars.length; i++) {
			// 如果字符是'(','[','{',直接入栈
			if (isStartChar(chars[i])) {
				// 入栈
				charStack.push(chars[i]);

			} else {
				// 如果字符是')',']','}'
				// 如果栈为空，则是无效字符
				if (charStack.empty()) {
					return false;
				}
				// 栈不为空,取出栈定元素，判断跟当前字符是匹配,不匹配返回false
				char topChar = charStack.pop();
				if (!isMatch(topChar, chars[i])) {
					return false;
				} else {
					// 匹配，跳出本次循环
					continue;
				}
			}

		}
		// 循环完毕，字符栈不为空，则返回无效
		return charStack.empty() ? true : false;
	}

	public boolean isEndChar(char c) {
		if (c == ')' || c == ']' || c == '}') {
			return true;
		}
		return false;
	}

	public boolean isStartChar(char c) {
		if (c == '(' || c == '[' || c == '{') {
			return true;
		}
		return false;
	}

	/**
	 * 判断括号是否匹配
	 */
	public boolean isMatch(char leftChar, char rigthChar) {
		if (leftChar == '(' && rigthChar == ')') {
			return true;
		} else if (leftChar == '[' && rigthChar == ']') {
			return true;
		} else if (leftChar == '{' && rigthChar == '}') {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		String str = "(]";
		Solution s = new Solution();
		System.out.println(s.isValid(str));
	}
}