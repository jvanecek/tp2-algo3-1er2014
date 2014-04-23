package Ejercicio2.model;

/**
 * Created by Tomi on 20-Apr-14.
 */
public class Pueblo {
    private final int x;
    private final int y;
    private final int id;

    public Pueblo(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pueblo{" +
                "id=" + id +
                '}';
    }
}
