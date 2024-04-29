/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author pc
 */
public class Rectangle extends AbstractShape {

    private int width;
    private int length;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public boolean isUpperRight(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean isUpperLeft(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean isLowerRight(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y + length - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean isLowerLeft(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y + length - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    @Override
    public void draw(Graphics g) {
        int x = getPosition().x;
        int y = getPosition().y;
        if (getFillColor() != null) {
            g.setColor(getFillColor());
            g.fillRect(x, y, width, length);
        }
        g.setColor(getColor());
        g.drawRect(x, y, width, length);
        if (isSelected()) {
            g.setColor(Color.BLACK);
            g.fillRect(x - 5, y - 5, 10, 10);
            g.fillRect(x + width - 5, y - 5, 10, 10);
            g.fillRect(x - 5, y + length - 5, 10, 10);
            g.fillRect(x + width - 5, y + length - 5, 10, 10);
        }
    }

    @Override
    public boolean contains(Point p) {
        Point position = getPosition();
        java.awt.Rectangle r = new java.awt.Rectangle();
        r.setLocation(position);
        r.setSize(width, length);
        return r.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        int x = p.x - getDraggingPoint().x;
        int y = p.y - getDraggingPoint().y;
        setPosition(new Point(getPosition().x + x, getPosition().y + y));
    }

    @Override
    public void resize(Point p) {
        int x1 = getPosition().x;
        int y1 = getPosition().y;
        int x2 = p.x;
        int y2 = p.y;
        if (isUpperLeft(getDraggingPoint())) {
            if (x1 > x2 && y1 > y2) {
                width = width + Math.abs(x1 - x2);
                length = length + Math.abs(y1 - y2);
                setPosition(p);
            } else if (x1 < x2 && y1 < y2) {
                width = width - Math.abs(x1 - x2);
                length = length - Math.abs(y1 - y2);
                setPosition(p);
            } else if (x1 > x2) {
                width = width + Math.abs(x1 - x2);
                setPosition(p);
            } else if (x1 < x2) {
                width = width - Math.abs(x1 - x2);
                setPosition(p);
            } else if (y1 > y2) {
                length = length + Math.abs(y1 - y2);
                setPosition(p);
            } else if (y1 < y2) {
                length = length - Math.abs(y1 - y2);
                setPosition(p);
            }
        }
        if (isUpperRight(getDraggingPoint())) {
            int x = x1 + width;
            int y = y1;
            if (x < x2 && y > y2) {
                width = width + Math.abs(x - x2);
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2));
            } else if (x > x2 && y < y2) {
                width = width - Math.abs(x - x2);
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2));
            } else if (x > x2) {
                width = width - Math.abs(x - x2);
                setPosition(new Point(x2 - width, y2));
            } else if (x < x2) {
                width = width + Math.abs(x - x2);
                setPosition(new Point(x2 - width, y2));
            } else if (y > y2) {
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2));
            } else if (y < y2) {
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2));
            }
        }

        if (isLowerRight(getDraggingPoint())) {
            int x = x1 + width;
            int y = y1 + length;
            if (x < x2 && y < y2) {
                width = width + Math.abs(x - x2);
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2 - length));
            } else if (x > x2 && y > y2) {
                width = width - Math.abs(x - x2);
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2 - length));
            } else if (x > x2) {
                width = width - Math.abs(x - x2);
                setPosition(new Point(x2 - width, y2 - length));
            } else if (x < x2) {
                width = width + Math.abs(x - x2);
                setPosition(new Point(x2 - width, y2 - length));
            } else if (y > y2) {
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2 - length));
            } else if (y < y2) {
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2 - width, y2 - length));
            }
        }
        if (isLowerLeft(getDraggingPoint())) {
            int x = x1;
            int y = y1 + length;
            if (x > x2 && y < y2) {
                width = width + Math.abs(x - x2);
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2, y2 - length));
            } else if (x < x2 && y > y2) {
                width = width - Math.abs(x - x2);
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2, y2 - length));
            } else if (x > x2) {
                width = width + Math.abs(x - x2);
                setPosition(new Point(x2, y2 - length));
            } else if (x < x2) {
                width = width - Math.abs(x - x2);
                setPosition(new Point(x2, y2 - length));
            } else if (y > y2) {
                length = length - Math.abs(y - y2);
                setPosition(new Point(x2, y2 - length));
            } else if (y < y2) {
                length = length + Math.abs(y - y2);
                setPosition(new Point(x2, y2 - length));
            }
        }
    }

}
