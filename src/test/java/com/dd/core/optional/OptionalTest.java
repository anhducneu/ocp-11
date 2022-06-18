package com.dd.core.optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;



public class OptionalTest {

	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}

	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String name = "DD";
		Optional<String> nonNull = Optional.of(name);

		assertAll(
			() -> assertTrue(nonNull.isPresent()),
			() -> assertEquals(name, nonNull.get())
		);
	}

	@Test
	public void givenNull_whenCreate_thenThrowError() {
		String name = null;

		Exception exception = assertThrows(NullPointerException.class, () -> {
			Optional.of(name);
		});
		assertEquals(null, exception.getMessage());
	}

	@Test
	public void givenNull_whenCreateNullAble_thenCorrect() {
		String name = null;
		Optional<String> nullAble = Optional.ofNullable(name);

		assertFalse(nullAble.isPresent());
	}


	@Test
	public void givenOptional_whenIsPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("Baeldung");
		assertTrue(opt.isPresent());

		opt = Optional.ofNullable(null);
		assertFalse(opt.isPresent());
	}

	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
		Optional<String> opt = Optional.of("Baeldung");
		assertFalse(opt.isEmpty());

		opt = Optional.ofNullable(null);
		assertTrue(opt.isEmpty());
	}

	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("Baeldung");

		opt.ifPresent(System.out::println);
	}

	@Test
	public void whenOrElseWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("john");
		assertEquals("john", name);
	}

	@Test
	public void whenOrElseGetWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		assertEquals("john", name);
	}

	@Test
	public void whenOrElseThrowWorks_thenCorrect() {
		String nullName = null;

		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			String name = Optional.ofNullable(nullName).orElseThrow(
				IllegalArgumentException::new);
		});

	}

	@Test
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
		assertThrows(NoSuchElementException.class, () -> {
			Optional<String> opt = Optional.ofNullable(null);

			opt.ifPresent(System.out::println);
			String name = opt.get();
		});

	}

	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		assertTrue(is2016);
		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();

		yearOptional.ifPresentOrElse(
			(x) -> System.out.println(x),
			() -> System.out.println("Not found")
		);

		assertFalse(is2017);
	}

}
