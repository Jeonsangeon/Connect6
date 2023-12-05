import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Board extends JFrame{

    private Put[][] goboard;
    private int count = 1;
    private ImageIcon img;
	private ImageIcon white;
	private ImageIcon black;
    private ImageIcon turn = black;
    private ScoreBoard score_board;
    
    public ImageIcon white() {return white;}
    public ImageIcon black() {return black;}
    public ImageIcon turn() {return turn;}

    public Board(String b) {

        ScoreBoard t = new ScoreBoard(this);
        
        img = new ImageIcon("images//empty"+b+".png");
	    white = new ImageIcon("images//white"+b+".png");
        black = new ImageIcon("images//black"+b+".png");
        
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(19,19));
        goboard = new Put[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                goboard[i][j] = new Put(new GoStone(i, j), img, this, t);
                cp.add(goboard[i][j]);
                goboard[i][j].setBorderPainted(false);
            }
        }

        setTitle("Connect6");
        setSize(820, 800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

    public boolean CheckWin(GoStone e) {
        //세로축
        int check_x = e.x();
        int check_y = e.y();
        int cnt = 0;
        while (check_y >= 0 && goboard[check_x][check_y].stone().state().equals(e.state())){
            check_y -= 1;
        }
        check_y += 1;
        while (check_y <= 18 && goboard[check_x][check_y].stone().state().equals(e.state())) {
            check_y += 1;
            cnt++;
            if(cnt == 6){
                return true;
            }    
        }
        //가로축
        check_x = e.x();
        check_y = e.y();
        cnt = 0;
        while (check_x >= 0 && goboard[check_x][check_y].stone().state().equals(e.state())){
            check_x -= 1;
        }
        check_x += 1;
        while (check_x <= 18 && goboard[check_x][check_y].stone().state().equals(e.state())) {
            check_x += 1;
            cnt++;
            if(cnt == 6){
                return true;
            }    
        }
        //대각선1
        check_x = e.x();
        check_y = e.y();
        cnt = 0;
        while (check_x >= 0 && check_y >= 0 && goboard[check_x][check_y].stone().state().equals(e.state())){
            check_x -= 1;
            check_y -= 1;
        }
        check_x += 1;
        check_y += 1;
        while (check_x <= 18 && check_y <= 18 && goboard[check_x][check_y].stone().state().equals(e.state())) {
            check_x += 1;
            check_y += 1;
            cnt++;
            if(cnt == 6){
                return true;
            }
        }
        //대각선2
        check_x = e.x();
        check_y = e.y();
        cnt = 0;
        while (check_x >= 0 && check_y <= 18 && goboard[check_x][check_y].stone().state().equals(e.state())){
            check_x -= 1;
            check_y += 1;
        }
        check_x += 1;
        check_y -= 1;
        while (check_x <= 18 && check_y >= 0 && goboard[check_x][check_y].stone().state().equals(e.state())) {
            check_x += 1;
            check_y -= 1;
            cnt++;
            if(cnt == 6){
                return true;
            }
        }
        
        return false;
    }

    public void reStart() {
        for(int i = 0; i < 19; i++)
            for(int j = 0 ; j < 19; j++){
                goboard[i][j].stone().state("NULL");
                goboard[i][j].setIcon(img);
                count = 1;
                turn = black;
            }        
    }

    public void put(GoStone s){
        if (turn == white) {
            goboard[s.x()][s.y()].setIcon(white);
            s.state("White");
            count++;
            if(count == 2){
                turn = black;
                count = 0;
            }
        } else {
            goboard[s.x()][s.y()].setIcon(black);
            s.state("Black");
            count++;
            if(count == 2){
                turn = white;
                count = 0;
            }
        }

    }

    public void update_score(){
        try {
            score_board.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
