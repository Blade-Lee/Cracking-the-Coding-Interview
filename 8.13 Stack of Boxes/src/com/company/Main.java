package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Box {
        int height;
        int width;
        int depth;

        public Box(int a, int b, int c) {
            height = a;
            width = b;
            depth = c;
        }

        public boolean canBeAbove(Box b) {
            if (b.height > this.height || b.width > this.width || b.depth > this.depth) {
                return false;
            }
            return true;
        }
    }

    class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box a, Box b) {
            return b.height - a.height;
        }
    }

    public int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());

        int[] boxStack = new int[boxes.size()];

        return createStack(boxes, null, 0, boxStack);
    }

    public int createStack(ArrayList<Box> boxes, Box bottom, int index, int[] boxStack) {
        if (index == boxes.size()) {
            return 0;
        }
        Box newBottom = boxes.get(index);

        int with_new_bottom = 0;

        if (bottom == null || bottom.canBeAbove(newBottom)) {
            if (boxStack[index] == 0) {
                boxStack[index] = createStack(boxes, newBottom, index + 1, boxStack);
                boxStack[index] += newBottom.height;
            }
            with_new_bottom = boxStack[index];
        }

        int without_new_bottom = createStack(boxes, bottom, index + 1, boxStack);

        return Math.max(with_new_bottom, without_new_bottom);
    }
}
