
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Number extends ImageView{
		private int id;

		Number(double x, double y, int id){
			this.setX(x);
			this.setY(y);
			this.id = id;
			this.setImage(new Image(AssignmentTemplate.class.getResource("resources/"+id+"_e.png").toExternalForm()));
		}	
		
		public int getID(){
			return id;
		}
}