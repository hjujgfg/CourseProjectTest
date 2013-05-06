package com.lapidus.android.test;



import com.lapidus.android.engine.Engine;

import com.lapidus.android.primitives.Point;
import com.threed.jpct.SimpleVector;

import junit.framework.TestCase;

public class EngineTest extends TestCase {
	public void testProcessPoints() {
		Point a, b, c;
		SimpleVector[] sv = new SimpleVector[4];
		a = new Point(4, 2, 0);
		b = new Point(10, 5, 0);
		c = new Point(13, 6, 0);
		Engine e = new Engine();
		
		e.renderer.processPoints(a, b, c, true, sv);
		assertEquals(4, sv.length);
	}
	public void testProcessPoints2() {
		Point a, b, c;
		SimpleVector[] sv = new SimpleVector[4];
		a = new Point(3, 10, 0);
		b = new Point(3, 3, 0);
		c = new Point(6, 1, 0);
		Engine e = new Engine();
		
		e.renderer.processPoints(a, b, c, true, sv);
		assertEquals(4, sv.length);
	}
}
