class Solution {
    static class Node {
        int prod;
        long[] count;

        Node(int k) {
            count = new long[k];
            prod = 1 % k;
        }
    }

    private Node[] tree;
    private int[] nums;
    private int n;
    private int k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.nums = nums;
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Query nums[start ... n-1]
            Node node = query(1, 0, n - 1, start, n - 1);

            result[q] = (int)node.count[x];
        }

        return result;
    }

    // ---------------------------------------------------
    // Build
    // ---------------------------------------------------

    private void build(int node, int left, int right) {

        if (left == right) {

            tree[node] = new Node(k);

            int remainder = nums[left] % k;

            tree[node].prod = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // ---------------------------------------------------
    // Point Update
    // ---------------------------------------------------

    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            tree[node] = new Node(k);

            int remainder = value % k;

            tree[node].prod = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(
                node * 2,
                left,
                mid,
                index,
                value
            );
        } else {
            update(
                node * 2 + 1,
                mid + 1,
                right,
                index,
                value
            );
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // ---------------------------------------------------
    // Range Query
    // ---------------------------------------------------

    private Node query(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {

        // Completely inside
        if (
            queryLeft <= left &&
            right <= queryRight
        ) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        // Entirely in left child
        if (queryRight <= mid) {
            return query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );
        }

        // Entirely in right child
        if (queryLeft > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );
        }

        // Split across both children
        Node leftNode = query(
            node * 2,
            left,
            mid,
            queryLeft,
            queryRight
        );

        Node rightNode = query(
            node * 2 + 1,
            mid + 1,
            right,
            queryLeft,
            queryRight
        );

        return merge(leftNode, rightNode);
    }

    // ---------------------------------------------------
    // Merge two adjacent segments
    // ---------------------------------------------------

    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        result.prod =
            (int) ((long) left.prod * right.prod % k);

        // Prefixes completely inside left segment
        for (int r = 0; r < k; r++) {
            result.count[r] += left.count[r];
        }

        // Prefixes containing entire left +
        // a prefix of right
        for (int r = 0; r < k; r++) {

            int newRemainder =
                (int) ((long) left.prod * r % k);

            result.count[newRemainder]
                += right.count[r];
        }

        return result;
    }
}