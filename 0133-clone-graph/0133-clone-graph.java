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

        queue.offer(node);
        map.put(node.val, new Node(node.val));

        
        while(!queue.isEmpty()){
            Node curr = queue.poll();            
            List<Node> list = curr.neighbors;


            List<Node> copyNodeNeighbors = map.get(curr.val).neighbors;
            for(Node neighbor : list){
                if(!map.containsKey(neighbor.val)){
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                Node copyNeighbor = map.get(neighbor.val);
                copyNodeNeighbors.add(copyNeighbor);
            }
        }

        return map.get(node.val);
    }
}