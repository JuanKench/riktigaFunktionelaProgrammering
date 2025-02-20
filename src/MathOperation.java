public interface MathOperation {
    int operation(int a, int b);

    default MathOperation combineWithAddition(MathOperation other) {
        return (a, b) -> this.operation(a, b) + other.operation(a, b);
    }
    default MathOperation combineWithMultiplication(MathOperation other) {
        return (a, b) -> this.operation(a, b) * other.operation(a, b);
    }
}