/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class WriteText {
    private Formatter output;

    public void openTextFile(String fileName) {
        try {
            output = new Formatter(fileName);
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            System.err.println(ex);
        }
    }

    public void writeToFile(Accommodation ele) {

        try {
            output.format(ele.toString() + "\n");
            output.format("\n-----------------------------------------------------------------\n");
        } catch (FormatterClosedException ex) {
            System.err.println("Error writing to file");
            System.err.println(ex);
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
}