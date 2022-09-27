public class CustomVector {
    private double x;
    private double y;

    public CustomVector() {
        this.x = 0d;
        this.y = 0d;
    }

    public CustomVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static CustomVector plus(CustomVector one, CustomVector two) {
        return new CustomVector(one.getX() + two.getX(), one.getY() + two.getY());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomVector that = (CustomVector) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
