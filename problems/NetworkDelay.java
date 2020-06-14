/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

Example 1:
diagram missing.

go to :https://leetcode.com/problems/network-delay-time/

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
*/

import java.util.*;
import java.lang.*;
class NetworkDelay
{
    public int findNextBestVertex(int dist[],int visitD[],int V)
	{	int vertex=0,min=999;//Integer.MAX_VALUE;
		for(int v=0;v<V;v++)
		{
			if(dist[v]<=min && visitD[v]==0)
			{
				min=dist[v];
                //System.out.println(v);
				vertex=v;
			}
		}
		return vertex;
	}
    public int applydijkstra(int [][]graph,int[]dist,int src,int n)
    {
        
        int visitD[]=new int[n];
        for(int i=0;i<n;i++)
            visitD[i]=0;
        for(int vCount=0;vCount<n-1;vCount++)
		{
            dist[src]=0;
            int u=findNextBestVertex(dist,visitD,n);
            visitD[u]=1;
            for(int v=0;v<n;v++)
			{
				if(visitD[v]==0 && graph[u][v]!=0)
					if(dist[v]>dist[u]+graph[u][v])
					{
						dist[v]=dist[u]+graph[u][v];
					}
			}
		}
        int maxDelay=dist[0];
        System.out.println("n="+n);
        System.out.println(dist[0]+" "+0);
        for(int i=1;i<n;i++)
        {  
            System.out.println(dist[i]+" "+i);
            if(dist[i]!=999 && maxDelay < dist[i])
            {
                maxDelay=dist[i];
            }
        }
        return (maxDelay==999)?-1:maxDelay;
    }
    public int networkDelayTime(int[][] times, int N, int K)
    {
    
        int [][]gph=new int[N][N];//{{0,0,0,0},{1,0,1,0},{0,0,0,1},{0,0,0,0}};
        
        for(int i=0;i<times.length;i++)
        {   
           int j=0;
           gph[(times[i][j]-1)][(times[i][j+1]-1)]=times[i][j+2];
        }
        for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        System.out.print(gph[i][j]+" ");
        
        
        int dist[]=new int[N];
        for(int i=0;i<N;i++)
            dist[i]=999;
        return applydijkstra(gph,dist,K-1,N);
    }
    public static void main(String s[])
    {
    	int times[][] ={{1,2,1},{2,3,7},{1,3,4},{2,1,2}};//{{2,1,1},{2,3,1},{3,4,1}};//{{1,2,1},{2,1,3}};// ;
    	int N = 3;int K = 4;
    	NetworkDelay ob=new NetworkDelay();
        System.out.println("ans "+ob.networkDelayTime(times,N,K));
    }
    
}   
    

