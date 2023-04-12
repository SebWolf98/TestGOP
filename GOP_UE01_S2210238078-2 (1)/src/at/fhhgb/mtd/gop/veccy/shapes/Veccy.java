package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.features.CircleFeature;
import at.fhhgb.mtd.gop.features.LineFeature;
import at.fhhgb.mtd.gop.features.PointFeature;
import at.fhhgb.mtd.gop.features.RectangleFeature;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.VeccyGUI;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        Circle c;
        c = new Circle(256, 128, 64);
        c.fill = Color.RED;
        c.stroke = Color.WHITE;
        c.setTransform(TransformFactory.createVerticalMirroring()); // :D
        model.addShape(c);

        c = new Circle(256, 128, 32);
        c.fill = Color.RED;
        c.stroke = Color.WHITE;
        c.setTransform(TransformFactory.createScaling(2, 1));
        model.addShape(c);

        Rectangle r;
        r = new Rectangle(256, 256, 128, 64);
        r.fill = Color.BLUE;
        r.stroke = Color.RED;
        r.setTransform(TransformFactory.createTranslation(-16, 16));
        model.addShape(r);

        r = new Rectangle(64, 64, 32, 32);
        r.fill = Color.BLUE;
        r.stroke = Color.RED;
        r.setTransform(TransformFactory.createRotation(.5));
        model.addShape(r);

        model.addFeature(new RectangleFeature(model));
        model.addFeature(new CircleFeature(model));
        model.addFeature(new LineFeature(model));
        model.addFeature(new PointFeature(model));

    }
}

