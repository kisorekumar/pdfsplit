package controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class FileChooserButtonListener implements EventHandler<ActionEvent> {
	private Text originalPDF;
	private Text outputPDF;
	private HBox hbox;
	
	public FileChooserButtonListener(Text originalPDF, Text outputPDF, HBox hbox) {
		this.originalPDF = originalPDF;
		this.outputPDF = outputPDF;
		this.hbox = hbox;
	}

	@Override
	public void handle(ActionEvent e) {

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {
			if(getFileExtension(selectedFile.getAbsolutePath()).equals("pdf")){
				originalPDF.setText("Selected PDF : " + selectedFile.getName());
				hbox.setVisible(true);
			}else{
				originalPDF.setText("Invalid file format.");
			}
		}
		else {
			originalPDF.setText("File selection cancelled.");
		}
	}
	
	
	public String getFileExtension(String fileName){
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i >= 0) {
		    extension = fileName.substring(i+1);
		}
		return extension;
	}
	
	
}