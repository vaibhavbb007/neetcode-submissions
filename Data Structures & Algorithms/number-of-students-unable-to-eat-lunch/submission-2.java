private static class StudentNode {
    int preference;
    StudentNode nextStudent;

    StudentNode(int preference) {
        this.preference = preference;
    }
}

class Solution {
    
    public int countStudents(int[] students, int[] sandwiches) {

        if(students.length == 0){
            return 0;
        }

        if(students.length == 1){
            if(students[0] == sandwiches[0]){
                return 0;
            }else {
                return 1;
            }
        }

        int size = 1;

        Stack<Integer> sandwichesStack = new Stack<>();

        StudentNode student = new StudentNode(students[0]);
        StudentNode head = student;
        StudentNode tail = student;

        for (int i = 1; i < students.length; i++) {
            StudentNode newStudentNode = new StudentNode(students[i]);
            student.nextStudent = newStudentNode;
            student = newStudentNode;
            tail = newStudentNode;
            size++;
        }

        tail.nextStudent = null;

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichesStack.push(sandwiches[i]);
        }
        System.out.println(sandwichesStack);
        int counter = 0;

        StudentNode current = head;
        while (current != null) {
            if (!sandwichesStack.isEmpty() && current.preference == sandwichesStack.peek()) {
                head = dequeue(head);
                size--;
                sandwichesStack.pop();
                counter = 0;
            } else {
                head = dequeue(head);
                tail = enqueue(current, tail);
                counter++;
                if (counter == size) {
                    break;
                }

            }

            current = head;
        }
        return size;
    }

    private StudentNode enqueue(StudentNode node, StudentNode tail) {
        tail.nextStudent = node;
        tail = node;
        node.nextStudent = null;
        return tail;
    }

    private StudentNode dequeue(StudentNode head) {
        head = head.nextStudent;
        return head;
    }
}