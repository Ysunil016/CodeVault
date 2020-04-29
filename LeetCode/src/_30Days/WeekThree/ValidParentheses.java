package _30Days.WeekThree;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(checkValidString("((*((()))"));
	}

	public static boolean checkValidString(String s) {
		char[] arr = s.toCharArray();

		int leftCount = 0;
		int rightCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ')')
				leftCount--;
			else
				leftCount++;
			if(leftCount<0)
				return false;
		}
		if(leftCount==0)
			return true;

		for (int i = arr.length-1; i >=0; i--) {
			if (arr[i] == '(')
				rightCount--;
			else
				rightCount++;
			if(rightCount<0)
				return false;
		}
		if(rightCount==0)
			return true;


		return true;
	}

}
