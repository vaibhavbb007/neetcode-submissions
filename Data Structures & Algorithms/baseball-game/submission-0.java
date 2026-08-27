class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if ("+".equalsIgnoreCase(op)) {
                addNumbers(stack);
            } else if ("C".equalsIgnoreCase(op)) {
                discardLastNumber(stack);
            } else if ("D".equalsIgnoreCase(op)) {
                doubleLastNumber(stack);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        Integer sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + (Integer) stack.pop();
        }
        return sum;
    }

    private void doubleLastNumber(Stack<Integer> stack) {
        Integer lastNumber = (Integer) stack.pop();
        Integer newNumber = lastNumber * 2;
        stack.push(lastNumber);
        stack.push(newNumber);

    }

    private void discardLastNumber(Stack<Integer> stack) {
        stack.pop();
    }

    private void addNumbers(Stack<Integer> stack) {
        Integer num2 = (Integer) stack.pop();
        Integer num1 = (Integer) stack.pop();
        Integer num3 = num1 + num2;
        stack.push(num1);
        stack.push(num2);
        stack.push(num3);
    }
}