package dotsandboxes;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class DotsAndBoxesUI {

    final int lineLength = 32;
    final int margin = 10;
    final int gap = 0;
    final int dotDiameter = 6;

    final DotsAndBoxesGrid grid;
    final AnchorPane anchorPane;
    final Label label;

    /** Colours for the different players. Only goes up to 5. */
    final Color[] playerColours = { Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE, Color.ORANGE };

    private void updateLabel() {
        label.setTextFill(playerColours[grid.getPlayer()]);
        label.setText(String.format("Player %d's turn", grid.getPlayer()));
    }

    public DotsAndBoxesUI(final DotsAndBoxesGrid grid) {
        this.grid = grid;
        anchorPane = new AnchorPane();

        label = new Label("");
        updateLabel();
        grid.addConsumer((g) -> updateLabel());

        // Size the anchorPane to just contain the elements
        int width = margin + dotDiameter + gap + (grid.width - 1) * (gap + lineLength + gap + dotDiameter) + gap + margin;
        int height = margin + dotDiameter + gap + (grid.height - 1) * (gap + lineLength + gap + dotDiameter) + gap + margin;
        anchorPane.setPrefSize(width, height);


        // Lay out the boxes
        for (int row = 0; row < grid.height - 1; row++) {
            for (int col = 0; col < grid.width - 1; col++) {
                final int x = col;
                final int y = row;
                Rectangle box = new Rectangle(gap, gap, lineLength, lineLength);
                box.setFill(Color.WHITE);

                grid.addConsumer((g) -> {
                    box.setFill(playerColours[g.getBoxOwner(x, y)]);
                });

                AnchorPane.setLeftAnchor(box, gap + dotDiameter + col * (gap + lineLength + gap + dotDiameter) + dotDiameter/2.0);
                AnchorPane.setTopAnchor(box, gap + dotDiameter + row * (gap + lineLength + gap + dotDiameter) + dotDiameter/2.0);
                anchorPane.getChildren().add(box);
            }
        }

        // Lay out the horizontals
        for (int row = 0; row < grid.height; row++) {
            for (int col = 0; col < grid.width - 1; col++) {
                Line line = new Line(0, dotDiameter/2.0, lineLength, dotDiameter/2.0);
                line.setStrokeWidth(dotDiameter);
                line.setStroke(Color.DARKGREY);

                final int x = col;
                final int y = row;
                grid.addConsumer((g) -> {
                    if (g.getHorizontal(x, y)) {
                        line.setStroke(Color.BLACK);
                    } else {
                        line.setStroke(Color.LIGHTGRAY);
                    }
                });

                line.setOnMouseClicked((evt) -> {try {
                    grid.drawHorizontal(x, y, grid.getPlayer());
                } catch (IllegalStateException ex) {
                    // do nothing
                    // This is a little artificial, as normally we'd implement this with a check that the line isn't
                    // already "drawn" and then not calling the function. But for the exercise, we wanted students
                    // to write a test that would ensure an exception is thrown, so we're relying on an exception
                    // being thrown!
                }});

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

                final int x = col;
                final int y = row;
                grid.addConsumer((g) -> {
                    if (g.getVertical(x, y)) {
                        line.setStroke(Color.BLACK);
                    } else {
                        line.setStroke(Color.LIGHTGRAY);
                    }
                });

                line.setOnMouseClicked((evt) -> {try {
                    grid.drawVertical(x, y, grid.getPlayer());
                } catch (IllegalStateException ex) {
                    // do nothing
                }});

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
