package dataStructure;


public class Edge  implements edge_data{
	Node src;
	Node dest;
	double weight ;
	String info;
	int tag;

	public Edge (	Node _src , Node _dest, double _weight , String _info, int _tag) {
		this.src=new Node (_src);
		this.dest=new Node (_dest);
		this.weight=_weight;
		this.info=_info;
		this.tag=_tag;
	}
	public Edge (Edge Other) {
		this.src= Other.src;
		this.dest=Other.dest;
		this.weight=Other.weight;
		this.info=Other.info;
		this.tag=Other.tag;
	}
	@Override
	public int getSrc() {
		
		return src.getKey();
	}

	@Override
	public int getDest() {
		return dest.getKey();
	}

	@Override
	public double getWeight() {
		return  weight;
	}

	@Override
	public String getInfo() {
		return  info ;
	}
	@Override
	public void setInfo(String s) {
	this.info=s;

	}

	@Override
	public int getTag() {
		return tag;
	}
	@Override
	public void setTag(int t) {
		this.tag=t; 

	}
	
	public String toString () {
		
		return  " Src: " + src + " Dest: " + dest + " Weight: " + weight + " INFO: " + info +  " Tag " + tag ;
		
	}
//	public static void main(String[] args) {
//		Node a =new Node(new Point3D(6,7,8),7,8,"ariel",9); 
//		Node b=new Node( new Point3D(6,7,8),7,8,"ariel1",9);
//		Edge c =new Edge (a, b, 8.8 ,"a-b", 7);
//		System.out.println(c.getSrc());
//		System.out.println(c.getDest());
//	}
}
