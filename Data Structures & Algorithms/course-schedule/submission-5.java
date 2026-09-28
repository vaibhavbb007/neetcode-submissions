class Solution {
    //Kahn's algorithm approach with BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        int[] inDegree = new int[numCourses];
        
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        //creating adjacency lists
        prepareAdjacancy(adjacency, prerequisites, inDegree);
        //BFS to check if any cycle exists.
        return bfsCheck(adjacency, inDegree, numCourses);
    }

    private boolean bfsCheck(Map<Integer, List<Integer>> adjacency, int[] inDegree, int numCourses){

       Queue<Integer> queue = new ArrayDeque<>();
        
        // Add all courses that have NO prerequisites to start the BFS
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCoursesCount = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            processedCoursesCount++; // Successfully took this course

            // Reduce the in-degree of all its neighboring courses
            List<Integer> neighbors = adjacency.get(currentCourse);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    inDegree[neighbor]--;
                    // If all prerequisites for the neighbor are cleared, add to queue
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // If we processed all courses, there is no cycle!
        return processedCoursesCount == numCourses;
    }

    private void prepareAdjacancy(Map<Integer, List<Integer>> adjacency, int[][] prerequisites, int[] inDegree){
        
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
           // To take 'course', you must take 'prereq' first (prereq -> course)
            adjacency.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);
            
            // 'course' has one more prerequisite
            inDegree[course]++;
        }
    }
}
