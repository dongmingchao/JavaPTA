/*
*
* 7-4 jmu-Java-03面向对象基础-04-形状-继承（15 分）
前言

上题形状中我们看到，为了输出所有形状的周长与面积，需要建立多个数组进行多次循环。这次试验使用继承来改进我们的设计。以下是上题的描述，稍作修改。修改后，getPerimeter与getArea方法返回double。

a.编写长方形类Rectangle(属性int width,length)、圆形类Circle(属性int radius)。

编写其带参构造函数`Rectangle(int width,int length)`,`Circle(int radius)`

编写其toString方法(Eclipse自动生成)

b.上述2个类均有：求周长的方法`getPerimeter()`、求面积的方法`getArea()`。

注意：计算圆形的周长，使用Math.PI
本题描述：

定义抽象类Shape
属性：不可变常量double PI，值为3.14，方法:public double getPerimeter(),public double getArea())
让Rectangle与Circle继承自Shape类。
编写double sumAllArea方法输出形状数组中的面积和和double sumAllPerimeter方法输出形状数组中的周长和。
main方法中
4.1 输入整型值n，然后建立n个不同的形状。如果输入rect，则再输入长和宽。如果输入cir，则再输入半径。
4.2 然后输出所有的形状的周长之和，面积之和。并将所有的形状信息以样例的格式输出。
4.3 最后输出每个形状的类型与父类型.使用类似shape.getClass()(获得类型),shape.getClass().getSuperclass()(获得父类型);
思考

你觉得sumAllArea和sumAllPerimeter方法放在哪个类中更合适？
输入样例:

3
rect
1 1
rect
2 2
cir
1
输出样例:

18.28
8.14
[Rectangle [width=1, length=1], Rectangle [width=2, length=2], Circle [radius=1]]
class Rectangle,class Shape
class Rectangle,class Shape
class Circle,class Shape
 */

package three;


import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String suck = in.nextLine();//      前有非nextLine后接nextLine注意处理回车！
        Shape[] s = new Shape[len];
        for (int i = 0; i < len; i++) {
            String ask = in.nextLine();
            switch (ask) {
                case "cir":
                    s[i] = new Circle2(in.nextInt());
                    break;
                case "rect":
                    s[i] = new Rectangle2(in.nextInt(), in.nextInt());
                    break;
            }
            suck = in.nextLine();
        }
        System.out.println(Shape.sumAllPerimeter(s));
        System.out.println(Shape.sumAllArea(s));
        System.out.print("[");
        for (int i = 0; i < s.length; i++) {
            if (i == s.length - 1) System.out.println(s[i] + "]");
            else System.out.print(s[i] + ", ");
        }
        for (Shape shape : s) {
            System.out.println(shape.getClass() + "," + shape.getClass().getSuperclass());
        }
    }
}

abstract class Shape {
    double PI = 3.14;

    public abstract double getPerimeter();

    public abstract double getArea();

    public static double sumAllArea(Shape in[]) {
        double res = 0;
        for (Shape shape : in) {
            res += shape.getArea();
        }
        return res;
    }

    public static double sumAllPerimeter(Shape in[]) {
        double res = 0;
        for (Shape shape : in) {
            res += shape.getPerimeter();
        }
        return res;
    }
}

class Circle2 extends Shape {
    private int radius;

    public Circle2(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle [" +
                "radius=" + radius +
                ']';
    }
}

class Rectangle2 extends Shape {
    private int width, length;

    public Rectangle2(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle [" +
                "width=" + width +
                ", length=" + length +
                ']';
    }
}