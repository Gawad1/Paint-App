/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author pc
 */
public class Triangle extends AbstractShape {

    private Point point2;
    private Point point3;

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

   public Boolean isPoint1(Point p){
        java.awt.Rectangle r = new java.awt.Rectangle(getPosition().x-5, getPosition().y-5, 10, 10);
        return r.contains(p.getX(), p.getY());
 }
 public Boolean isPoint2(Point p){
        java.awt.Rectangle r = new java.awt.Rectangle(point2.x-5, point2.y-5, 10, 10);
        return r.contains(p.getX(), p.getY());
 }
 public Boolean isPoint3(Point p){
        java.awt.Rectangle r = new java.awt.Rectangle(point3.x-5, point3.y-5, 10, 10);
        return r.contains(p.getX(), p.getY());
 }
    @Override
    public void draw(Graphics g) {
        int xPoints[] = {getPosition().x, point2.x, point3.x};
        int yPoints[] = {getPosition().y, point2.y, point3.y};
        if (getFillColor() != null) {
            g.setColor(getFillColor());
            g.fillPolygon(xPoints, yPoints, 3);
        }
        g.setColor(getColor());
        g.drawPolygon(xPoints, yPoints, 3);
        if(isSelected())
     { g.setColor(Color.BLACK);
         g.fillRect(  getPosition().x-5, getPosition().y-5 , 10, 10);
        g.fillRect(point2.x-5 ,point2.y-5  , 10, 10);
         g.fillRect(point3.x-5 ,point3.y-5  , 10, 10);
     }
   }
    @Override
    public boolean contains(Point p) {
      Polygon polygon = new Polygon(new int[]{getPosition().x, point2.x, point3.x}, new int[]{getPosition().y, point2.y, point3.y}, 3);
        return polygon.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
        point2 = new Point(point2.x + xdiff, point2.y + ydiff);
        point3 = new Point(point3.x + xdiff, point3.y + ydiff);
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
    }

    @Override
    public void resize(Point p) {
         if(isPoint1(getDraggingPoint()))
        {
            setPosition(p);
        }  
        if(isPoint2(getDraggingPoint()))
        {
            setPoint2(p);
        }
        if(isPoint3(getDraggingPoint()))
        {
            setPoint3(p);
        }  
    }

}



