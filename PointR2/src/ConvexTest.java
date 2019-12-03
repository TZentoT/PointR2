
public class ConvexTest {
    static UserWindow window;

    public static void main(String[] args) throws Exception {

        System.out.println("Введите координаты треугольника: ");
        Convex convex = new Convex(new R2Point(), new R2Point(), new R2Point());
        window = new UserWindow(convex);
        System.out.println("Введите координаты оболочки: ");
        while (true) {
            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = "
                    + convex.perimeter());
            window.repaint();
        }
    }
}
