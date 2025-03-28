package util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputDialog;

public class FXUtility {

    public static Alert alert (String title , String textHeader){

        Alert myalert = new Alert(Alert.AlertType.NONE);
        myalert.setAlertType(Alert.AlertType.ERROR);
        myalert.setTitle("Vector Algorithm");
        myalert.setHeaderText(textHeader);
        //myalert.show();
        return myalert;
    }

    public static TextInputDialog dialog (String title , String header){
        TextInputDialog dialog = new TextInputDialog(title);
        dialog.setHeaderText(header);
        return dialog;
    }
}
