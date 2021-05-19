package July;

public class AddDigits {

	public static void main(String[] args) {
		
	}

	public static int addDigits(int num) {
		while (num > 9) {
			int Sum = 0;
			while (num != 0) {
				Sum += num % 10;
				num = num / 10;
			}
			num = Sum;
		}
		return num;
	}

	int addDigitsOptmized(int num) {
        if(num==0) return 0;
        
        return (num %9 !=0)? num%9 :9;
    }
	
}
