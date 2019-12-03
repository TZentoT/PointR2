import java.awt.*;
import java.util.*;

public class Polygon extends Deq implements Figure {
    private double s, p;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }
    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
        inTriangle();
    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }
    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        inTriangle();
        return this;
    }

    public void inTriangle(){
        int count =0;
        R2Point a = Convex.getA(); R2Point b = Convex.getB(); R2Point c = Convex.getC();
        for (int i=0; i<length();i++) {
            if (a.light(b, front()) & b.light(c, front()) & c.light(a, front())) {
                if (a.light(b, back()) & b.light(c, back()) & c.light(a, back())) {
                    count++;
                }
            }
            pushBack(popFront());
        }
        System.out.println("Число полных ребер: " + count);
    }

    public void draw(Graphics g){
     //   System.out.println("Array: " + Arrays.toString(getArray()));
        for(int t=0;t<length();t++){
            g.fillOval((int) front().x,-(int) front().y , 5,5);
            g.fillOval((int) back().x, -(int) back().y, 5,5);
            g.drawLine((int) front().x, (int) -front().y , (int) back().x, -(int) back().y);
            pushBack(popFront());
        }
    }
}
