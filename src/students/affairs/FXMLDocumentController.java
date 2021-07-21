/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.affairs;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static students.affairs.ProjectRunController.connection;

public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField UserNameTF;
    @FXML
    private JFXPasswordField PasswordTF;
    @FXML
    private JFXCheckBox StaySignedInCB;
    @FXML
    private JFXButton SignInButton;
    @FXML
    private Text Forgettxt;
    @FXML
    private Text Createtxt;
    @FXML
    private AnchorPane MainAnchorPane;
    static ResultSet resultSet;
    static Connection connection;
    static PreparedStatement preparedStatement;

    public void Con() throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        connection = DriverManager.getConnection("jdbc:ucanaccess://LayhaDatabase.accdb");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainAnchorPane.setOpacity(0);
        makeFadeInTransition();
    }

    @FXML
    private void CloseSignInAction(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    private void SignINAction(ActionEvent event) throws InterruptedException, IOException {
        try {
            if (UserNameTF.getText().isEmpty() || PasswordTF.getText().isEmpty()) {
                if (UserNameTF.getText().isEmpty() && PasswordTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and password required");
                } else if (PasswordTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "password required");
                } else {
                    JOptionPane.showMessageDialog(null, "Username required");
                }
            } else {
                Con();
                preparedStatement = connection.prepareStatement("select * from Employee where SSN= '" + UserNameTF.getText() + "'");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (resultSet.getString("Password").equals(PasswordTF.getText())) {
                        closeMain();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void closeMain() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(MainAnchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                load();
            }
        });
        fadeTransition.play();
    }

    public void load() {
        try {
            Parent Sec = (AnchorPane) FXMLLoader.load(getClass().getResource("ProjectRun.fxml"));
            Scene newScene = new Scene(Sec);
            Stage curStage = (Stage) MainAnchorPane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (Exception e) {
        }
    }

    private void ForgetPasswordAction(MouseEvent event) {

    }

    @FXML
    private void CreateNewAccountAction(MouseEvent event) {
    }

    private void makeFadeInTransition() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(MainAnchorPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML
    private void ForgetPasswordExitAction(MouseEvent event) {
        Forgettxt.setFill(javafx.scene.paint.Color.WHITE);
    }

    @FXML
    private void ForgetPasswordEnterAction(MouseEvent event) {
        Forgettxt.setFill(javafx.scene.paint.Color.BLUEVIOLET);
    }

    @FXML
    private void CreateNewAccountExitAction(MouseEvent event) {
        Createtxt.setFill(javafx.scene.paint.Color.WHITE);

    }

    @FXML
    private void CreateNewAccountEnterAction(MouseEvent event) {
        Createtxt.setFill(javafx.scene.paint.Color.BLUEVIOLET);
    }

    @FXML
    private void EnterAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                if (UserNameTF.getText().isEmpty() || PasswordTF.getText().isEmpty()) {
                    if (UserNameTF.getText().isEmpty() && PasswordTF.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Username and password required");
                    } else if (PasswordTF.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "password required");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username required");
                    }
                } else {
                    Con();
                    preparedStatement = connection.prepareStatement("select * from Employee where SSN= '" + UserNameTF.getText() + "'");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        if (resultSet.getString("Password").equals(PasswordTF.getText())) {
                            closeMain();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
