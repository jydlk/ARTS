import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		// �����"",������Ч�ַ���
		if ("".equals(s) || s == null) {
			return true;
		}

		// ���ַ���ת��Ϊ�ַ�����
		char[] chars = s.toCharArray();

		// �����ַ�ջ
		Stack<Character> charStack = new Stack<Character>();

		// ѭ�������ַ�����
		for (int i = 0; i < chars.length; i++) {
			// ����ַ���'(','[','{',ֱ����ջ
			if (isStartChar(chars[i])) {
				// ��ջ
				charStack.push(chars[i]);

			} else {
				// ����ַ���')',']','}'
				// ���ջΪ�գ�������Ч�ַ�
				if (charStack.empty()) {
					return false;
				}
				// ջ��Ϊ��,ȡ��ջ��Ԫ�أ��жϸ���ǰ�ַ���ƥ��,��ƥ�䷵��false
				char topChar = charStack.pop();
				if (!isMatch(topChar, chars[i])) {
					return false;
				} else {
					// ƥ�䣬��������ѭ��
					continue;
				}
			}

		}
		// ѭ����ϣ��ַ�ջ��Ϊ�գ��򷵻���Ч
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
	 * �ж������Ƿ�ƥ��
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