package at.fhhgb.mtd.gop.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;

public abstract class Feature<T> implements NamedFeature {
    public boolean active = false;
    protected CanvasModel model;
    protected T activeShape;
    protected int startX = 0;
    protected int startY = 0;

    public Feature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public void onSelect() {
        active = true;
    }

    @Override
    public void onDeselect() {
        active = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (active) {
            if (activeShape != null) {
                activeShape = null;
            }
        }
    }

    @Override
    public abstract String getName();

    @Override
    public abstract void onMouseDrag(int x, int y);
}
