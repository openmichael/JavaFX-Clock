import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DisplayClock extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane  borderPane = new BorderPane();
		Label lCurrentTime = new Label();
		
		final Timeline timeline = new Timeline(
			new KeyFrame(
				Duration.millis(1000),
				event -> {
					ClockPane clock = new ClockPane();
					borderPane.setCenter(clock);
					String timeString = "";
					
					if(clock.getMinute() < 10 && clock.getSecond() < 10) {
						timeString = "Current Time: " + clock.getHour() + ":" + "0" + clock.getMinute() + ":" + "0" + clock.getSecond();
					} else if(clock.getMinute() < 10) {
						timeString = "Current Time: " + clock.getHour() + ":" + "0" + clock.getMinute() + ":" + clock.getSecond();
					} else if(clock.getSecond() < 10) {
						timeString = "Current Time: " + clock.getHour() + ":" + clock.getMinute() + ":" + "0" + clock.getSecond();
					} else {
						timeString = "Current Time: " + clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
					}
					
					lCurrentTime.setText(timeString);
				}
			)				
		);
		
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		borderPane.setBottom(lCurrentTime);
		BorderPane.setAlignment(lCurrentTime, Pos.TOP_CENTER);
		Scene scene = new Scene(borderPane, 250, 250);
		
		primaryStage.setTitle("Display Clock");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
