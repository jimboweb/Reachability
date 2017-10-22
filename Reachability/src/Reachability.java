

import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static boolean[] visited;
    
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        int pathExists = 0;
        if(!visited[x]){
            visited[x] = true;
            for(int node:adj[x]){
                if(node == y){
                    return 1;
                }
                else{
                    pathExists = reach(adj, node, y);
                    if(pathExists == 1)
                        break;
                }
            }
        }
        return pathExists;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
         visited = new boolean[adj.length];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        
        
        System.out.println(reach(adj, x, y));
    }
}

