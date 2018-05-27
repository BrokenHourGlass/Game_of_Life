package Automata;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class Cell extends JPanel{
	
	Random po;
	private boolean[][] cell;
	private boolean[][] cell2;
	int num;
	//initializes the the class
	public Cell(int size){
		//initializes the displaying cell
		cell = new boolean[size][size];
		//initializes the future cell
		cell2 = new boolean[size][size];
		//random value
		po = new Random();
		//stores the size of the grid
		num = size;
		setGrid(size);	
		//paints initial frame
		repaint();
	}
	//randomly determines the lives of cells in the frame
	public void setGrid(int size) {
		//randomly determines the life of cells on the grid
		for(int i =0;i<size;i++) {
			for (int j = 0; j<size;j++) {
					cell[i][j] = po.nextBoolean();
			}
		}
	}
	//checks to determine if cell is alive and paints to the frame
	public void draw() {
		while(true) {
			for(int x = 0; x<cell.length;x++) {
				for(int y = 0; y<cell[0].length;y++) {
					status(x,y);
				}
			}
			//overwrites current frame with future frame and displays
			for(int x = 0; x<cell.length;x++) {
				for(int y = 0; y<cell[0].length;y++) {
					cell[x][y] = cell2[x][y];
				}
			}
			repaint();
		}
	}
	//determines if the cell is alive depending on the number of neighbors the cell has
	private void status(int x, int y) {
		int counter = 0;
		counter = surroundings(x,y);
		if((counter <2)||(counter > 3)) {
			cell2[x][y] = false;
		}
		else if(counter == 3){
			 cell2[x][y] = true;
		}
		else {
			cell2[x][y] = cell[x][y];
		}
	}
	//method that checks the neighbors of a certain cell and increments a value for each alive neighbor
	private int surroundings(int x, int y) {
		int a = 0;
		//prevents an out of bounds exception
		if((x==0)||(x==cell.length-1)) {
			return 0;
		}
		//prevents an out of bounds exception
		else if((y==0)||(y==cell.length-1)) {
			return 0;
		}
		//checks the upper left neighbor
		if(cell[x-1][y-1]) {
			a++;
		}
		//checks the left center neighbor
		if(cell[x-1][y]) {
			a++;
		}
		//checks the lower left neighbor
		if(cell[x-1][y+1]) {
			a++;
		}
		//checks the upper middle neighbor
		if(cell[x][y-1]) {
			a++;
		}
		//checks the lower center neighbor
		if(cell[x][y+1]) {
			a++;
		}
		//checks the upper right neighbor
		if(cell[x+1][y-1]) {
			a++;
		}
		//checks the center right neighbor
		if(cell[x+1][y]) {
			a++;
		}
		//checks the lower right neighbor
		if(cell[x+1][y+1]) {
			a++;
		}
		//returns incremented value
		return a;
	}
	//overwritten paint method that draws cells to the frame if they are alive or dead
	public void paint(Graphics g) {
		super.paint(g);
		//for the size of the grid check each cell
		for(int x = 0; x<cell.length;x++) {
			for(int y = 0; y<cell[0].length;y++) {
				//if alive draw a white cell
				if(cell[x][y]) {
					g.setColor(Color.white);
					g.drawLine(x,y,x,y);
				//otherwise it is dead, so draw a black cell
				}else {
					g.setColor(Color.black);
					g.drawLine(x,y,x,y);
				}
			}
		}
	}
}
