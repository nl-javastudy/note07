package study.w2;
import java.util.Arrays;

public class IcedAmericano{
    public static void main(String[] args){
        int intArg = Integer.parseInt(args[0]);

        int cups = intArg / 5500;
        int change = intArg % 5500;

        int[] answer = {cups, change};
        System.out.println(Arrays.toString(answer));
    }
}