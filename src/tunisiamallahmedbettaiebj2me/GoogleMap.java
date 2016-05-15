/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiamallahmedbettaiebj2me;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
 
import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
 
public class GoogleMap extends Canvas implements GoogleStaticMapHandler
{
	GoogleMaps gMaps = null;
	GoogleStaticMap map = null;
 
	public GoogleMap()
	{
		gMaps = new GoogleMaps();
 
		map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
 
		map.setHandler(this);
 
		map.setCenter(new GoogleMapsCoordinates(41.8954656, 12.4823243));
 
		map.setZoom(15);
 
		map.update();
	}
 
	protected void paint(Graphics g)
	{
		map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
	}
	public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage)
	{
		System.out.println("map error: " + errorCode + ", " + errorMessage);
	}
	public void GoogleStaticMapUpdated(GoogleStaticMap map)
	{
		repaint();
	}
}