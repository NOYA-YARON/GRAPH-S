package dataStructure;

import utils.Point3D;

public class Node implements node_data {
	private Point3D p;
	private int key;
	private double weight;
	private String infro;
	private int tag;

	public Node (Point3D _p, int _key ,double _weight, String  _infro,  int _tag) {
		this.p=_p;
		this.key=_key;
		this.weight=_weight;
		this.infro=_infro;
		this.tag=_tag;
	}
	
	public Node (Node Other) {
		this.p= Other.p;
		this.key=Other.key;
		this.weight=Other.weight;
		this.infro=Other.infro;
		this.tag=Other.tag;
	}
	@Override
	public int getKey() {

		return key;
	}

	@Override
	public Point3D getLocation() {
		return p;
	}

	@Override
	public void setLocation(Point3D p) {
		this.p=new Point3D(p);

	}

	@Override
	public double getWeight() {

		return weight ;
	}

	@Override
	public void setWeight(double w) {
		this.weight=w;

	}

	@Override
	public String getInfo() {

		return infro;
	}

	@Override
	public void setInfo(String s) {
		this.infro=s; 
	}
	@Override

	public int getTag() {

		return tag ;
	}

	@Override
	public void setTag(int t) {
		this.tag=t;

	}
	public static int stam (int a) {
		return a+1 ;
	}
	public String toString () {

		return"point3D: "  + p +  " key:  " + key  + " weight: " + weight + " infromation: " +infro + " Tag: " + tag;

	}

//		public static void main(String[] args) {
//			//Point3D b = new Point3D(6,7,8);
//			Node a =new Node(   new Point3D(6,7,8),7,8,"ariel",9);
//			System.out.println(a);
//			Node b =new Node(   new Point3D(6,7,9),7,8,"ph",9);
//			System.out.println(a.getKey());
//			System.out.println(a.getLocation());
//			System.out.println(b.getLocation());
//			a.setLocation(new Point3D(6,7,11));
//			System.out.println(a.getLocation());
//			System.out.println(stam(7));
//	a.setTag(7);
//	System.out.println(a.getTag());
//	a.setInfo("jkjnhkjnhkj");
//	System.out.println(a.getInfo());
//	a.setWeight(7.4);
//	System.out.println(a.getWeight());
//		}


}
