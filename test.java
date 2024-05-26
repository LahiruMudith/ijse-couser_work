import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] ar = {10,20,30,40};

        System.out.println(Arrays.toString(ar));
        System.out.println(ar.length);

        ar = grow(ar);
        System.out.println(Arrays.toString(ar));
        System.out.println(ar.length);
    }

    public static int[] grow(int[] ar) {
        int temp[] = new int[ar.length+1];

        for (int i = 0; i <ar.length ; i++) {
            temp[i] = ar[i];
        }
        return temp;
    }
}
