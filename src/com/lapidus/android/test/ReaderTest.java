package com.lapidus.android.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import com.lapidus.android.painter.*;

public class ReaderTest extends TestCase {
	public void testToArray() {
		Point[] p = new Point[7];
		ArrayList<Point> tst = new ArrayList<Point>();
		p = Reader.toArray(tst);
		assertEquals(true, true);
		v = new ReaderView(null);
	}
	ArrayList<Point> arr;
	ReaderView v;
	/*
	 * 0.....0
	 * 0.....0
	 * 0.....0
	 * 0001110
	 * 0001001
	 * 0111110
	 * 0001000
	 * 0001000	
	 */
	public void testProcessCollision1() {
		arr = new ArrayList<Point>();
		arr.add(new Point(3, 3));
		arr.add(new Point(4, 3));
		arr.add(new Point(5, 3));
		arr.add(new Point(3, 4));
		arr.add(new Point(6, 4));
		for (int i = 1; i < 6; i ++) {
			arr.add(new Point(i, 5));
		}
		arr.add(new Point(3, 6));
		arr.add(new Point(3, 7));
		Collision c = new Collision();
		Reader.processCollision(arr, arr.get(arr.size() - 2), c, arr.get(arr.size() - 1));
		assertEquals(3, c.getExitsQuantity());
	}
	public void testProcessCollision2() {
		arr = new ArrayList<Point>();
		for (int i = 1; i < 6; i ++) {
			arr.add(new Point(1, i));
		}
		arr.add(new Point(2, 1));
		arr.add(new Point(2, 2));
		arr.add(new Point(3, 0));
		arr.add(new Point(4, 0));
		Collision c = new Collision();
		Reader.processCollision(arr, arr.get(2), c, arr.get(3));
		assertEquals(1, c.getExitsQuantity());
	}
	public void testProcessCollision3() {
		arr = new ArrayList<Point>();
		for (int i = 0; i < 5; i++) {
			arr.add(new Point(0, i));
		}
		arr.add(new Point(1, 2));
		arr.add(new Point(2, 1));
		arr.add(new Point(2, 3));
		arr.add(new Point(3, 0));
		arr.add(new Point(3, 4));
		Collision c = new Collision();
		Reader.processCollision(arr, arr.get(3), c, arr.get(4));
		assertEquals(3, c.getExitsQuantity());
	}
	public void testProcessCollision4() {
		arr = new ArrayList<Point>();
		arr.add(new Point(42, 40));
		arr.add(new Point(42, 41));
		arr.add(new Point(43, 40));
		arr.add(new Point(43, 41));
		arr.add(new Point(44, 41));
		arr.add(new Point(45, 41));
		arr.add(new Point(46, 41));
		Collision c = new Collision();
		Reader.processCollision(arr, arr.get(0), c, arr.get(0));
		assertEquals(1, c.getExitsQuantity());
	}
	
	public void testdoLine() {
		arr = new ArrayList<Point>();
		arr.add(new Point(1, 10));
		arr.add(new Point(2, 9));
		arr.add(new Point(3, 8));
		arr.add(new Point(2, 7));
		arr.add(new Point(1, 6));
		for (int i = 1; i < 6; i ++) {
			arr.add(new Point(1, i));
		}
		arr.add(new Point(2, 1));
		arr.add(new Point(2, 2));
		arr.add(new Point(3, 0));
		arr.add(new Point(4, 0));
		Track t = new Track();
		Reader.doLine(arr.get(0), arr, t, v);
		assertEquals(3, t.getLines().size());
	}
	public void testdoLine2() {
		arr = new ArrayList<Point>();
		arr.add(new Point(3, 3));
		arr.add(new Point(4, 3));
		arr.add(new Point(5, 3));
		arr.add(new Point(3, 4));
		arr.add(new Point(6, 4));
		for (int i = 1; i < 6; i ++) {
			arr.add(new Point(i, 5));
		}
		arr.add(new Point(0, 4));
		arr.add(new Point(3, 6));
		arr.add(new Point(3, 7));
		arr.add(new Point(4, 8));
		arr.add(new Point(5, 9));
		arr.add(new Point(6, 8));
		
		Track t = new Track();
		Reader.doLine(arr.get(arr.size() - 1), arr, t, v);
		assertEquals(3, t.getLines().size());
	}
	public void testdoLine3() {
		arr = new ArrayList<Point>();
		arr.add(new Point(42, 40));
		arr.add(new Point(42, 41));
		arr.add(new Point(43, 40));
		arr.add(new Point(43, 41));
		arr.add(new Point(44, 41));
		arr.add(new Point(45, 41));
		arr.add(new Point(46, 41));
		for (int i = 1; i < 6; i ++) {
			arr.add(new Point(46 + i, 41));
		}
		Track t = new Track();
		Reader.doLine(arr.get(0), arr, t, v);
		assertEquals(2, t.getLines().size());
	}
}
