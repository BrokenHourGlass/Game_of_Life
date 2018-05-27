package Automata;

public class Main{
	public static void main(String args[]){
		Window win = new Window(1000);
		Cell grid = new Cell(win.findSize());
		win.add(grid);
		win.setVisible(true);
		grid.draw();
	}
}