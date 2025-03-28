package controller;


import domain.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class VectorController {


    Alert alert;
    Vector vector;

    @javafx.fxml.FXML
    private TextField nTextField;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private Pane buttonPane;

    @javafx.fxml.FXML
    public void initialize(){

        this.alert = util.FXUtility.alert("Vector Algoriyhm" , "");
        alert.setAlertType(Alert.AlertType.ERROR);


    }

    @javafx.fxml.FXML
    void createOnAction(ActionEvent event) {
        try{

            int n = Integer.valueOf(this.nTextField.getText());
            if(isValid(n)){
                this.vector = new Vector(n);
                this.buttonPane.setDisable(false);

                this.textArea.setText("The vector has been created for " + n + "elemnts");
            } else{

            }

        }catch (Exception ex){
            alert.setContentText("Error Try again!");
            alert.show();
        }




    }

    private boolean isValid(int n){
        return n>0;
    }


}