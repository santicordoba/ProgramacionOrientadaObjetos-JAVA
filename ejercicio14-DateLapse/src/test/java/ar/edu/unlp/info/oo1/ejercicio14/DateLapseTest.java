package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	private DateLapse lapso1;
	private DateLapse lapso2;

	@BeforeEach
	public void setUp() {
		lapso1= new DateLapseTo(LocalDate.of(2021, 6, 8), LocalDate.of(2021, 6, 30));
		lapso2= new DateLapseSize(LocalDate.of(2021, 6, 29), 1);
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(22, lapso1.sizeInDays());
		assertEquals(1, lapso2.sizeInDays());
	}
	
	@Test
	public void testIncludesDate() {
		LocalDate otherDate= LocalDate.of(2021, 6, 25);
		LocalDate otherDate2= LocalDate.of(2021, 12, 25);
		assertTrue(lapso1.includesDate(otherDate));
		assertFalse(lapso1.includesDate(otherDate2));
		LocalDate limite= LocalDate.of(2021, 6, 8);
		assertTrue(lapso1.includesDate(limite));
		LocalDate otherDate3= LocalDate.of(2021, 12, 25);
		LocalDate otherDate4= LocalDate.of(2021, 6, 30);
		assertTrue(lapso2.includesDate(otherDate4));
		assertFalse(lapso2.includesDate(otherDate3));
	}
	
}
