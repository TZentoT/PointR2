import java.awt.*;

public class Void implements Figure {
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point p) {
        return new Point(p);
    }
    public void draw(Graphics g){ }
    public void inTriangle(){ System.out.println("Недостаточно точек для построения ребра.");}
}
