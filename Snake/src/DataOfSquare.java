import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {

	
	//ArrayList that'll contain the colors
	ArrayList<Color> C =new ArrayList<Color>();
	int color; //2: snake , 1: food, 0:empty 
	SquarePanel square;
	public DataOfSquare(int col){
		
		//Lets add the color to the arrayList
		C.add(Color.red);     //2:snake
		C.add(Color.BLUE);    //1:food
		C.add(Color.white);   //0:empty
		color=col;
		square = new SquarePanel(C.get(color));//gets empty
	}
	public void lightMeUp(int c){
		square.ChangeColor(C.get(c));
	}
}
