package pf01.event;

import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import javax.swing.AbstractAction;

public class EnterKeyEventActionMapper extends AbstractAction{

  private static final long serialVersionUID = 1L;
private static final Logger logger = LoggerFactory.getLogger(FileChooserKeyEventHandler.class);
  private JFileChooser chooserRef;

  public EnterKeyEventActionMapper(JFileChooser chooser){

    this.chooserRef = chooser;
  }



                 @Override
                  public void actionPerformed(ActionEvent e) {
                    logger.info("action performed");
                    
                    File file = chooserRef.getSelectedFile();
                    if(file.isDirectory()) {
                        chooserRef.setCurrentDirectory(file);
                        chooserRef.rescanCurrentDirectory();
                        
                        logger.info("file list changed");
                       
                    }
                  }
          


}