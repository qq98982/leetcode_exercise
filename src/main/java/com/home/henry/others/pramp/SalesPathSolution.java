package com.home.henry.others.pramp;

class SalesPathSolution {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        static int getCheapestCost(Node rootNode) {
            // find every path and sum it
            // compare and find the minimum value and return
            // start point is root, find children till null
            // root -> no1
            int min = Integer.MAX_VALUE;
            if (rootNode.children == null) {return rootNode.cost;}
            for (int i = 0; i < rootNode.children.length; i++) {
                min = Math.min(getCheapestCost(rootNode.children[i]), min);
            }
            return min + rootNode.cost;
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);

        Node n1 = new Node(5);
        Node n4 = new Node(4);
        n1.children = new Node[] { n4 };

        Node n2 = new Node(3);
        Node n5 = new Node(2);

        Node n7 = new Node(1);
        n5.children = new Node[] { n7 };

        Node n8 = new Node(1);
        n7.children = new Node[] { n8 };

        Node n6 = new Node(0);

        Node n9 = new Node(10);
        n6.children = new Node[] { n9 };

        n2.children = new Node[] { n5, n6 };

        Node n3 = new Node(6);
        Node n10 = new Node(1);
        Node n11 = new Node(5);
        n3.children = new Node[] { n10, n11 };

        root.children = new Node[] { n1, n2, n3 };
        System.out.println(SalesPath.getCheapestCost(root));
    }
}