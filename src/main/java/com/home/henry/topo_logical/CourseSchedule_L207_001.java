package com.home.henry.topo_logical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 * 返回课程能否没有依赖而能全部完成
 * GRAPH, DFS, BFS都可以, 据说BFS更好, 但是BFS是33ms, DFS是2ms
 */
public class CourseSchedule_L207_001 {

    static class SolutionDFS {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // create the array lists to represent the courses
            List<List<Integer>> courses = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                courses.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, courses, visited)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
            // mark it being visited
            visited[course] = 1;

            // get its children
            List<Integer> eligibleCourses = courses.get(course);

            // dfs its children
            for (int i = 0; i < eligibleCourses.size(); i++) {
                int eligibleCourse = eligibleCourses.get(i);
                // has been visited while visiting its children - cycle !!!!
                if (visited[eligibleCourse] == 1) {
                    return false;
                }
                // not visited
                if (visited[eligibleCourse] == 0) {
                    if (!dfs(eligibleCourse, courses, visited)) {
                        return false;
                    }
                }
            }
            // mark it done visiting
            visited[course] = 2;
            return true;
        }
    }

    static class SolutionBFS {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                indegree[prerequisites[i][1]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i=0; i < indegree.length;i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                numCourses--;
                int course = queue.poll();
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][0] == course) {
                        indegree[prerequisites[i][1]]--;
                        if (indegree[prerequisites[i][1]] == 0) {
                            queue.add(prerequisites[i][1]);
                        }
                    }
                }
            }
            return numCourses == 0;
        }
    }
}
