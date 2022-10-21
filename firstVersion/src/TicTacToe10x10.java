// Подключаем необходимые библиотеки для работы с графическим интерфейсом
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe10x10 implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[100];
    boolean player1_turn;

    // Интерфейс игры
    TicTacToe10x10() {

        // Внешний вид приложения
        frame = new JFrame("Game: TicTacToe 10x10");
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
        title_panel.setBounds(0,0,1000,100);

        button_panel.setLayout(new GridLayout(10,10));
        button_panel.setBackground(new Color(150,150,150));

        // Создание полей для игры
        for(int i=0;i<100;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("",Font.BOLD,50));
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

        for(int i=0;i<100;i++) {
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
                        TicTacToe10x10 Window10x10 = new TicTacToe10x10();
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
                        TicTacToe10x10 Window10x10 = new TicTacToe10x10();
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

    // Все варианты победы (5 подряд заполненных поля одним символом)
    public void check() {
        var f = "X";
        var g = "O";
        // Анализ побед крестика


        for(int i = 0; i < 100; i += 10){
            for(int j = i; j < i+6; j++){
                // Анализ победы, если x идет по горизонтали
                if((buttons[j].getText().matches(f)) &&
                        (buttons[j+1].getText().matches(f)) &&
                        (buttons[j+2].getText().matches(f)) &&
                        (buttons[j+3].getText().matches(f)) &&
                        (buttons[j+4].getText().matches(f))) {
                    xWins(j, j + 1, j + 2, j + 3, j + 4);
                }
                // Анализ победы, если o идет по горизонтали
                else if((buttons[j].getText().matches(g)) &&
                        (buttons[j+1].getText().matches(g)) &&
                        (buttons[j+2].getText().matches(g)) &&
                        (buttons[j+3].getText().matches(g)) &&
                        (buttons[j+4].getText().matches(g))){

                    oWins(j, j+1, j+2, j+3, j+4);
                }
            }
        }

        for(int i = 0; i < 100; i += 10){
            for(int j = i; j < i+6; j++){
                if((buttons[j].getText().matches(f)) &&
                        (buttons[j+1].getText().matches(f)) &&
                        (buttons[j+2].getText().matches(f)) &&
                        (buttons[j+3].getText().matches(f)) &&
                        (buttons[j+4].getText().matches(f))) {
                    xWins(j, j + 1, j + 2, j + 3, j + 4);
                }
                else if((buttons[j].getText().matches(g)) &&
                        (buttons[j+1].getText().matches(g)) &&
                        (buttons[j+2].getText().matches(g)) &&
                        (buttons[j+3].getText().matches(g)) &&
                        (buttons[j+4].getText().matches(g))) {
                    oWins(j, j + 1, j + 2, j + 3, j + 4);
                }
            }

            // Анализ победы, если х идет по диагонали (справа налево)
            for(int j = i+4; j < i+10; j++){

                if((buttons[j].getText().matches(f)) &&
                        (buttons[j+9].getText().matches(f)) &&
                        (buttons[j+18].getText().matches(f)) &&
                        (buttons[j+27].getText().matches(f)) &&
                        (buttons[j+36].getText().matches(f))) {
                    xWins(j, j + 9, j + 18, j + 27, j + 36);
                }
                else if((buttons[j].getText().matches(g)) &&
                        (buttons[j+9].getText().matches(g)) &&
                        (buttons[j+18].getText().matches(g)) &&
                        (buttons[j+27].getText().matches(g)) &&
                        (buttons[j+36].getText().matches(g))) {
                    oWins(j, j + 9, j + 18, j + 27, j + 36);
                }
            }
        }

        // Анализ победы, если х идет по вертикали
        for(int i = 0; i < 70; i++){
            for(int j = i; j < i+6; j++){

                if((buttons[j].getText().matches(f)) &&
                        (buttons[j+10].getText().matches(f)) &&
                        (buttons[j+20].getText().matches(f)) &&
                        (buttons[j+30].getText().matches(f)) &&
                        (buttons[j+40].getText().matches(f))) {
                    xWins(j, j + 10, j + 20, j + 30, j + 40);
                }
                else if((buttons[j].getText().matches(g)) &&
                        (buttons[j+10].getText().matches(g)) &&
                        (buttons[j+20].getText().matches(g)) &&
                        (buttons[j+30].getText().matches(g)) &&
                        (buttons[j+40].getText().matches(g))) {
                    oWins(j, j + 10, j + 20, j + 30, j + 40);
                }
                // Анализ победы, если х идет по диагонали (слева направо)
                else if((buttons[j].getText().matches(f)) &&
                        (buttons[j+11].getText().matches(f)) &&
                        (buttons[j+22].getText().matches(f)) &&
                        (buttons[j+33].getText().matches(f)) &&
                        (buttons[j+44].getText().matches(f))) {
                    xWins(j, j + 11, j + 22, j + 33, j + 44);
                }
                else if((buttons[j].getText().matches(g)) &&
                        (buttons[j+11].getText().matches(g)) &&
                        (buttons[j+22].getText().matches(g)) &&
                        (buttons[j+33].getText().matches(g)) &&
                        (buttons[j+44].getText().matches(g))) {
                    oWins(j, j + 11, j + 22, j + 33, j + 44);
                }
            }
        }
    }

    // Метод, который вызывается в случае победы крестика
    public void xWins(int a, int b, int c, int d, int e) {

        // Заполнение полей, где была выигрышная комбинация
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);

        for(int i=0;i<100;i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("X win");
    }

    // Метод, который вызывается в случае победы нолика
    public void oWins(int a, int b, int c, int d, int e) {

        // Заполнение полей, где была выигрышная комбинация
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        buttons[d].setBackground(Color.GREEN);
        buttons[e].setBackground(Color.GREEN);

        for(int i=0;i<100;i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("O win");
    }
}