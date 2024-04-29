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
public abstract class AbstractShape implements Shape, Movable {

    private Point position;
    private Point draggingPoint;
    private Color color;
    private Color fillColor;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public AbstractShape(Point position) {
        this.position = position;
    }

    public AbstractShape() {

    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void draw(Graphics canvas) {

    }

    @Override
    public void setDraggingPoint(Point point) {
        this.draggingPoint = point;
    }

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    @Override
    abstract public boolean contains(Point point);

    @Override
    abstract public void moveTo(Point point);

    abstract public void resize(Point p);
}
