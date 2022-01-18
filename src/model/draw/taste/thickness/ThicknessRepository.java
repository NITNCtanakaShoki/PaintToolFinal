package model.draw.taste.thickness;

public class ThicknessRepository implements Thicknessable {

    private float thickness;

    public ThicknessRepository() {
        thickness = 1.0f;
    }

    public void set(float thickness) {
        this.thickness = thickness;
    }

    @Override
    public float thickness() {
        return thickness;
    }
}
