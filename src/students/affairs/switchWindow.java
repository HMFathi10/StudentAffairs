/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.affairs;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Unknown PC
 */
public class switchWindow {
    public static void switchWindow(Stage window, Application app) {
    try {
        app.start(window);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
