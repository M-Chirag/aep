package edu.berkeley.aep;

//Understands a four-sided polygon at right angles
public class Rectangle {

    private final int length;
    private final int width;


    //Factory method-> static-> returns a new object which has only one instance
    public static Rectangle createSquare(int side){
        return new Rectangle(side,side);
    }
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(int side) {
        this(side,side);
    }

    public int area(){
        return this.length*this.width;
    }

    public int perimeter(){
        return 2*(this.length+this.width);
    }
}
