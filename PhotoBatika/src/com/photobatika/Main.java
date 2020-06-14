package com.photobatika;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
	
	
	private Button btn1;
	private Button btn2;
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public int getAlpha(int c) {    	
    	return c >> 24 & 0xff;    	
    }
    
    public int setAlpha(int a, int c) {
    	return (c & 0xffffff) | (a << 24);
    }
    
    public int switchRG(int c) {
    	
    	int a = (c >> 24) & 0xff;
    	int r = (c >> 16) & 0xff;
    	int g = (c >> 8) & 0xff;
    	int b = (c) & 0xff;
    	
    	return (a << 24) | (g << 16) | (r << 8) | b;
    	
    	
    }
    
    
    
    public Scene createScene1() {
    
    	Image image = new Image("apple.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
    
        // Obtain PixelReader
        PixelReader pixelReader = image.getPixelReader();
       
       // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int)image.getWidth(),
                (int)image.getHeight());
        
        
        PixelWriter pixelWriter = wImage.getPixelWriter();
        
       // Determine the color of each pixel in a specified row
       for(int readY=0;readY<image.getHeight();readY++){
           for(int readX=0; readX<image.getWidth();readX++){
              
               pixelWriter.setArgb(readX, readY, switchRG(pixelReader.getArgb(readX, readY)));
               //System.out.println(getAlpha(pixelReader.getArgb(readX, readY)));	
               
           }
       }
       
       // Display image on screen
       imageView.setImage(wImage);
       
              
       
       btn1 = new Button();
       btn1.setText("Next");
       
       
       VBox vbox = new VBox(imageView, btn1);
       
       vbox.setAlignment(Pos.BASELINE_CENTER);
       
       
       
       
       //root.getChildren().add(btn);

       //root.getChildren().addAll(imageView, btn);
       Scene scene = new Scene(vbox, 800, 600);
       

       
       return scene;
       
    }
    

    
    public Scene createScene2() {
 

    	Image image = new Image("apple.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
    
        // Obtain PixelReader
        PixelReader pixelReader = image.getPixelReader();
       
       // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int)image.getWidth(),
                (int)image.getHeight());
        
        
        PixelWriter pixelWriter = wImage.getPixelWriter();
        
       // Determine the color of each pixel in a specified row
       for(int readY=0;readY<image.getHeight();readY++){
           for(int readX=0; readX<image.getWidth();readX++){
              
               pixelWriter.setArgb(readX, readY, pixelReader.getArgb(readX, readY));
               //System.out.println(getAlpha(pixelReader.getArgb(readX, readY)));	
               
           }
       }
       
       // Display image on screen
       imageView.setImage(wImage);
       
              
       
       btn2 = new Button();
       btn2.setText("Next");
       
       
       VBox vbox = new VBox(imageView, btn2);
       
       vbox.setAlignment(Pos.BASELINE_CENTER);
       
       
       
       
       //root.getChildren().add(btn);

       //root.getChildren().addAll(imageView, btn);
       Scene scene = new Scene(vbox, 800, 600);
       

       
       return scene;
       
    }
    
    

    
    public Scene createScene3() {
    	 

    	
    	Text t = new Text("Which one is real?");
    	
    	t.setFont(Font.font ("Verdana", 20));
    	t.setFill(Color.RED);
    	
    	
       VBox vbox = new VBox(t);
       
       vbox.setAlignment(Pos.CENTER);
       
       
       
       //root.getChildren().add(btn);

       //root.getChildren().addAll(imageView, btn);
       Scene scene = new Scene(vbox, 800, 600);
       

       
       return scene;
       
    }
    
    
    @Override
    public void start(Stage primaryStage) {
     
    	Scene scene1 = createScene1();
    	Scene scene2 = createScene2();
    	Scene scene3 = createScene3();
    	
    	
        primaryStage.setTitle("Photo Batika");
        primaryStage.setScene(scene1);
        primaryStage.show();
     
        
        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene2);
            }
        });
 
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene3);
            }
        });
        
        
        
        
        
    }
}