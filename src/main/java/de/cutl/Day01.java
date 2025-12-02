package de.cutl;

import java.util.ArrayList;
import java.util.List;

/**
 * Day 01
 *
 */
public class Day01 {

    enum Direction {
        L,
        R;

        static Direction parse(String s) {
            if (s.equals("L")) {
                return L;
            }
            if (s.equals("R")) {
                return R;
            }
            throw new IllegalArgumentException("invalid direction " + s);
        }
    }

    record Rotation(Direction d, int steps) {};

    final List<Rotation> rotations = new ArrayList<>();
    private int position = 50;

    public Day01(List<String> lines) {
        for (String line : lines) {
            if  (line.isEmpty()) {
                continue;
            }
            var d = Direction.parse(line.substring(0, 1));
            var steps = Integer.parseInt(line.substring(1));
            this.rotations.add(new Rotation(d, steps));
        }

    }

    public int getPosition() {
        return position;
    }

    public int result() {
        int zeroCounter = 0;
        for (Rotation rotation : rotations) {
            if (rotation.d == Direction.R) {
                position += rotation.steps;
            } else {
                position -= rotation.steps;
            }
            position %= 100;

            if (position < 0) {
                position += 100;
            }

            if (position == 0) {
                zeroCounter++;
            }
        }
        return zeroCounter;
    }

    public int result_0x434C49434B() {
        int zeroCounter = 0;
        for (Rotation rotation : rotations) {
            System.out.printf("%s - position %d %n", rotation.toString(), position);

            int rounds = rotation.steps / 100;

            for (int i = 0; i < rounds; i++) {
                System.out.println("multiple-rounds: " + rounds);
                int part = updatePosition(rotation.d, 100);
                System.out.println("  Zeros: " + part);
                zeroCounter += part;
            }

            int leftSteps = rotation.steps % 100;

            int part =  updatePosition(rotation.d, leftSteps);
            System.out.println("  Zeros: " + part);
            zeroCounter += part;
        }
        return zeroCounter;
    }

    int updatePosition(Direction direction, int stepPart) {
        int zeroCounter = 0;
        int startPosition = position;

        if (direction == Direction.R) {
            System.out.printf("  %d + %d => %d %n", position, stepPart, position + stepPart);
            position += stepPart;
        } else {
            System.out.printf("  %d - %d => %d %n", position, stepPart, position - stepPart);
            position -= stepPart;
        }

        if (position > 100) {
            zeroCounter++;
        }

        position %= 100;

        if (position < 0) {
            position += 100;
            if (startPosition != 0) {
                zeroCounter++;
            }
        }

        if (position == 0) {
            zeroCounter++;
        }

        return zeroCounter;
    }
}
