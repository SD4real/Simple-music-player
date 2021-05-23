import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton button, button2;
    JLabel myLabel, myLabel2;
    Clip clip;
    String soundFilePos = "19th_Floor_Bobby_Richards.wav";
    File file = new File(soundFilePos);

    AudioInputStream sound = AudioSystem.getAudioInputStream(file);

    MyFrame()throws IOException, UnsupportedAudioFileException, LineUnavailableException {

         //clip is created
        clip = AudioSystem.getClip();
        //The sound file is attached to the sound manager (clip)
        clip.open(sound);

        //-------- Creates the Buttons --------
        //30, 50, 100, 50);menu
        
        button = new JButton("Play");
    	button2 = new JButton("Stop");
    	button3 = new JButton("Next");
        button.setBounds(30, 200, 100, 50);
        button.addActionListener(this);
        button.setText("Play");
        button2.addActionListener(this);
        button2.setText("Stop");
        button2.setBounds(30,270, 100, 50);
    	//--------- Creates Frame ----------

        this.setTitle("Jukebox"); // sert title frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT OUT OF FRAME
        this.setResizable(false); // prevent frame from being rezised
        this.setSize(420,420); // sets dimmension x , y of frame
	    this.setVisible(true); // makes visible
        this.add(button);
        this.add(button2);
        this.add(button3);
        
       
        //--------- Embeds Image to Frame --------
	    ImageIcon background = new ImageIcon("Background.jpg");
	    myLabel = new JLabel();
	    myLabel.setIcon(background);
	    myLabel.setSize(420,420);
	    this.add(myLabel);
        this.pack();
	}

   
	@Override
	public void actionPerformed(ActionEvent e){
          

          if (e.getActionCommand().equals("Play")) {
              
              //Sound is set to start at the beginning
              clip.setFramePosition(0);
              //Sound is started
              clip.start();
             
        }
          if (e.getActionCommand().equals("Stop")) {
             clip.stop();
             
        }      
   }        
            
}

