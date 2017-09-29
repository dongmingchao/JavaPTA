/*
*
* 7-3 jmu-Java-03面向对象基础-03-形状（3 分）
1. 定义长方形类与圆形类Circle

长方形类-类名：Rectangle，private属性：int width,length
圆形类-类名：Circle，private属性:int radius

编写构造函数：
带参构造函数:Rectangle(width, length),Circle(radius)

编写方法：
public int getPerimeter()，求周长。
public int getArea()，求面积。
toString方法，使用Eclipse自动生成。

注意：

计算圆形的面积与周长，使用Math.PI。
求周长和面积时，应先计算出其值(带小数位)，然后强制转换为int再返回。
2. main方法

输入2行长与宽，创建两个Rectangle对象放入相应的数组。
输入2行半径，创建两个Circle对象放入相应的数组。
输出1：上面2个数组中的所有对象的周长加总。
输出2：上面2个数组中的所有对象的面积加总。
最后需使用Arrays.deepToString分别输出上面建立的Rectangle数组与Circle数组
思考：如果初次做该题会发现代码冗余严重。使用继承、多态思想可以大幅简化上述代码。

输入样例:

1 1
1 1
7
1
输出样例:

57
158
[Rectangle [width=1, length=1], Rectangle [width=1, length=1]]
[Circle [radius=7], Circle [radius=1]]
*/
package three;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rectangle r1 = new Rectangle(in.nextInt(), in.nextInt());
        Rectangle r2 = new Rectangle(in.nextInt(), in.nextInt());
        Circle c1 = new Circle(in.nextInt());
        Circle c2 = new Circle(in.nextInt());
        System.out.println(r1.getPerimeter()+r2.getPerimeter()+c1.getPerimeter()+c2.getPerimeter());
        System.out.println(r1.getArea()+r2.getArea()+c1.getArea()+c2.getArea());
        System.out.println("["+r1+", "+r2+"]");
        System.out.println("["+c1+", "+c2+"]");
    }
}

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius=radius;
    }


    @Override
    public String toString() {
        return "Circle [" +
                "radius=" + radius +
                ']';
    }

    public int getPerimeter() {
        return (int) (2 * Math.PI * this.radius);
    }

    public int getArea() {
        return (int) (Math.pow(this.radius, 2) * Math.PI);
    }
}

class Rectangle {
    private int width, length;

    public Rectangle(int width, int length) {
        this.width=width;
        this.length=length;
    }

    @Override
    public String toString() {
        return "Rectangle [" +
                "width=" + width +
                ", length=" + length +
                ']';
    }

    public int getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public int getArea() {
        return this.length * this.width;
    }
}