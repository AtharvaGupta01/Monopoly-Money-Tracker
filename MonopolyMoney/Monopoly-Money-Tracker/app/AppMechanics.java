package app;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AppMechanics
{
    public static void add(final JTextArea text, final int numToAdd, final MainGui Gui) {
        int current = 0;
        try {
            current = Integer.parseInt(text.getText().trim());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
            return;
        }
        text.setText(new StringBuilder(String.valueOf(current + numToAdd)).toString());
    }
    
    public static void subtract(final JTextArea text, final int numToSub, final MainGui Gui) {
        int current = 0;
        try {
            current = Integer.parseInt(text.getText().trim());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
            return;
        }
        text.setText(new StringBuilder(String.valueOf(current - numToSub)).toString());
    }
    
    public static void set(final JTextArea text, final String textToSet, final MainGui Gui) {
        text.setText(textToSet);
    }
    
    public static void transfer(final JTextArea text, final MainGui Gui) {
        final Object[] players = { "Player 1", "Player 2", "Player 3", "Player 4" };
        final String player = (String)JOptionPane.showInputDialog(Gui, "Which player would you like to give money to?", "Input", -1, null, players, "Player 1");
        final String current = JOptionPane.showInputDialog(Gui, "How much would you like to give to " + player + "?", "Input");
        int curint = 0;
        try {
            curint = Integer.parseInt(current);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Gui, "The value you entered is not a Number!", "Error", 0);
            return;
        }
        if (player.equals("Player 1")) {
            try {
                Gui.p1Money.setText(new StringBuilder(String.valueOf(Integer.parseInt(Gui.p1Money.getText()) + curint)).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player1.getText() + "'s money is not a number!", "Error", 0);
                return;
            }
            try {
                text.setText(new StringBuilder(String.valueOf(Integer.parseInt(text.getText()) - curint)).toString());
                return;
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
                return;
            }
        }
        if (player.equals("Player 2")) {
            try {
                Gui.p2Money.setText(new StringBuilder(String.valueOf(Integer.parseInt(Gui.p2Money.getText()) + curint)).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player2.getText() + "'s money is not a number!", "Error", 0);
                return;
            }
            try {
                text.setText(new StringBuilder(String.valueOf(Integer.parseInt(text.getText()) - curint)).toString());
                return;
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
                return;
            }
        }
        if (player.equals("Player 3")) {
            try {
                Gui.p3Money.setText(new StringBuilder(String.valueOf(Integer.parseInt(Gui.p3Money.getText()) + curint)).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player3.getText() + "'s money is not a number!", "Error", 0);
                return;
            }
            try {
                text.setText(new StringBuilder(String.valueOf(Integer.parseInt(text.getText()) - curint)).toString());
                return;
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
                return;
            }
        }
        if (player.equals("Player 4")) {
            try {
                Gui.p4Money.setText(new StringBuilder(String.valueOf(Integer.parseInt(Gui.p4Money.getText()) + curint)).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player4.getText() + "'s money is not a number!", "Error", 0);
                return;
            }
            try {
                text.setText(new StringBuilder(String.valueOf(Integer.parseInt(text.getText()) - curint)).toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", 0);
            }
        }
    }
    
    public static void rollDice(final MainGui Gui) {
        int times = 0;
        int faces = 0;
        try {
            times = Integer.parseInt(Gui.RollNum.getText().trim());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Gui, "The value entered in rolls is not a number!", "Error", 0);
            return;
        }
        try {
            faces = Integer.parseInt(Gui.RollSides.getText().trim());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Gui, "The value entered in Sides is not a number!", "Error", 0);
            return;
        }
        if (times == 1) {
            final int random = (int)(Math.random() * faces + 1.0);
            JOptionPane.showMessageDialog(Gui, "You rolled a " + random + "!", "Roll Result", -1);
        }
        else if (times <= 0) {
            JOptionPane.showMessageDialog(Gui, "The value entered in times is not a positive number!", "Error", 0);
        }
        else {
            final int[] randoms = new int[times];
            for (int i = 0; i < times; ++i) {
                randoms[i] = (int)(Math.random() * faces + 1.0);
            }
            JOptionPane.showMessageDialog(Gui, "You rolled a... " + concatIntArray(randoms) + "and the sum of these numbers is " + addIntArray(randoms) + "!", "Roll Result", -1);
        }
    }
    
    private static String concatIntArray(final int[] numbs) {
        String num = "\n";
        for (int i = 0; i < numbs.length; ++i) {
            num = String.valueOf(num) + numbs[i] + "\n";
        }
        return num;
    }
    
    private static int addIntArray(final int[] numbs) {
        int num = 0;
        for (int i = 0; i < numbs.length; ++i) {
            num += numbs[i];
        }
        return num;
    }
}
