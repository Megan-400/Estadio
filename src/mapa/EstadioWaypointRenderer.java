/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointRenderer;
import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author chemo
 */
public class EstadioWaypointRenderer implements WaypointRenderer<EstadioWaypoint>
{

    @Override
    public void paintWaypoint(Graphics2D g, JXMapViewer map, EstadioWaypoint wp)
    {
        try
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/pin_estadio.png"));
            Image img = icon.getImage();

            Point2D pt = map.getTileFactory().geoToPixel(wp.getPosition(), map.getZoom());
            int x = (int) pt.getX() - img.getWidth(null) / 2;
            int y = (int) pt.getY() - img.getHeight(null);

            g.drawImage(img, x, y, null);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString(wp.getLabel(), x - 10, y - 5);
        } catch (Exception e)
        {
            System.err.println("Error al cargar el icono del marcador: " + e.getMessage());
        }
    }
}
