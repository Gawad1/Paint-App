/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * @author pc
 */
public class LineSegment extends AbstractShape {

    private Point endPoint;

    public Point getEndpoint() {
        return endPoint;
    }

    public void setEndpoint(Point endpoint) {
        this.endPoint = endpoint;
    }

    public Boolean isStartPoint(Point p) {
        java.awt.Rectangle r = new java.awt.Rectangle(getPosition().x - 5, getPosition().y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public Boolean isEndPoint(Point p) {
        java.awt.Rectangle r = new java.awt.Rectangle(endPoint.x - 5, endPoint.y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getPosition().x, getPosition().y, (int) endPoint.getX(), (int) endPoint.getY());
        if (isSelected()) {
            g.setColor(Color.BLACK);
            g.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
            g.fillRect(endPoint.x - 5, endPoint.y - 5, 10, 10);
        }
    }

    @Override
    public boolean contains(Point p) {
        int x1, y1, x2, y2;
        x1 = getPosition().x;
        y1 = getPosition().y;
        x2 = endPoint.x;
        y2 = endPoint.y;
        Line2D.Float x = new Line2D.Float(x1, y1, x2, y2);
        return (x.ptSegDist(p) < 2);
    }

    @Override
    public void moveTo(Point p) {
        int x = p.x - getDraggingPoint().x;
        int y = p.y - getDraggingPoint().y;
        endPoint = new Point(endPoint.x + x, endPoint.y + y);
        setPosition(new Point(getPosition().x + x, getPosition().y + y));
    }

    @Override
    public void resize(Point p) {

        if (isStartPoint(getDraggingPoint())) {
            setPosition(p);
        }
        if (isEndPoint(getDraggingPoint())) {
            setEndpoint(p);
        }
    }

}

