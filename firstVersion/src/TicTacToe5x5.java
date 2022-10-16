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
            buttons[i].setFont(new Font("",Font.BOLD,100));
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
                        textfield.setText("O:");
                        check(); // вызов метода для проверки комбинации победы на текущем этапе
                    }
                    else { // блок команд, который вызывается в случае, если игрок захотел нажать на заполненное поле
                        for(int j=0;j<25;j++) {
                            buttons[j].setEnabled(false);
                        }
                        textfield.setText("One more game!");
                        break;
                    }
                }
                else { // если ходит нолик
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X:");
                        check(); // вызов метода для проверки комбинации победы на текущем этапе
                    }
                    else { // блок команд, который вызывается в случае, если игрок захотел нажать на заполненное поле
                        for(int j=0;j<25;j++) {
                            buttons[j].setEnabled(false);
                        }
                        textfield.setText("One more game!");
                        break;
                    }
                }
            }
        }

    }

    // Метод, отвечающий за то, кто будет делать первый шаг (крестик или нолик)
    public void firstTurn() {

        if(random.nextInt(2)==0) { // первый ход выбирается случайно
            player1_turn=true;
            textfield.setText("X:");
        }
        else {
            player1_turn=false;
            textfield.setText("O:");
        }

    }

    // Все варианты победы (4 подряд заполненных поля одним символом)
    public void check() {

        // Анализ побед крестика
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X") && (buttons[3].getText()=="X")) {
            xWins(0,1,2,3);
        }
        if((buttons[5].getText()=="X") && (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(5,6,7,8);
        }
        if((buttons[10].getText()=="X") && (buttons[11].getText()=="X") && (buttons[12].getText()=="X") && (buttons[13].getText()=="X")) {
            xWins(10,11,12,13);
        }
        if((buttons[15].getText()=="X") && (buttons[16].getText()=="X") && (buttons[17].getText()=="X") && (buttons[18].getText()=="X")) {
            xWins(15,16,17,18);
        }
        if((buttons[20].getText()=="X") && (buttons[21].getText()=="X") && (buttons[22].getText()=="X") && (buttons[23].getText()=="X")) {
            xWins(20,21,22,23);
        }
        if((buttons[1].getText()=="X") && (buttons[2].getText()=="X") && (buttons[3].getText()=="X") && (buttons[4].getText()=="X")) {
            xWins(1,2,3,4);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") && (buttons[9].getText()=="X")) {
            xWins(6,7,8,9);
        }
        if((buttons[11].getText()=="X") && (buttons[12].getText()=="X") && (buttons[13].getText()=="X") && (buttons[14].getText()=="X")) {
            xWins(11,12,13,14);
        }
        if((buttons[16].getText()=="X") && (buttons[17].getText()=="X") && (buttons[18].getText()=="X") && (buttons[19].getText()=="X")) {
            xWins(16,17,18,19);
        }
        if((buttons[21].getText()=="X") && (buttons[22].getText()=="X") && (buttons[23].getText()=="X") && (buttons[24].getText()=="X")) {
            xWins(21,22,23,24);
        }
        if((buttons[0].getText()=="X") && (buttons[5].getText()=="X") && (buttons[10].getText()=="X") && (buttons[15].getText()=="X")) {
            xWins(0,5,10,15);
        }
        if((buttons[1].getText()=="X") && (buttons[6].getText()=="X") && (buttons[11].getText()=="X") && (buttons[16].getText()=="X")) {
            xWins(1,6,11,16);
        }
        if((buttons[2].getText()=="X") && (buttons[7].getText()=="X") && (buttons[12].getText()=="X") && (buttons[17].getText()=="X")) {
            xWins(2,7,12,17);
        }
        if((buttons[3].getText()=="X") && (buttons[8].getText()=="X") && (buttons[13].getText()=="X") && (buttons[18].getText()=="X")) {
            xWins(3,8,13,18);
        }
        if((buttons[4].getText()=="X") && (buttons[9].getText()=="X") && (buttons[14].getText()=="X") && (buttons[19].getText()=="X")) {
            xWins(4,9,14,19);
        }
        if((buttons[5].getText()=="X") && (buttons[10].getText()=="X") && (buttons[15].getText()=="X") && (buttons[20].getText()=="X")) {
            xWins(5,10,15,20);
        }
        if((buttons[6].getText()=="X") && (buttons[11].getText()=="X") && (buttons[16].getText()=="X") && (buttons[21].getText()=="X")) {
            xWins(6,11,16,21);
        }
        if((buttons[7].getText()=="X") && (buttons[12].getText()=="X") && (buttons[17].getText()=="X") && (buttons[22].getText()=="X")) {
            xWins(7,12,17,22);
        }
        if((buttons[8].getText()=="X") && (buttons[13].getText()=="X") && (buttons[18].getText()=="X") && (buttons[23].getText()=="X")) {
            xWins(8,13,18,23);
        }
        if((buttons[9].getText()=="X") && (buttons[14].getText()=="X") && (buttons[19].getText()=="X") && (buttons[24].getText()=="X")) {
            xWins(9,14,19,24);
        }
        if((buttons[0].getText()=="X") && (buttons[6].getText()=="X") && (buttons[12].getText()=="X") && (buttons[18].getText()=="X")) {
            xWins(0,6,12,18);
        }
        if((buttons[1].getText()=="X") && (buttons[7].getText()=="X") && (buttons[13].getText()=="X") && (buttons[19].getText()=="X")) {
            xWins(1,7,13,19);
        }
        if((buttons[5].getText()=="X") && (buttons[11].getText()=="X") && (buttons[17].getText()=="X") && (buttons[23].getText()=="X")) {
            xWins(5,11,17,23);
        }
        if((buttons[6].getText()=="X") && (buttons[12].getText()=="X") && (buttons[18].getText()=="X") && (buttons[24].getText()=="X")) {
            xWins(6,12,18,24);
        }
        if((buttons[3].getText()=="X") && (buttons[7].getText()=="X") && (buttons[11].getText()=="X") && (buttons[15].getText()=="X")) {
            xWins(3,7,11,15);
        }
        if((buttons[4].getText()=="X") && (buttons[8].getText()=="X") && (buttons[12].getText()=="X") && (buttons[16].getText()=="X")) {
            xWins(4,8,12,16);
        }
        if((buttons[8].getText()=="X") && (buttons[12].getText()=="X") && (buttons[16].getText()=="X") && (buttons[20].getText()=="X")) {
            xWins(8,12,16,20);
        }
        if((buttons[9].getText()=="X") && (buttons[13].getText()=="X") && (buttons[17].getText()=="X") && (buttons[21].getText()=="X")) {
            xWins(9,13,17,21);
        }

        // Анализ побед нолика
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O") && (buttons[3].getText()=="O")) {
            oWins(0,1,2,3);
        }
        if((buttons[5].getText()=="O") && (buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(5,6,7,8);
        }
        if((buttons[10].getText()=="O") && (buttons[11].getText()=="O") && (buttons[12].getText()=="O") && (buttons[13].getText()=="O")) {
            oWins(10,11,12,13);
        }
        if((buttons[15].getText()=="O") && (buttons[16].getText()=="O") && (buttons[17].getText()=="O") && (buttons[18].getText()=="O")) {
            oWins(15,16,17,18);
        }
        if((buttons[20].getText()=="O") && (buttons[21].getText()=="O") && (buttons[22].getText()=="O") && (buttons[23].getText()=="O")) {
            oWins(20,21,22,23);
        }
        if((buttons[1].getText()=="O") && (buttons[2].getText()=="O") && (buttons[3].getText()=="O") && (buttons[4].getText()=="O")) {
            oWins(1,2,3,4);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O") && (buttons[9].getText()=="O")) {
            oWins(6,7,8,9);
        }
        if((buttons[11].getText()=="O") && (buttons[12].getText()=="O") && (buttons[13].getText()=="O") && (buttons[14].getText()=="O")) {
            oWins(11,12,13,14);
        }
        if((buttons[16].getText()=="O") && (buttons[17].getText()=="O") && (buttons[18].getText()=="O") && (buttons[19].getText()=="O")) {
            oWins(16,17,18,19);
        }
        if((buttons[21].getText()=="O") && (buttons[22].getText()=="O") && (buttons[23].getText()=="O") && (buttons[24].getText()=="O")) {
            oWins(21,22,23,24);
        }
        if((buttons[0].getText()=="O") && (buttons[5].getText()=="O") && (buttons[10].getText()=="O") && (buttons[15].getText()=="O")) {
            oWins(0,5,10,15);
        }
        if((buttons[1].getText()=="O") && (buttons[6].getText()=="O") && (buttons[11].getText()=="O") && (buttons[16].getText()=="O")) {
            oWins(1,6,11,16);
        }
        if((buttons[2].getText()=="O") && (buttons[7].getText()=="O") && (buttons[12].getText()=="O") && (buttons[17].getText()=="O")) {
            oWins(2,7,12,17);
        }
        if((buttons[3].getText()=="O") && (buttons[8].getText()=="O") && (buttons[13].getText()=="O") && (buttons[18].getText()=="O")) {
            oWins(3,8,13,18);
        }
        if((buttons[4].getText()=="O") && (buttons[9].getText()=="O") && (buttons[14].getText()=="O") && (buttons[19].getText()=="O")) {
            oWins(4,9,14,19);
        }
        if((buttons[5].getText()=="O") && (buttons[10].getText()=="O") && (buttons[15].getText()=="O") && (buttons[20].getText()=="O")) {
            oWins(5,10,15,20);
        }
        if((buttons[6].getText()=="O") && (buttons[11].getText()=="O") && (buttons[16].getText()=="O") && (buttons[21].getText()=="O")) {
            oWins(6,11,16,21);
        }
        if((buttons[7].getText()=="O") && (buttons[12].getText()=="O") && (buttons[17].getText()=="O") && (buttons[22].getText()=="O")) {
            oWins(7,12,17,22);
        }
        if((buttons[8].getText()=="O") && (buttons[13].getText()=="O") && (buttons[18].getText()=="O") && (buttons[23].getText()=="O")) {
            oWins(8,13,18,23);
        }
        if((buttons[9].getText()=="O") && (buttons[14].getText()=="O") && (buttons[19].getText()=="O") && (buttons[24].getText()=="O")) {
            oWins(9,14,19,24);
        }
        if((buttons[0].getText()=="O") && (buttons[6].getText()=="O") && (buttons[12].getText()=="O") && (buttons[18].getText()=="O")) {
            oWins(0,6,12,18);
        }
        if((buttons[1].getText()=="O") && (buttons[7].getText()=="O") && (buttons[13].getText()=="O") && (buttons[19].getText()=="O")) {
            oWins(1,7,13,19);
        }
        if((buttons[5].getText()=="O") && (buttons[11].getText()=="O") && (buttons[17].getText()=="O") && (buttons[23].getText()=="O")) {
            oWins(5,11,17,23);
        }
        if((buttons[6].getText()=="O") && (buttons[12].getText()=="O") && (buttons[18].getText()=="O") && (buttons[24].getText()=="O")) {
            oWins(6,12,18,24);
        }
        if((buttons[3].getText()=="O") && (buttons[7].getText()=="O") && (buttons[11].getText()=="O") && (buttons[15].getText()=="O")) {
            oWins(3,7,11,15);
        }
        if((buttons[4].getText()=="O") && (buttons[8].getText()=="O") && (buttons[12].getText()=="O") && (buttons[16].getText()=="O")) {
            oWins(4,8,12,16);
        }
        if((buttons[8].getText()=="O") && (buttons[12].getText()=="O") && (buttons[16].getText()=="O") && (buttons[20].getText()=="O")) {
            oWins(8,12,16,20);
        }
        if((buttons[9].getText()=="O") && (buttons[13].getText()=="O") && (buttons[17].getText()=="O") && (buttons[21].getText()=="O")) {
            oWins(9,13,17,21);
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