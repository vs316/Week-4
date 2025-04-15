package java_functional_interfaces;

    // Functional interface to calculate area of circle
    @FunctionalInterface
    interface CircleArea {
        double calculateArea(double radius);
    }
// Circle class implementing the functional interface
class Circle {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        CircleArea areaCalculator = r -> Math.PI * r * r;
        return areaCalculator.calculateArea(radius);
    }
}
public class AreaOfCircleUsingFunctionInterface {

    public static void main(String[] args) {
        Circle circle =new Circle();
        circle.setRadius(5);
        double area = circle.calculateArea();
        System.out.println("Area of the circle: " + area);

    }
}
