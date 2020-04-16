import java.util.*;
import java.lang.*;
class Graph
{
	int V,E;
	class Edge
	{
		String src;
		String dest;
		int weight;

		Edge(String s, String d, int c)
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
			edge[i]=new Edge("","",0);
		}
	}

};

class CheapestFlight
{
	/*void printCosts(int []csts,Graph g)
	{
		for(int k=0;k<g.V;k++)
		{
			System.out.print(csts[k]+"  ");
		}
	}*/
	void BellmanFord(Graph g,String src)
	{
		HashMap <String,Integer> hm =new HashMap<String,Integer>(g.V);
		hm.put("jfk",999);hm.put("atl",999);hm.put("hlx",999);hm.put("lfx",999);hm.put("opk",999);
		hm.put("lfx",999);hm.put("def",999);hm.put("sof",999);
		
		hm.replace(src,0);
		for(int i=1;i<g.V;i++)
		{	

			for(int j=0;j<g.E;j++)
				{
					String u=g.edge[j].src;
					String v=g.edge[j].dest;
					int dist=g.edge[j].weight;

					if(hm.get(u)!=999 && hm.get(u)+dist < hm.get(v))
						hm.replace(v,hm.get(u)+dist);
				}
		}
		System.out.println(hm);
	}
	public void takeInput(Graph g,int E)
	{
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<E;i++)
		{
			System.out.println("enter edge details no"+i);
			g.edge[i].src=sc.nextLine();
			g.edge[i].dest=sc.nextLine();
			g.edge[i].weight=sc.nextInt();
			sc.nextLine();
		}
	}

	public static void main(String a[])
	{
		

		int V = 8; // Number of vertices in graph 
        int E = 7; // Number of edges in graph 
  
        Graph graph = new Graph(V, E); 
  		CheapestFlight bfa=new CheapestFlight();
  		bfa.takeInput(graph,E);
        // add edge 0-1 (or A-B in above figure) 
        /*graph.edge[0].src = "jfk"; 
        graph.edge[0].dest = "atl"; 
        graph.edge[0].weight = 150; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = "jfk"; 
        graph.edge[1].dest = "hlx"; 
        graph.edge[1].weight = 800; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src ="jfk"; 
        graph.edge[2].dest = "lfx"; 
        graph.edge[2].weight = 500; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = "atl"; 
        graph.edge[3].dest = "opk"; 
        graph.edge[3].weight = 90; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = "atl"; 
        graph.edge[4].dest = "sof"; 
        graph.edge[4].weight = 400; 
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = "opk"; 
        graph.edge[5].dest = "lfx"; 
        graph.edge[5].weight = 200; 

        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = "lfx"; 
        graph.edge[6].dest = "def"; 
        graph.edge[6].weight = 80; */
  		
  		
    
        bfa.BellmanFord(graph, "jfk"); 
	}
}


