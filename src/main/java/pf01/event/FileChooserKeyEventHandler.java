package pf01.event;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;

public class FileChooserKeyEventHandler implements KeyListener{

  private static final Logger logger = LoggerFactory.getLogger(FileChooserKeyEventHandler.class);
  private JFileChooser chooserRef;

  public FileChooserKeyEventHandler(JFileChooser chooser){

    this.chooserRef = chooser;
  }

  @Override  
  public void keyPressed(KeyEvent e){
    logger.info("key {} pressed!", e.getKeyCode());
    if(e.getKeyCode() == KeyEvent.VK_ENTER){

      logger.info("enter pressed!");
      
      File file = chooserRef.getSelectedFile();
          if(file.isDirectory()) {
              chooserRef.setCurrentDirectory(file);
              chooserRef.rescanCurrentDirectory();
              
              logger.info("file list changed");
              e.consume();
          }
    }


  }

  @Override  
  public void keyReleased(KeyEvent e){
    logger.info("key {} Released!", e.getKeyCode());
  }

  @Override  
  public void keyTyped(KeyEvent e){

    logger.info("key {} typed!", e.getKeyCode());
  }
  }


