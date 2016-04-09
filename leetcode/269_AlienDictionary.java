public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
	boolean visited[] = new boolean[26];
	boolean isCycle = false;
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return new String();
        List<List<Integer>> adj = new ArrayList<List<Integer>>(26);
        for(int i = 0; i<26;i++) adj.add(new ArrayList<Integer>());
        Set<Character> letters = new HashSet<Character>();
        int size = words.length;
        for(String word : words) {
            char[] charArray = word.toCharArray();
            for(char c : charArray) letters.add(c);
        }
        for(int i = 0; i<size; i++){
            for(int j = i+1; j<size; j++){
                int diff = compareWords(words[i], words[j]);//the first place where letters are different
                if(diff == -1) continue;
                int pre = words[i].charAt(diff) - 'a';
                int post = words[j].charAt(diff) - 'a';
                adj.get(pre).add(post);
            }
        }
        for(int i = 0; i< adj.size(); i++){
            //List<Integer> list = adj.get(i);
            if(!adj.get(i).isEmpty()){
                dfs(adj, i);
                if(isCycle == true) return new String();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char letter =(char) (stack.pop() + 'a');
            sb.append(letter);
            letters.remove(letter);
        }
        if(!letters.isEmpty()){
            for(char c : letters) sb.append(c);
        }
        return sb.toString();
    }
    private void dfs(List<List<Integer>> adj, int node){
        if(visited[node] == true) return;
        visited[node] = true;
        List<Integer> list = adj.get(node);
        if(list.isEmpty()){
            push(node);
            return;
        }
        for(Integer i : list){
            if(adj.get(i).contains(node)) {
        		isCycle = true;
        		return;
        	}
            dfs(adj, i);
        }
        push(node);
    }
    private int compareWords(String str1, String str2){
        for(int i = 0; i< Math.min(str1.length(), str2.length()); i++){
            if(str1.charAt(i) != str2.charAt(i)) return i;
        }
        return -1;
    }
    private void push(int node){
        if(stack.contains(node)) isCycle = true;
        else{
            stack.push(node);
        }
    }
}