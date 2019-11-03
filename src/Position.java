public class Position {
    private double x, y;
    private static Position defaultPosition = new Position(0.0, 0.0);

    public static Position positionDefaut () {
	return defaultPosition;
    }

    public Position() {
        this.x = defaultPosition.x;
        this.y = defaultPosition.y;
    }

    public Position(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public double x() { return x; }

    public double y() { return y; }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o == this){
            return true;
        }
        if(o instanceof Position){
            Position p = (Position) o;
            if(p.x() == x()){
                if(p.y() == y()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public String toString()  { return "(" + x + ", " + y +")"; }

}
