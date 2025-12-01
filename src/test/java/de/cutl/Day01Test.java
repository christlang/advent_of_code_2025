package de.cutl;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class Day01Test {

    @Test
    void exampleL50() {

        Day01 day01 = new Day01(List.of("L50"));

        assertEquals(1, day01.result());
    }

    @Test
    void exampleR50() {

        Day01 day01 = new Day01(List.of("R50"));

        assertEquals(1, day01.result());
    }

    @Test
    void exampleSomeSteps() {

        Day01 day01 = new Day01(List.of("R50", "R100"));

        assertEquals(2, day01.result());
    }

    @Test
    void position1() {

        Day01 day01 = new Day01(List.of("R50", "R1"));

        day01.result();

        assertEquals(1, day01.getPosition());
    }

    @Test
    void positionMinus1() {

        Day01 day01 = new Day01(List.of("R50", "L1"));

        day01.result();

        assertEquals(99, day01.getPosition());
    }

    @Test
    void positionMinus101() {

        Day01 day01 = new Day01(List.of("R50", "L201"));

        day01.result();

        assertEquals(99, day01.getPosition());
    }

    @Test
    void positionExample() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("tasks/day01_example.txt"));

        Day01 day01 = new Day01(strings);

        assertEquals(3, day01.result());
    }

    @Test
    void positionTask() throws IOException {
        List<String> strings = Files.readAllLines(Path.of("tasks/day01_input.txt"));

        Day01 day01 = new Day01(strings);

        assertEquals(1023, day01.result());
    }
}
