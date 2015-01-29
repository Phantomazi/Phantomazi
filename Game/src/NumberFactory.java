
public class NumberFactory {

	
	public Number createNumber(double x, double y, int id) {
		Number tempNumber = null;
		 tempNumber = new Number(x, y, id);
		return tempNumber;
		
	}
}
