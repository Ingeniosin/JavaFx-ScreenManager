package me.juan.example;

import com.google.common.io.Resources;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import me.juan.screen.Controller;
import me.juan.screen.Screen;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new PrimaryScreen();
    }

    private static class PrimaryScreen extends Controller {

        @Getter
        private final Screen screen;

        @FXML private Button btn;
        @FXML private Label labelClicked;

        public PrimaryScreen() throws IOException {
            this.screen = new Screen(
                    Resources.getResource("example.fxml"), this, "Example Screen", 600, 400)
                    .enableMouseMoveEvent()
                    .setInitStyle(StageStyle.TRANSPARENT)
                    .setFill(Color.TRANSPARENT)
                    .setResizable(false);
            this.screen.show();
        }

        @Override
        public void initListeners() {
            btn.addEventHandler(EventType.ROOT, event -> {
            if (event instanceof MouseEvent) {
                MouseEvent mouseEvent = (MouseEvent) event;
                if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                    labelClicked.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                }
            }
            });
        }
    }

}
