package ine5633.eightpuzzlesolver;

public class Coordinate {

	public static final Integer MAX = 3;
	public static final Integer MIN = 1;
	
	private Integer x;
	private Integer y;
	
	public Coordinate(Integer x, Integer y) {
		this.setX(x);
		this.setY(y);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Boolean isValid() {
		if(getX() > MAX || getX() < MIN){
			return false;
		}
		if(getY() > MAX || getY() < MIN){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
}
