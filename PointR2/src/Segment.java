import java.awt.*;
import java.net.UnknownServiceException;

public class Segment implements Figure {
    private R2Point p, q;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
        inTriangle();
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        inTriangle();
        return this;
    }

    public void inTriangle(){
        int count =0;
        R2Point a = Convex.getA(); R2Point b = Convex.getB(); R2Point c = Convex.getC();
        if (a.light(b,p) & b.light(c,p) & c.light(a,p)){
            if (a.light(b,q) & b.light(c,q) & c.light(a,q)){
                count++;
            }
        }
        System.out.println("Число полных ребер: " + count);
    }

    public void draw(Graphics g){
        g.fillOval((int) p.x-5/2, (int) -p.y-5/2,5,5);
        g.fillOval((int) q.x-5/2,(int) -q.y-5/2,5,5);
        g.drawLine((int)  p.x-5/2, (int) -p.y-5/2, (int)  q.x-5/2, (int) -q.y-5/2);
    }
}
