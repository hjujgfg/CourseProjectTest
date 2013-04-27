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
	}
	ArrayList<Point> arr;
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
}
