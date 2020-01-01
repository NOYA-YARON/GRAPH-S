package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import utils.Point3D;


public class DGraph implements graph{

	//misthanim Node Key root node 
	HashMap<Integer,node_data> nodes = new HashMap<>();
	HashMap<Integer,HashMap<Integer,edge_data>> ArrEdge = new HashMap<>();	
	int MC;
	
//work
	@Override
	public node_data getNode(int key) {

		return nodes.get(key);
	}
	//work

	@Override
	public edge_data getEdge(int src, int dest) {
		try {
			return ArrEdge.get(src).get(dest); // החזרת צלע
		}catch(NullPointerException  e) {
			return null ;
		}
	}
	//work
	@Override
	public void addNode(node_data n) {
	
		nodes.put(MC, n);
		MC++;
	}
	//work

	@Override
	public void connect(int src, int dest, double w) {
//if(w<0) //זרוק אקספשיין
		ArrEdge.put(src,new HashMap<Integer,edge_data>());
		ArrEdge.get(src).put(dest, new Edge ((Node)nodes.get(src),(Node)nodes.get(dest),w , " " ,MC));
		MC++;
	}
	//work

	@Override
	public Collection<node_data> getV() {
		return (Collection<node_data>) nodes;
	}
	//work

	@Override
	public Collection<edge_data> getE(int node_id) {
		return (Collection<edge_data>) ArrEdge.get(node_id);
	}
	//work

	@Override
	public node_data removeNode(int key) {
	
		return nodes.remove(key);
	}
	//work

	@Override
	public edge_data removeEdge(int src, int dest) {
		return ArrEdge.get(src).remove(dest);
	}
	//work
	@Override
	public int nodeSize() {
		return nodes.size();
	}
	//work

	@Override
	public int edgeSize() {
		return ArrEdge.size();
	}
	//work
	@Override
	public int getMC() {
		return MC ;
	}
	/***
	 * toString
	 */
	public String toString() {
		String s="";


		for(Entry<Integer, node_data> entry :nodes.entrySet()) {
		    s+= entry.getKey()+" ";
		   s+= entry.getValue()+" \n";
		}
		
		for(Entry<Integer,HashMap<Integer,edge_data>> entry :ArrEdge.entrySet()) {
		    s+= entry.getKey()+" ";
		   s+= entry.getValue()+" \n";
		}
		return s;
	}
	
public static void main(String[] args) {
	

Point3D p =new Point3D ( 1.1, 2.5, 5.8);
Point3D p1= new Point3D (2.4,7, 6.6);

node_data smoal= new Node (p, 6 , 7, "noya", 7);
node_data n1 = new Node (p1, 5 ,4.5,  " or", 5);
node_data a =new Node(new Point3D(6,7,8),7,8,"ariel",9); 
node_data b=new Node( new Point3D(6,7,8),8,9,"ariel1",9);
edge_data c =new Edge ((Node)a, (Node) b, 8.8 ,"a-b", 7);

graph stammmmmmmmmm=new DGraph();
	
stammmmmmmmmm.addNode(a);
stammmmmmmmmm.addNode(b);
stammmmmmmmmm.addNode(smoal);
System.out.println(stammmmmmmmmm.nodeSize());
	System.out.println(stammmmmmmmmm);
	System.out.println(stammmmmmmmmm.getNode(2));
	System.out.println(stammmmmmmmmm.getMC());
System.out.println("test");

}

}
