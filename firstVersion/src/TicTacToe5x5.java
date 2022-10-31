// Подключаем необходимые библиотеки для работы с графическим интерфейсом
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe5x5 implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[25];
    boolean player1_turn;

    // Интерфейс игры
    TicTacToe5x5() {

        // Внешний вид приложения
        frame = new JFrame("Game: TicTacToe 5x5");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Верхнее окошко, где высвечивается ход текущего символа
        textfield.setBackground(new Color(44, 41, 41));
        textfield.setForeground(new Color(225, 225, 225));
        textfield.setFont(new Font("",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Ready. Set. Go!");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(5,5));
        button_panel.setBackground(new Color(150,150,150));

        // Создание полей для игры
        for(int i=0;i<25;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink free",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(255, 255, 255));
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        // Вызов метода, который определит, чей ход будет первым
        firstTurn();

    }

    // Метод, в котором описано как ходят игроки (заполнение ячеек текущими символами (х или о))
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<25;i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_turn) { // если ходит крестик
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O");
                        check(); // вызов метода для проверки комбинации победы на текущем этапе
                    }
                    else { // блок команд, который вызывается в случае, если игрок захотел нажать на заполненное поле
                        frame.dispose();
                        TicTacToe5x5 Window5x5 = new TicTacToe5x5();
                    }
                }
                else { // если ходит нолик
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X");
                        check(); // вызов метода для проверки комбинации победы на текущем этапе
                    }
                    else { // блок команд, который вызывается в случае, если игрок захотел нажать на заполненное поле
                        frame.dispose();
                        TicTacToe5x5 Window5x5 = new TicTacToe5x5();
                    }
                }
            }
        }

    }

    // Метод, отвечающий за то, кто будет делать первый шаг (крестик или нолик)
    public void firstTurn() {

        if(random.nextInt(2)==0) { // первый ход выбирается случайно
            player1_turn=true;
            textfield.setText("X");
        }
        else {
            player1_turn=false;
            textfield.setText("O");
        }

    }

    // Все варианты победы (4 подряд заполненных поля одним символом)
    public void check() {

        var f = "X";
        var g = "O";

        try {
            for (int i = 0; i < 25; i += 5) {
                for (int j = i; j < i + 2; j++) {
                    // Победа по горизонтали (х)
                    if ((buttons[j].getText().matches(f)) &&
                            (buttons[j + 1].getText().matches(f)) &&
                            (buttons[j + 2].getText().matches(f)) &&
                            (buttons[j + 3].getText().matches(f))) {
                        xWins(j, j + 1, j + 2, j + 3);
                    }
                    // Победа по горизонтали (о)
                    else if ((buttons[j].getText().matches(g)) &&
                            (buttons[j + 1].getText().matches(g)) &&
                            (buttons[j + 2].getText().matches(g)) &&
                            (buttons[j + 3].getText().matches(g))) {

                        oWins(j, j + 1, j + 2, j + 3);
                    }
                }

                for (int j = i + 3; j < i + 5; j++) {
                    // Победа по диагонали (х) (справа налево)
                    if ((buttons[j].getText().matches(f)) &&
                            (buttons[j + 4].getText().matches(f)) &&
                            (buttons[j + 8].getText().matches(f)) &&
                            (buttons[j + 12].getText().matches(f))) {
                        xWins(j, j + 4, j + 8, j + 12);
                    }
                    // Победа по диагонали (о) (справа налево)
                    else if ((buttons[j].getText().matches(g)) &&
                            (buttons[j + 4].getText().matches(g)) &&
                            (buttons[j + 8].getText().matches(g)) &&
                            (buttons[j + 12].getText().matches(g))) {
                        oWins(j, j + 4, j + 8, j + 12);
                    }
                }
            }
        }
        finally {
            for (int i = 0; i < 10; i++) {
                // Победа по вертикали (x)
                if ((buttons[i].getText().matches(f)) &&
                        (buttons[i + 5].getText().matches(f)) &&
                        (buttons[i + 10].getText().matches(f)) &&
                        (buttons[i + 15].getText().matches(f))) {
                    xWins(i, i + 5, i + 10, i + 15);
                }
                // Победа по вертикали (o)
                else if ((buttons[i].getText().matches(g)) &&
                        (buttons[i + 5].getText().matches(g)) &&
                        (buttons[i + 10].getText().matches(g)) &&
                        (buttons[i + 15].getText().matches(g))) {
                    oWins(i, i + 5, i + 10, i + 15);
                }
                for (int j = i; j < i + 5; j++) {
                    // Анализ победы, если х идет по диагонали (слева направо)
                    if ((buttons[j].getText().matches(f)) &&
                            (buttons[j + 6].getText().matches(f)) &&
                            (buttons[j + 12].getText().matches(f)) &&
                            (buttons[j + 18].getText().matches(f))) {
                        xWins(j, j + 6, j + 12, j + 18);
                    }
                    // Анализ победы, если o идет по диагонали (слева направо)
                    else if ((buttons[j].getText().matches(g)) &&
                            (buttons[j + 6].getText().matches(g)) &&
                            (buttons[j + 12].getText().matches(g)) &&
                            (buttons[j + 18].getText().matches(g))) {
                        oWins(j, j + 6, j + 12, j + 18);
                    }
                }
            }
        }

    }

    // Метод, который вызывается в случае победы крестика
    public void xWins(int a, int b, int c, int d) {

        // Заполнение полей, где была выигрышная комбинация
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);

        for(int i=0;i<25;i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("X wins");

    }

    // Метод, который вызывается в случае победы нолика
    public void oWins(int a, int b, int c, int d) {

        // Заполнение полей, где была выигрышная комбинация
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);

        for(int i=0;i<25;i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("O wins");

    }

}