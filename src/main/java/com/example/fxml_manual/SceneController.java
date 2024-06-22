package com.example.fxml_manual;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    public SceneController(AnchorPane currentAnchorPane,String fxml) throws IOException {
        AnchorPane  nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(PixelBlitz.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);

    }
}
