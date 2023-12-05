import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Put extends JButton implements ActionListener{

    private Board board;
    private GoStone stone;
    private ScoreBoard score_board;
    
    public GoStone stone() {return stone;}

    public Put(GoStone s, ImageIcon image, Board b, ScoreBoard sb) {
        super(image);
        board = b;
        stone = s;
        score_board = sb;
        addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {

        if(stone.state() == "NULL"){
            board.put(stone);
            if(board.CheckWin(stone)){
                
                if (stone.state().equals("Black")){
                    score_board.black_win = true;
                    try {
                        score_board.update();
                        JOptionPane.showMessageDialog(null, score_board.player_black() + " Win!");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    try {
                        score_board.update();
                        JOptionPane.showMessageDialog(null, score_board.player_white() + " Win!");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                board.reStart();
                if(score_board.matchOver()){
                    int result = JOptionPane.showConfirmDialog(null, "새로운 게임을 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION){
                        board.reStart();
                        score_board.begin();
                    } else {
                        System.exit(1);
                    }
                }
            }
        }
    }

}
