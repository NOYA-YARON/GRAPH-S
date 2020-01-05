package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */


public class Graph_Algo implements graph_algorithms{
	//tchonotttttt
	graph g;


	@Override
	public void init(graph g) {
		this.g=g;

	}
	@Override
	public void init(String file_name) {
		//מקבלים נתיב לקובץ בצורת string ממירים את הקובץ לגרף
		graph _g=this.g;
		File file = new File(file_name);
		try {
			//מקבל נתיב והופך אותו ל'קובץ
			FileInputStream a=new FileInputStream(file);
			//לוקח את הקובץ והופך אותו לאובייקט
			ObjectInputStream tograph=new ObjectInputStream(a);
			// לוקח את האובייקט והוםף אותו לגרף
			g=(graph) tograph.readObject();

			tograph.close();
			a.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(String file_name) {
		try {
			//ייצא החוצה לתוך הקובץ
			FileOutputStream a = new FileOutputStream(file_name);
			//הפןך את ההאובייקט של קבצים לאובייקט של גרף
			ObjectOutputStream tofile=new ObjectOutputStream(a);
			//כותב לאובייקט (גרף)
			tofile.writeObject(this.g);
			//סוגרים הפוך
			a.close();
			tofile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	public boolean isConnected() {
		boolean flag=true;
		ArrayList<node_data> v=(ArrayList<node_data>) this.g.getV();
		Iterator<node_data> It=v.iterator();
		DFS(It.next());
		for(node_data vertex : v) { // עוברים על כל הקודקודים 

			if(vertex.getTag()==0)  
				flag=false;
		}

		return flag;
	}
	void DFS(node_data v)  //  עושה חיפוש בגרף - האם הקודקוד מקושר לקודקוד אחר
	{ 
		Stack<node_data> s=new Stack<node_data>();
		ArrayList <edge_data> e;
		s.push(v);
		while(!s.isEmpty())
		{
			node_data temp=s.pop();
			temp.setTag(1);
			e=(ArrayList<edge_data>) this.g.getE(temp.getKey());
			for(edge_data _e:e) {
				if (this.g.getNode(_e.getDest()).getTag()==0&&
						this.g.getE(_e.getDest())!=null) {
					s.push(this.g.getNode(_e.getDest()));
				}
			}
		}
	} 
	@Override
	public double shortestPathDist(int src, int dest) {

		node_data _dest=this.g.getNode(dest);
		node_data _src=this.g.getNode(src);
		ArrayList <node_data> v=(ArrayList<node_data>) this.g.getV();
		Iterator<node_data> It=v.iterator();
		//עוברים עלל כל הקודקודים ומאתחלים לאינסוף
		while(It.hasNext()) {
			node_data temp =It.next();
			temp.setTag(0);
			temp.setWeight(Double.MAX_VALUE);
		}
		//מפעילים dijkstra 
		_src.setWeight(0);
		dijkstra(_src,_dest);
		return g.getNode(dest).getWeight();
	}
	
	public void dijkstra(node_data _src,node_data _dest) {
		Stack <node_data> s=new Stack<node_data>();
		_src.setWeight(0);
		s.add(_src);
		while(!s.isEmpty()) {
			_src.setTag(1);
			ArrayList<edge_data> arrayList=(ArrayList<edge_data>) g.getE(_src.getKey());
			for (edge_data edge:arrayList) {
				node_data neibor =g.getNode(edge.getDest());
				double n_whiget=_src.getWeight()+edge.getWeight();
				if(neibor.getWeight()>n_whiget) {
					neibor.setWeight(n_whiget);
					s.add(neibor);
				}
			}
			s.pop();
			_src=s.peek();
		}
	}
	
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		Graph_Algo temp=new Graph_Algo();
		//this. graph save in temp.txt
		this.save("stam.text");
		//take from file to temp
		temp.init("stam.text");
		return temp.g;
	}

}
