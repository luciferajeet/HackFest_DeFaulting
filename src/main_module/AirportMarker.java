package main_module;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 * @author Team Defaulting
 * Date 3rd march 2016
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	public PointFeature feature;
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		feature = (PointFeature) city;
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(11);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		
	
	}
	
	public PointFeature getFeature(){
		return feature;
	}
	
}
