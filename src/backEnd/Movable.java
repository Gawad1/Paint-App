/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backEnd;

import java.awt.Point;

/**
 *
 * @author pc
 */
public interface Movable {

    public void setDraggingPoint(Point point);
    public Point getDraggingPoint();
    public boolean contains(Point point);
    public void moveTo(Point point);
}
