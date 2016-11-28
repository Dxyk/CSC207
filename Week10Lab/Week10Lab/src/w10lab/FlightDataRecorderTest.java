package Week10Lab.src.w10lab;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class FlightDataRecorderTest {
	
	
	
	@Test
	public void testFlightDataRecorder() {
		assertEquals(10, FlightDataRecorder.CAPACITY);
	}

	@Test
	public void testAverage() {
		FlightDataRecorder fdr = new FlightDataRecorder();
		for (int i = 0; i < 10; i ++) {
			fdr.record((double) 2);
		}
		assertEquals(2, fdr.average(), 0.09);
	}

	@Test
	public void testGetLastDataPoints() {
		FlightDataRecorder fdr = new FlightDataRecorder();
		for (int i = 0; i < 10; i ++) {
			fdr.record((double) 2);
		}
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add((double) 2);
		expected.add((double) 2);
		expected.add((double) 2);
		assertEquals(expected, fdr.getLastDataPoints(3));
	}

	@Test
	public void testGetRecordedData() {
		FlightDataRecorder fdr = new FlightDataRecorder();
		for (int i = 0; i < 10; i ++) {
			fdr.record((double) 2);
		}
		ArrayList<Double> expected = new ArrayList<Double>();
		for (int i = 0; i < 10; i ++) {
			expected.add((double) 2);
		}
		assertEquals(expected, fdr.getRecordedData());
	}

	@Test
	public void testRecord() {
		FlightDataRecorder fdr = new FlightDataRecorder();
		fdr.record((double) 2);
		assertEquals((double) 2, fdr.getRecordedData().get(0), 0.05);
		
	}

}
