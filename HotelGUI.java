/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HotelGUI extends Application {

    @Override
    public void start(Stage stage) {

        // ===== Main Layout =====
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(30));
        grid.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));

        // ===== Welcome message =====
        Text welcomeMsg = new Text("Welcome to WAN Hotel System");
        welcomeMsg.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 18));
        welcomeMsg.setFill(Color.DARKBLUE);
        grid.add(welcomeMsg, 0, 0, 2, 1);

        // ===== Reservation ID input =====
        Label idLabel = new Label("Enter your reservation ID:");
        idLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(idLabel, 0, 1);

        TextField idField = new TextField();
        idField.setPromptText("e.g., 345");
        grid.add(idField, 1, 1);

        // ===== Output area =====
        TextArea infoArea = new TextArea();
        infoArea.setEditable(false);
        infoArea.setPrefHeight(160);
        grid.add(infoArea, 0, 2, 2, 1);

        // ===== Buttons =====
        Button checkBtn = new Button("Check Reservation");
        checkBtn.setTextFill(Color.WHITE);
        checkBtn.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));

        Button serviceBtn = new Button("Services");
        serviceBtn.setDisable(true);
        serviceBtn.setTextFill(Color.WHITE);
        serviceBtn.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));

        Button doneBtn = new Button("Done");
        doneBtn.setTextFill(Color.WHITE);
        doneBtn.setBackground(new Background(new BackgroundFill(Color.CRIMSON, null, null)));

        HBox buttons = new HBox(15, checkBtn, serviceBtn, doneBtn);
        buttons.setAlignment(Pos.CENTER);
        grid.add(buttons, 0, 3, 2, 1);

        // ===== Scene setup =====
        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Hotel Reservation System");
        stage.show();
        stage.setResizable(false);

        // ===== Event handling =====
        checkBtn.setOnAction(e -> {
            String input = idField.getText().trim();
            if (input.isEmpty()) {
                infoArea.setText(" Please enter your reservation ID.");
                return;
            }

            try {
                int id = Integer.parseInt(input);
                ArrayList<Reservation> reservations = HotelSystem.reservelist;
                Reservation found = null;

                for (Reservation r : reservations) {
                    if (r.getRESERVATION_ID() == id) {
                        found = r;
                        break;
                    }
                }

                if (found == null) {
                    infoArea.setText(" No reservation found with this ID.");
                    serviceBtn.setDisable(true);
                } else {
                    Accommodation acc = found.getAccommodation();
                    infoArea.setText(
                            " Reservation Found!\n\n" +
                                    "Guest: " + found.getGuest().getGuestName() + "\n" +
                                    "Reservation ID: " + found.getRESERVATION_ID() + "\n" +
                                    "Room Number: " + acc.getRoomNumber() + "\n" +
                                    "Type: " + acc.getClass().getSimpleName() + "\n" +
                                    "Price per night: " + acc.getPricePerNight() + " SAR\n" +
                                    "Total (with tax): " + found.calculateBill() + " SAR"
                    );

                    serviceBtn.setDisable(false);

                    // Attach type for later use
                    serviceBtn.setUserData(acc.getClass().getSimpleName());
                }

            } catch (NumberFormatException ex) {
                infoArea.setText(" Reservation ID must be a number.");
            }
        });

        // ===== Services button =====
        serviceBtn.setOnAction(e -> {
            String type = (String) serviceBtn.getUserData();

            if (type == null) return;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Available Services");

            switch (type.toLowerCase()) {
                case "singleroom":
                    alert.setContentText(
                            " Laundry Service\n️ Gym Access\n️ Restaurant Service\n Cleaning Service \n Wi-Fi");
                    break;

                case "doubleroom":
                    alert.setContentText(
                            " Laundry Service\n️ Gym Access\n️ Restaurant Service\n Cleaning Service \n Wi-Fi");
                    break;

                case "suite":
                    alert.setContentText(
                            " Laundry Service\n Gym Access\n Restaurant Service\n Cleaning Service\n Party Service \n Wi-Fi");
                    break;

                case "hall":
                    alert.setContentText(
                            "Cleaning Service\n️ Buffet Service\n Decoration Service");
                    break;

                default:
                    alert.setContentText("No specific services available.");
                    break;
            }

            alert.showAndWait();
        });

        // ===== Done button =====
        doneBtn.setOnAction(e -> {
            stage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

