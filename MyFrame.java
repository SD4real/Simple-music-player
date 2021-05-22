import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Image;
import java.awt.Color;;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton button, button2;
    JLabel myLabel, myLabel2;
    Clip clip;

    Scanner scanner = new Scanner(System.in);
    PlayAudio playAudio = new PlayAudio();
      
    //InputStream in = new FileInputStream(new File("Sonnymoon For Two.wav"));
   // AudioStream song = new AudioStream(in);

    MyFrame(){

        

        //-------- Creates the Buttons --------
        //30, 50, 100, 50);menu
        
        button = new JButton("Play");
    	button2 = new JButton("Stop");
        button.setBounds(30, 200, 100, 50);
        button.addActionListener(this);
        button2.addActionListener(this);
        button.setText("Play");
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
              
              System.out.println(playAudio);
              /*Clip clip = AudioSystem.getClip();
              clip.open(audioStream);

              String response = scanner.next();
              clip.start();*/
        }
          if (e.getActionCommand().equals("Stop")) {
              clip.stop();
        }
           
           
            
        }
public void PlayAudio(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        Scanner scanner = new Scanner(System.in);

        File file = new File("Sonnymoon For Two.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = scanner.next();
        //response = res

      //  while(!response.equals("Q")){

//AudioPlayer.player.start(song);  PlayAudio.clip.start(file);
        //}
// AudioPlayer.player.stop(song);

        clip.start();
    }
          
        
 }

