// Подключаем необходимые библиотеки для работы с графическим интерфейсом
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SelectTheGame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[4];

    // Интерфейс первого окна
    SelectTheGame() {

        frame = new JFrame("TicTacToe");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Верхнее окошко c приветствием
        textfield.setBackground(new Color(44, 41, 41));
        textfield.setForeground(new Color(225, 225, 225));
        textfield.setFont(new Font("", Font.BOLD, 50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Welcome to the TicTacToe game!");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 300);

        button_panel.setLayout(new GridLayout(4, 1));
        button_panel.setBackground(new Color(150, 150, 150));

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        // Кнопка для выборы режима игры 3х3
        buttons[0] = new JButton("3x3 game");
        button_panel.add(buttons[0]);
        buttons[0].setFont(new Font("", Font.BOLD, 50));
        buttons[0].setFocusable(false);
        buttons[0].addActionListener(this);
        buttons[0].setBackground(new Color(44, 41, 41));
        buttons[0].setForeground(new Color(225, 225, 225));

        // Кнопка для выборы режима игры 5х5
        buttons[1] = new JButton("5x5 game");
        button_panel.add(buttons[1]);
        buttons[1].setFont(new Font("", Font.BOLD, 50));
        buttons[1].setFocusable(false);
        buttons[1].addActionListener(this);
        buttons[1].setBackground(new Color(44, 41, 41));
        buttons[1].setForeground(new Color(225, 225, 225));

        // Кнопка для выборы режима игры 5х5
        buttons[2] = new JButton("10x10 game");
        button_panel.add(buttons[2]);
        buttons[2].setFont(new Font("", Font.BOLD, 50));
        buttons[2].setFocusable(false);
        buttons[2].addActionListener(this);
        buttons[2].setBackground(new Color(44, 41, 41));
        buttons[2].setForeground(new Color(225, 225, 225));

        buttons[3] = new JButton("Random level");
        button_panel.add(buttons[3]);
        buttons[3].setFont(new Font("", Font.BOLD, 50));
        buttons[3].setFocusable(false);
        buttons[3].addActionListener(this);
        buttons[3].setBackground(new Color(44, 41, 41));
        buttons[3].setForeground(new Color(225, 225, 225));

    }

    // Метод, отвечающий за выбор игры: 3х3 или 5х5 или 10x10
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) { // выбор игры 3х3
            frame.dispose();
            TicTacToe3x3 Window3x3 = new TicTacToe3x3();
        }
        else if (e.getSource() == buttons[1]) { // выбор игры 5х5
            frame.dispose();
            TicTacToe5x5 Window5x5 = new TicTacToe5x5();
        }
        else if (e.getSource() == buttons[2]) { // выбор игры 10х10
            frame.dispose();
            TicTacToe10x10 Window10x10 = new TicTacToe10x10();
        }
        else if (e.getSource() == buttons[3]) {
            if (random.nextInt(4) == 0) {
                frame.dispose();
                TicTacToe3x3 Window3x3 = new TicTacToe3x3();
            }
            else if  (random.nextInt(4) == 1) {
                frame.dispose();
                TicTacToe5x5 Window5x5 = new TicTacToe5x5();
            }
            // Выбор рандомной игры
            else if (random.nextInt(4) == 2) {
                frame.dispose();
                TicTacToe10x10 Window10x10 = new TicTacToe10x10();
            }
        }
    }
}
