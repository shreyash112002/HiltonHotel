package com.example.hiltonhotel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deletecontroller extends NullPointerException {
    @FXML
    private Label label;
    @FXML
    private TextField tf_gid;
    @FXML
    protected  void delete(ActionEvent e) {

        String Guest_id = tf_gid.getText();


        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        PreparedStatement pdelete,pscheck = null;
        try {
            pscheck = connectdb.prepareStatement("select * from guest_info1 where Guest_id= ?");
            pscheck.setString(1, Guest_id);
            ResultSet resultSet = pscheck.executeQuery();
            if (resultSet.isBeforeFirst()) {
                pdelete=connectdb.prepareStatement("delete from guest_info1 where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from guest_info2 where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from banquet where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from finance where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from housekeeping where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from laundry where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from restaurant where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();
                pdelete=connectdb.prepareStatement("delete from roomdetail where Guest_id=?");
                pdelete.setString(1,Guest_id);
                pdelete.executeUpdate();



                label.setText("Deleted Successfully!!");



            } else {
                Alert ep = new Alert(Alert.AlertType.ERROR);
                ep.setContentText("Guest Does not Exists.");
                ep.show();
            }
            }catch (SQLException ep)
        {
            ep.printStackTrace();
        }

    }
    @FXML
    protected void gobck(ActionEvent e)

    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ep) {
            ep.printStackTrace();
        }}
}
