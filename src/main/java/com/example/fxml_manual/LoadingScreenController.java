package com.example.fxml_manual;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
public class LoadingScreenController {
    @FXML
    private ProgressBar progressBar;

    private Runnable onLoadingComplete;

    public void setProgress(double progress) {
        progressBar.setProgress(progress);
        if (progress >= 1.0) {
            if (onLoadingComplete != null) {
                onLoadingComplete.run();
            }
        }
    }

    public void setOnLoadingComplete(Runnable onLoadingComplete) {
        this.onLoadingComplete = onLoadingComplete;
    }
}
