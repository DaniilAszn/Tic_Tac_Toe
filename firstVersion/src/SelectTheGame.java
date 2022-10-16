// Подключаем необходимые библиотеки для работы с графическим интерфейсом
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectTheGame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[2];

    // Интерфейс первого окна
    SelectTheGame() {

        frame = new JFrame("TicTacToe");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Верхнее окошко c приветствием
        textfield.setBackground(new Color(44, 41, 41));
        textfield.setForeground(new Color(225, 225, 225));
        textfield.setFont(new Font("",Font.BOLD,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Welcome to the TicTacToe game!");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,300);

        button_panel.setLayout(new GridLayout(2,1));
        button_panel.setBackground(new Color(150,150,150));

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        // Кнопка для выборы режима игры 3х3
        buttons[0] = new JButton("3x3 game");
        button_panel.add(buttons[0]);
        buttons[0].setFont(new Font("",Font.BOLD,50));
        buttons[0].setFocusable(false);
        buttons[0].addActionListener(this);
        buttons[0].setBackground(new Color(44, 41, 41));
        buttons[0].setForeground(new Color(225, 225, 225));

        // Кнопка для выборы режима игры 5х5
        buttons[1] = new JButton("5x5 game");
        button_panel.add(buttons[1]);
        buttons[1].setFont(new Font("",Font.BOLD,50));
        buttons[1].setFocusable(false);
        buttons[1].addActionListener(this);
        buttons[1].setBackground(new Color(44, 41, 41));
        buttons[1].setForeground(new Color(225, 225, 225));

    }

    // Метод, отвечающий за выбор игры: 3х3 или 5х5
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==buttons[0]) { // выбор игры 3х3
            frame.dispose();
            TicTacToe3x3 Window3x3 = new TicTacToe3x3();
        }
        else if(e.getSource()==buttons[1]) { // выбор игры 5х5
            frame.dispose();
            TicTacToe5x5 Window5x5 = new TicTacToe5x5();
        }

    }
}