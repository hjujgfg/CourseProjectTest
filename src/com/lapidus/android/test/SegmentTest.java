package com.lapidus.android.test;

import com.lapidus.android.primitives.Point;
import com.lapidus.android.primitives.Segment;

import junit.framework.TestCase;

public class SegmentTest extends TestCase {
	Segment s1, s2;
	public void testfindIntersection() {
		s1 = new Segment(1, 1, 7, 4);
		s2 = new Segment(2, 3.5f, 7, 1);
		Point res = s1.findIntersection(s2);
		assertEquals(4f, res.x);
		assertEquals(2.5f, res.y);
	}
	public void testSegmentInt() {
		s1 = new Segment(1, 1, 7, 4);
		s2 = new Segment(2, 3.5f, 7, 1);
		boolean res = s1.checkForIntersection(s2);
		assertEquals(true, res);
	}
	public void testSegmentInt2() {
		s1 = new Segment(1, 1, 1, 4);
		s2 = new Segment(2, 2, 2, 4);
		boolean res = s1.checkForIntersection(s2);
		assertEquals(false, res);
	}
}
