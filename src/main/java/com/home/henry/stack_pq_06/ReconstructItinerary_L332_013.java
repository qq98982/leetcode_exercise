package com.home.henry.stack_pq_06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 332. Reconstruct Itinerary
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],reconstruct
 * the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
 * First keep going forward until you get stuck. That's a good main path already. Remaining tickets form cycles
 * which are found on the way back and get merged into that main path. By writing down the path backwards when
 * retreating from recursion, merging the cycles into the main path is easy - the end part of the path has
 * already been written, the start part of the path hasn't been written yet, so just write down the cycle now
 * and then keep backwards-writing the path.
 */
public class ReconstructItinerary_L332_013 {

    private Map<String, PriorityQueue<String>> targets = new HashMap<>();

    private List<String> route = new LinkedList<>();

    // 放入到map中, value是一个priority queue
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        visit("JFK");
        return route;
    }

    private void visit(String airPort) {
        // 有起点, 并且终点不为空
        while (targets.containsKey(airPort) && !targets.get(airPort).isEmpty()) {
            // poll出排序最小的(pq)
            visit(targets.get(airPort).poll());
        }
        // 加到最前面, 也是用LinkedList的原因
        route.add(0, airPort);
    }

    // stack 非递归版本
    public List<String> findItineraryStack(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets) {
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        }
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }
        return route;
    }

}
