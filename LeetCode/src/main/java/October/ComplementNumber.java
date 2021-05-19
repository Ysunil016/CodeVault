package October;

public class ComplementNumber {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(10));
    }

    public static int bitwiseComplement(int N) {
        return N ^ Integer.parseInt("1".repeat(Integer.toBinaryString(N).length()), 2);
    }
}
