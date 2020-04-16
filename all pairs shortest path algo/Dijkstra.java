import java.util.*;
class Dijkstra
{
	static final int V = 9;
	int findNextBestVertex(int dist[],int visitD[])
	{	int vertex=0,min=999;//Integer.MAX_VALUE;
		for(int v=0;v<V;v++)
		{
			if(dist[v]<=min && visitD[v]==0)
			{
				min=dist[v];
				vertex=v;
			}
		}
		return vertex;
	}
	void printPaths(int dist[])
	{
		for(int v=0;v<V;v++)
		{
			System.out.print(dist[v]+" ");
		}
	}
	void impDijkstraAlgo(int graph[][],int source)
	{
		int dist[]=new int[V];
		int visitD[]=new int[V];


		for (int v=0;v<V;v++)
		{
			dist[v]=999;//Integer.MAX_VALUE;
			visitD[v]=0;
		}
		for(int vCount=0;vCount<V-1;vCount++)
		{

			dist[source]=0;

			int u=findNextBestVertex(dist,visitD);

			visitD[u]=1;

			for(int v=0;v<V;v++)
			{
				if(visitD[v]==0 && graph[u][v]!=0)
					if(dist[v]>dist[u]+graph[u][v])
					{
						dist[v]=dist[u]+graph[u][v];
					}
			}
		}
		printPaths(dist);

	}
	
	public static void main(String a[])
	{
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
         Dijkstra obj= new Dijkstra();
         obj.impDijkstraAlgo(graph,0);
	}
}
