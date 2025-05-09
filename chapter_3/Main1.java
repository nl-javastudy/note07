package chapter_3;

// 사용자 정의 체크 예외 (Checked Exception)
class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}

// 사용자 정의 언체크 예외 (Unchecked Exception)
class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

public class Main1 {

    // 체크 예외를 던지는 메서드 → 반드시 throws 선언 필요
    public static void throwChecked() throws MyCheckedException {
        throw new MyCheckedException("체크 예외 발생!");
    }

    // 언체크 예외를 던지는 메서드 → throws 생략 가능
    public static void throwUnchecked() {
        throw new MyUncheckedException("언체크 예외 발생!");
    }

    public static void main(String[] args) {
        // 체크 예외는 반드시 try-catch 또는 throws 처리해야 함
        try {
            throwChecked();
        } catch (MyCheckedException e) {
            System.out.println("체크 예외 처리됨: " + e.getMessage());
        }

        // 언체크 예외는 try-catch 없이도 컴파일 가능
        try {
            throwUnchecked();
        } catch (MyUncheckedException e) {
            System.out.println("언체크 예외 처리됨: " + e.getMessage());
        }
    }
}

