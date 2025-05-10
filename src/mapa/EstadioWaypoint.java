/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author chemo
 */
public class EstadioWaypoint extends DefaultWaypoint
{

    private final String label;

    public EstadioWaypoint(GeoPosition coord, String label)
    {
        super(coord);
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }
}
