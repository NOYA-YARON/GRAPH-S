package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JFrame;

import dataStructure.graph;
import dataStructure.node_data;

public class Gui extends JFrame implements ActionListener , MouseListener  {
graph g;
void printNodes(){
	StdDraw.setPenRadius(0.02);
	StdDraw.setPenColor(StdDraw.BLACK);
	Collection<node_data> nodes=g.getV();
	for (node_data vertex:nodes) {
		StdDraw.point(vertex.getLocation().x(),vertex.getLocation().y());
	}
}
/**
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
public static void main(String[] args) {
	
	StdDraw.setPenRadius(0.02);
	StdDraw.setPenColor(StdDraw.BLACK);
	
	StdDraw.point(0.5,0.9);
	StdDraw.line(0.5,0.9, 0.1,0.3);
	StdDraw.point(0.15,0.28);
	StdDraw.line(0.15,0.28, 0.1,0.3);
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.setPenRadius(0.001);
}
}
