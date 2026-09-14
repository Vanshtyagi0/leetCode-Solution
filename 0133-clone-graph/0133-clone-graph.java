/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        List<Node> visited = new ArrayList<>();


        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();            
            List<Node> list = curr.neighbors;

            if(!map.containsKey(curr.val)){
                map.put(curr.val, new Node(curr.val));
            }

            List<Node> currNodeNeighbors = map.get(curr.val).neighbors;
            for(Node neighbor : list){
                if(!map.containsKey(neighbor.val)){
                    map.put(neighbor.val, new Node(neighbor.val));
                }

                Node copyNeighbor = map.get(neighbor.val);
                currNodeNeighbors.add(copyNeighbor);
            }

            for(Node neighbor : list){
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return map.get(node.val);
    }
}