import java.awt.*;

public class Convex {
    private Figure fig;
    static   R2Point a,b,c;
    public Convex(R2Point a , R2Point b, R2Point c) {
        this.a =a; this.b = b; this.c = c;
        fig = new Void();
    }

    public void add(R2Point p) {
        fig = fig.add(p);
    }
    public double area() {
        return fig.area();
    }
    public double perimeter() {
        return fig.perimeter();
    }

   // public  void inTriangle(){ fig.inTriangle();}

    public  static R2Point getA(){ return a; }

    public  static R2Point getB(){ return  b; }

    public  static R2Point getC(){ return  c; }

    public void draw(Graphics g){
        fig.draw(g);
        g.drawLine((int) a.x, (int) -a.y, (int) b.x, (int) -b.y);
        g.drawLine((int) b.x, (int) -b.y, (int) c.x, (int) -c.y);
        g.drawLine((int) c.x, (int) -c.y, (int) a.x, (int) -a.y);
    }
}
