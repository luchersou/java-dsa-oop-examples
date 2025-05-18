package org.example.OOP.Polymorphism;

import java.util.ArrayList;
import java.util.List;

// Interface demonstrating polymorphic behavior
interface Renderable {
    void render();
    default void preRender() {
        System.out.println("Default pre-render operations");
    }
}

// Abstract base class
abstract class Shape implements Renderable, Cloneable {
    protected String color;
    protected boolean visible = true;

    public Shape(String color) {
        this.color = color;
    }

    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();

    // Concrete method that can be inherited
    public String getColor() {
        return color;
    }

    // Method that can be overridden
    public void setVisibility(boolean visible) {
        this.visible = visible;
        System.out.println("Visibility set to: " + visible);
    }

    @Override
    public void render() {
        if (visible) {
            System.out.println("Rendering a " + color + " shape");
        }
    }

    // Demonstrating covariant return type in polymorphism
    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}

// Concrete subclass
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Overriding with additional functionality
    @Override
    public void render() {
        super.render(); // Calling parent's implementation
        System.out.println("Rendering circle with radius: " + radius);
    }

    // Specialized method only for Circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }
}

// Another concrete subclass
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    // Overriding completely
    @Override
    public void render() {
        if (visible) {
            System.out.println("Rendering " + color + " rectangle (" + width + "x" + height + ")");
        }
    }

    // Overriding default interface method
    @Override
    public void preRender() {
        System.out.println("Rectangle-specific pre-render operations");
    }

    // Method overloading (compile-time polymorphism)
    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
    }

    public void resize(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

// Demonstrating polymorphism with generics
class ShapeDrawer<T extends Shape> {
    private List<T> shapes = new ArrayList<>();

    public void addShape(T shape) {
        shapes.add(shape);
    }

    public void renderAll() {
        for (T shape : shapes) {
            shape.preRender();
            shape.render();
        }
    }

    public double totalArea() {
        return shapes.stream()
                .mapToDouble(Shape::calculateArea)
                .sum();
    }
}

// Demonstrating polymorphism with interface inheritance
interface Scalable {
    void scale(double factor);
}

class ScalableCircle extends Circle implements Scalable {
    public ScalableCircle(String color, double radius) {
        super(color, radius);
    }

    @Override
    public void scale(double factor) {
        System.out.println("Scaling circle by factor: " + factor);
        // This would normally modify the radius
    }
}

public class AdvancedPolymorphismDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Polymorphic collection
        ShapeDrawer<Shape> drawer = new ShapeDrawer<>();

        // Adding different shapes (runtime polymorphism)
        drawer.addShape(new Circle("Red", 5.0));
        drawer.addShape(new Rectangle("Blue", 4.0, 6.0));
        drawer.addShape(new ScalableCircle("Green", 3.0));

        // Demonstrating polymorphic behavior
        System.out.println("--- Rendering all shapes ---");
        drawer.renderAll();

        System.out.println("\n--- Calculating total area ---");
        System.out.println("Total area: " + drawer.totalArea());

        // Demonstrating method overriding and dynamic dispatch
        System.out.println("\n--- Dynamic method dispatch ---");
        Shape shape1 = new Circle("Yellow", 2.0);
        Shape shape2 = new Rectangle("Purple", 3.0, 3.0);

        shape1.render(); // Calls Circle's render()
        shape2.render(); // Calls Rectangle's render()

        // Demonstrating interface polymorphism
        System.out.println("\n--- Interface polymorphism ---");
        Renderable renderable = new Rectangle("Black", 5.0, 1.0);
        renderable.render();
        renderable.preRender();

        // Demonstrating polymorphic behavior with clone
        System.out.println("\n--- Cloning demonstration ---");
        Circle original = new Circle("Orange", 10.0);
        Circle cloned = original.clone();
        System.out.println("Original color: " + original.getColor());
        System.out.println("Cloned color: " + cloned.getColor());

        // Demonstrating polymorphic behavior with interface inheritance
        System.out.println("\n--- Interface inheritance ---");
        Scalable scalable = new ScalableCircle("Pink", 7.0);
        scalable.scale(1.5);
        if (scalable instanceof Renderable) {
            ((Renderable) scalable).render();
        }
    }
}

/*

Output:
--- Rendering all shapes ---
Default pre-render operations
Rendering a Red shape
Rendering circle with radius: 5.0
Rectangle-specific pre-render operations
Rendering Blue rectangle (4.0x6.0)
Default pre-render operations
Rendering a Green shape
Rendering circle with radius: 3.0

--- Calculating total area ---
Total area: 104.53981633974483

--- Dynamic method dispatch ---
Rendering a Yellow shape
Rendering circle with radius: 2.0
Rendering Purple rectangle (3.0x3.0)

--- Interface polymorphism ---
Rendering Black rectangle (5.0x1.0)
Rectangle-specific pre-render operations

--- Cloning demonstration ---
Original color: Orange
Cloned color: Orange

--- Interface inheritance ---
Scaling circle by factor: 1.5
Rendering a Pink shape
Rendering circle with radius: 7.0

 */