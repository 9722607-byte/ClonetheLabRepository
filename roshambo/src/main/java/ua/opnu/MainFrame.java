package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    public GameShape generateShape() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0: return new Rock();
            case 1: return new Scissors();
            default: return new Paper();
        }
    }

    public int checkWinner(GameShape comp, GameShape player) {
        // Якщо класи однакові — нічия
        if (comp.getClass() == player.getClass()) {
            return 0;
        }

        // Логіка перемоги гравця:
        // Камінь перемагає Ножиці
        // Ножиці перемагають Папір
        // Папір перемагає Камінь
        if (player instanceof Rock) {
            return (comp instanceof Scissors) ? 1 : -1;
        } else if (player instanceof Scissors) {
            return (comp instanceof Paper) ? 1 : -1;
        } else if (player instanceof Paper) {
            return (comp instanceof Rock) ? 1 : -1;
        }

        return 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується хід комп'ютеру
        GameShape computerShape = generateShape();

        GameShape playerShape = null;
        // Визначаємо, на яку кнопку натиснув гравець
        switch (e.getActionCommand().toLowerCase()) {
            case "rock":
            case "камінь":
                playerShape = new Rock();
                break;
            case "paper":
            case "папір":
                playerShape = new Paper();
                break;
            case "scissors":
            case "ножиці":
                playerShape = new Scissors();
                break;
            default:
                playerShape = new GameShape();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Player shape: " + playerShape + ". Computer shape: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Computer has won!";
                break;
            case 0:
                message += "It's a tie!";
                break;
            case 1:
                message += "Player has won!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
