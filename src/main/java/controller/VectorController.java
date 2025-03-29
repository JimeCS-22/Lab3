package controller;


import domain.Vector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;

import java.util.Optional;

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
    public void initialize() {
        this.alert = util.FXUtility.alert("Vector Algorithm", " ");
        alert.setAlertType(Alert.AlertType.ERROR);

    }

    @javafx.fxml.FXML
    public void createOnAction(ActionEvent actionEvent) {


        try {
            int n = Integer.valueOf(this.nTextField.getText());

            this.vector = new Vector(n);
            this.buttonPane.setDisable(false);
            this.textArea.setText("The vector has been created for " + n + " elements");


        } catch (Exception ex) {

            alert.setContentText("Error... Try again");
            alert.show();

        }


    }


    @javafx.fxml.FXML
    public void FillOnAction(ActionEvent actionEvent) {

        int n = Integer.valueOf(this.nTextField.getText());

        this.textArea.clear();

        vector.fill();
        this.textArea.setText(String.valueOf(vector));


    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        this.vector.clear();
        this.nTextField.clear();
        this.textArea.clear();
        this.buttonPane.setDisable(true);

    }

    @javafx.fxml.FXML
    public void SizeOnAction(ActionEvent actionEvent) {

        vector.fill();
        int n = vector.size();
        this.textArea.setText(String.valueOf(n));

    }
    @javafx.fxml.FXML
    public void removeValueOnAction(ActionEvent actionEvent) {
        // Pedir al usuario que ingrese el numero a borrar
        TextInputDialog dialog = util.FXUtility.dialog("Vector - Remove Element", "Enter the element to remove:");
        dialog.setTitle("Vector - Remove Element");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            String input = result.get();


                int element = Integer.parseInt(input.trim());


                boolean removed = this.vector.remove(Integer.valueOf(element));

                if (removed) {
                    this.textArea.setText("Element " + element + " was successfully removed.");
                } else {
                    this.textArea.setText("Element " + element + " not found in the vector.");
                }

        } else {
            this.textArea.setText("No input provided.");
        }
    }


    @javafx.fxml.FXML
    public void addIndexOnAction(ActionEvent actionEvent) {
        // Pedir al usuario que ingrese el índice y el valor a agregar
        TextInputDialog dialog = util.FXUtility.dialog("Vector - Add by Index", "Enter the index and element to add (comma separated)");
        dialog.setTitle("Vector - Add by Index");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            String[] input = result.get().split(",");
            if (input.length == 2) {
                try {
                    int index = Integer.parseInt(input[0].trim());
                    int element = Integer.parseInt(input[1].trim());
                    this.vector.add(index, element);
                    this.textArea.setText("Added element at index " + index + ": " + element + "\n" + "Updated vector: " + this.vector.toString());
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    alert.setContentText("Invalid input. Please enter index and element in correct format.");
                    alert.show();
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void removeIndexOnAction(ActionEvent actionEvent) {
        // Pedir al usuario que ingrese el índice a eliminar
        TextInputDialog dialog = util.FXUtility.dialog("Vector - Remove by Index", "Enter the index to remove");
        dialog.setTitle("Vector - Remove by Index");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                int index = Integer.parseInt(result.get());
                Object removedElement = this.vector.remove(index);
                if ((int)removedElement != -1) {
                    this.textArea.setText("Removed element at index " + index + ": " + removedElement + "\n" + "Updated vector: " + this.vector.toString());
                } else {
                    alert.setContentText("Index out of range.");
                    alert.show();
                }
            } catch (NumberFormatException e) {
                alert.setContentText("Please enter a valid number.");
                alert.show();
            }
        }
    }

    @javafx.fxml.FXML
    public void containsOnAction(ActionEvent actionEvent) {
        // Pedir al usuario que ingrese el valor a verificar
        TextInputDialog dialog = util.FXUtility.dialog("Vector - Contains", "Enter the element to check");
        dialog.setTitle("Vector - Check Element");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                int element = Integer.parseInt(result.get());
                boolean contains = this.vector.contains(element);
                if (contains) {
                    this.textArea.setText("The vector contains the element: " + element);
                } else {
                    this.textArea.setText("The vector does not contain the element: " + element);
                }
            } catch (NumberFormatException e) {
                alert.setContentText("Please enter a valid number.");
                alert.show();
            }
        }
    }

    @javafx.fxml.FXML
    public void addValueOnAction(ActionEvent actionEvent) {
        // Pedir al usuario que ingrese el valor a agregar
        TextInputDialog dialog = util.FXUtility.dialog("Vector - Add by Value", "Enter the element to add");
        dialog.setTitle("Vector - Add Value");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                int element = Integer.parseInt(result.get());
                this.vector.add(element);
                this.textArea.setText("Added element: " + element + "\n" + "Updated vector: " + this.vector.toString());
            } catch (NumberFormatException e) {
                alert.setContentText("Please enter a valid number.");
                alert.show();
            }
        }
    }

}
