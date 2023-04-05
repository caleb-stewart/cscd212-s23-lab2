package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        if(resolution >= 2160)
            this.fourK = true;
        else
            this.fourK = false;
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Bad EVC");
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        if(resolution >= 2160)
            this.fourK = true;
        else
            this.fourK = false;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String toString() {
        String res = "";
        if(!fourK)
            res = this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
        else if (fourK)
            res = this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with 4k resolution";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(Television another) {
        if(another == null)
            throw new IllegalArgumentException("Poor parameter in compareTo");
        if(this.make.compareTo(another.make) != 0)
            return this.make.compareTo(another.make);
        if(this.model.compareTo(another.model) != 0)
            return this.model.compareTo(another.model);
        return this.screenSize - another.screenSize;
    }
}
