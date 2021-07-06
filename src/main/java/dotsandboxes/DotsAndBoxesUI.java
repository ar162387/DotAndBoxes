package dotsandboxes;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class DotsAndBoxesUI {

    final int lineLength = 32;
    final int margin = 10;
    final int gap = 0;
    final int dotDiameter = 6;

    final DotsAndBoxesGrid grid;
    final AnchorPane anchorPane;

    public DotsAndBoxesUI(DotsAndBoxesGrid grid) {
        this.grid = grid;
        anchorPane = new AnchorPane();

        // Size the anchorPane to just contain the elements
        int width = margin + dotDiameter + gap + (grid.width - 1) * (gap + lineLength + gap + dotDiameter) + gap + margin;
        int height = margin + dotDiameter + gap + (grid.height - 1) * (gap + lineLength + gap + dotDiameter) + gap + margin;
        anchorPane.setPrefSize(width, height);


        // Lay out the horizontals
        for (int row = 0; row < grid.height; row++) {
            for (int col = 0; col < grid.width - 1; col++) {
                Line line = new Line(0, dotDiameter/2.0, lineLength, dotDiameter/2.0);
                line.setStrokeWidth(dotDiameter);
                line.setStroke(Color.DARKGREY);

                line.setOnMouseClicked((evt) -> line.setStroke(Color.RED));

                AnchorPane.setLeftAnchor(line, 0.0 + gap + dotDiameter + col * (gap + lineLength + gap + dotDiameter));
                AnchorPane.setTopAnchor(line, -dotDiameter/2.0 + gap + dotDiameter + row * (gap + lineLength + gap + dotDiameter));
                anchorPane.getChildren().add(line);
            }
        }

        // Lay out the verticals
        for (int row = 0; row < grid.height - 1; row++) {
            for (int col = 0; col < grid.width; col++) {
                Line line = new Line(-dotDiameter/2.0, 0, -dotDiameter/2.0, lineLength);
                line.setStrokeWidth(dotDiameter);
                line.setStroke(Color.DARKGREY);

                line.setOnMouseClicked((evt) -> line.setStroke(Color.RED));

                AnchorPane.setTopAnchor(line, 0.0 + gap + dotDiameter + row * (gap + lineLength + gap + dotDiameter));
                AnchorPane.setLeftAnchor(line, -dotDiameter/2.0 + gap + dotDiameter + col * (gap + lineLength + gap + dotDiameter));
                anchorPane.getChildren().add(line);
            }
        }

        // Lay out the dots
        for (int row = 0; row < grid.height; row++) {
            for (int col = 0; col < grid.width; col++) {
                Circle dot = new Circle(dotDiameter / 2.0);
                dot.setFill(Color.YELLOW);

                AnchorPane.setLeftAnchor(dot, gap + col * (gap + lineLength + gap + dotDiameter) + dotDiameter/2.0);
                AnchorPane.setTopAnchor(dot, gap + row * (gap + lineLength + gap + dotDiameter) + dotDiameter/2.0);
                anchorPane.getChildren().add(dot);
            }
        }



    }



}
