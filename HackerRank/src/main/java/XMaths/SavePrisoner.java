package XMaths;

public class SavePrisoner {

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(7,19,2));
    }

    static int saveThePrisoner(int n, int m, int s) {
        while((s-1) < n) {
            m--;
            s++;
        }
        m %= n;

        if(m==0)
            return n;

        int index = 1;
        while(m!=0){
            m--;
            index %= n;
        }

       return index;
    }


}
