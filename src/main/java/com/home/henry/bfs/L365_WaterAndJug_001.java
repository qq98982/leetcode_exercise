package com.home.henry.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 365. Water and Jug Problem
 *
 * You are given two jugs with capacities x and y litres. There is an infinite amount of
 * water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within
 * one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first
 * jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 *
 * Input: x = 3, y = 5, z = 4 Output: True Input: x = 2, y = 6, z = 5 Output: False
 *
 * BFS的解决办法
 */
public class L365_WaterAndJug_001 {
    private static class Solution {
        public boolean waterJugProblem(int x, int y, int z) {
            if (x + y < z) { return false; }
            if (z == x || x == y || x == x + y) { return true; }

            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            Queue<State> states = new ArrayDeque<>();
            Set<State> visited = new HashSet<>();

            // initial state
            State init = new State(0, 0);
            states.offer(init);
            visited.add(init);

            while (!states.isEmpty()) {
                State curr = states.poll();
                if (curr.a + curr.b == z) { return true; }

                // fill jug1
                Queue<State> queue = new ArrayDeque<>();
                queue.offer(new State(x, curr.b));      // fill jug 1
                queue.offer(new State(0, curr.b));      // empty jug1
                queue.offer(new State(curr.a, y));      // fill jug 2
                queue.offer(new State(curr.a, 0));      // empty jug2
                queue.offer(new State(Math.min(curr.a + curr.b, x),
                                      curr.a + curr.b < x ? 0 :
                                      curr.b - (x - curr.a)));      // pour all water from jug2 to jug1
                queue.offer(new State(curr.a + curr.b < y ? 0 : curr.a - (y - curr.b),
                                      Math.min(curr.a + curr.b,
                                               y)));                         // pour all water from jug1 to jug2

                for (State tmp : queue) {
                    if (visited.contains(tmp)) { continue; }
                    states.offer(tmp);
                    visited.add(tmp);
                }
            }
            return false;
        }

        private class State {
            public int a, b;

            private State(int a, int b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public int hashCode() {
                return 31 * a + b;
            }

            @Override
            public boolean equals(Object o) {
                State other = (State) o;
                return a == other.a && b == other.b;
            }
        }
    }
}
