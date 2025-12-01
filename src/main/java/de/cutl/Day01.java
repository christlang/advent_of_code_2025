package de.cutl;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
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
}
