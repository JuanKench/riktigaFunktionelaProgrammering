public class MathOperationMain {

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
    private static int opperate (int a, singleDidgitOperation singleDidgitOperation) {
        return singleDidgitOperation.oppperate(a);
    }

    public static void main(String args[]) {

      MathOperation addition = (a, b) -> a + b;

      MathOperation subtraction =  (a, b) -> a - b;

      MathOperation multiplication = (a, b) -> a * b;

      MathOperation division = (a, b) -> a / b;

      MathOperation combinedAdd = (a, b) -> a + b;

      MathOperation combinedMultiplication = (a, b) -> a * b;

      singleDidgitOperation toThePowerOfTwo = (a) -> a * a;
      singleDidgitOperation checkIfPosetive = a -> {if (a >= 0) return 1; else return 0;};

      System.out.println("10 + 5 = " + operate(10, 5, addition));
      System.out.println("10 - 5 = " + operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + operate(10, 5, division));
      System.out.println("10 + 5 + (10 * 5) = " + operate(10, 5, combinedAdd));
      System.out.println("(10 + 5) * (10 * 5) = " + operate(10, 5, combinedMultiplication));
      System.out.println(opperate(10, toThePowerOfTwo));
      System.out.println(opperate(10, checkIfPosetive));

    }
}