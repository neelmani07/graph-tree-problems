import java.util.*;
import java.lang.*;
class Graph
{
	int V,E;
	class Edge
	{
		int src;
		int dest;
		int weight;

		Edge(int s, int d, int c)
		{
			src=s;
			dest=d;
			weight=c;
		}
	};

	Edge edge[];
	Graph(int v,int e)
	{
		edge=new Edge[e];
		V=v;E=e;
		for(int i=0;i<e;i++)
		{
			edge[i]=new Edge(0,0,0);
		}
	}

};

class BellmanFortAlgo
{
	void printCosts(int []csts,Graph g)
	{
		for(int k=0;k<g.V;k++)
		{
			System.out.print(csts[k]+"  ");
		}
	}
	void BellmanFord(Graph g,int src)
	{
		int costOf[]=new int[g.V];
		for(int i=0;i<g.V;i++)
		{
			costOf[i]=999;
		}
		
		costOf[src]=0;
		for(int i=1;i<g.V;i++)
		{	

			for(int j=0;j<g.E;j++)
				{
					int u=g.edge[j].src;
					int v=g.edge[j].dest;
					int dist=g.edge[j].weight;

					if(costOf[u]!=999 && costOf[u]+dist < costOf[v])
						costOf[v]=costOf[u]+dist;
				}
		}
		printCosts(costOf,g);
	}

	public static void main(String a[])
	{
		

		int V = 5; // Number of vertices in graph 
        int E = 8; // Number of edges in graph 
  
        Graph graph = new Graph(V, E); 
  	BellmanFortAlgo bfa=new BellmanFortAlgo();
        // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 

        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3; 
  
        bfa.BellmanFord(graph, 0); 
	}
}


