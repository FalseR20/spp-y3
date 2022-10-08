package lab3_1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class FloatSet {
    ArrayList<Float> array;

    FloatSet(Float... args) {
        array = new ArrayList<>();
        for (var element : args) {
            if (!array.contains(element))
                array.add(element);
        }
        Collections.sort(array);
    }

    @SuppressWarnings("unchecked")
    FloatSet(@NotNull FloatSet other) {
        array = (ArrayList<Float>) other.array.clone();
    }

    public void add(Float el) {
        if (!array.contains(el)) {
            array.add(el);
            Collections.sort(array);
        }
        else
            System.err.printf("WARNING: %f already exists in %s\n", el, this);
    }

    public void remove(Float el) {
        if (array.contains(el))
            array.remove(el);
        else
            System.err.printf("WARNING: %f doesn't exist in %s\n", el, this);
    }

    public int length() {
        return array.size();
    }

    @Override
    public String toString() {
        var output = array.toString();
        return String.format("FloatArray(%s)", output.substring(1, output.length() - 1));
    }

    public boolean contains(Float el) {
        return array.contains(el);
    }

    public boolean equals(@NotNull FloatSet other) {
        return array.equals(other.array);
    }

    public FloatSet or(@NotNull FloatSet other) {
        var newFloatArray = new FloatSet(this);
        for (var el : other.array) {
            if (!newFloatArray.array.contains(el))
                newFloatArray.array.add(el);
        }
        Collections.sort(newFloatArray.array);
        return newFloatArray;
    }

    public FloatSet and(@NotNull FloatSet other) {
        var newFloatArray = new FloatSet();
        for (var el : other.array) {
            if (array.contains(el))
                newFloatArray.array.add(el);
        }
        Collections.sort(newFloatArray.array);
        return newFloatArray;
    }
}
