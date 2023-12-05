import java.awt.event.*;
import javax.swing.*;

public class BackGroundButton extends JButton implements ActionListener{

    private BackGroundFrame bFrame;
	
    public BackGroundButton(String s, BackGroundFrame f) {
        super(s);
		bFrame = f;
		addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
		bFrame.choice(getText());
        bFrame.setVisible(false);
		String backGround ="";
		if (bFrame.getNumber() == 0)
			backGround = "0";
		else if (bFrame.getNumber() == 1)
            backGround = "1";
		else if (bFrame.getNumber() == 2)
            backGround = "2";
        
        new Board(backGround);
	}
}