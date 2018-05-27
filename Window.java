package Automata;
import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame{
	
	private int size;
	
	public Window(int x){
		size = x;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		this.setSize(size,size+40);
		this.setVisible(true);
		this.setTitle("Game of Life");
	}
	public int findSize() {
		return size;
	}
}