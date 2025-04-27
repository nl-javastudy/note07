package study.w2;

public class StringRepeat {
    public static void main(String[] args){
        String first = args[0];
        int second = Integer.parseInt(args[1]);
        System.out.println(first.length());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < first.length(); i++){
            answer.append(Character.toString(first.charAt(i)).repeat(second));
        }

        System.out.println(answer);

    }
}