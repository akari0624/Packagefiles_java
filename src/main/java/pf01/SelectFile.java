/*     */ package pf01;

/*     */
/*     */ import java.awt.TextField;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
import javax.swing.KeyStroke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.KeyListener;

import pf01.event.EnterKeyEventActionMapper;
import pf01.event.FileChooserKeyEventHandler;

/*     */ public class SelectFile
/*     */   implements ActionListener
/*     */ {

            private static final Logger logger = LoggerFactory.getLogger(SelectFile.class);
            @Override
/*     */   public void actionPerformed(ActionEvent ae)
/*     */   {
/* 771 */     PF0101.tfSelectFile.setText("");
/* 772 */      JFileChooser chooser = new JFileChooser(PF0101.tfGetFile.getText());

/* 773 */     if (!PF0101.tfHidden.getText().equals("")) {
/* 774 */       chooser = new JFileChooser(PF0101.tfHidden.getText());
/*     */     }

/* 776 */     chooser.setMultiSelectionEnabled(true);
/* 777 */     chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            //   KeyListener fileChooserKeyEventHandler = new FileChooserKeyEventHandler(chooser);
            //   chooser.addKeyListener(fileChooserKeyEventHandler);

            //   chooser.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "fileChooserKeyEvent");
            //   chooser.getActionMap().put("fileChooserKeyEvent", new EnterKeyEventActionMapper(chooser));
            //   logger.info("event binded");  

/* 778 */     if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == JFileChooser.APPROVE_OPTION) {
/* 779 */       File[] selectFile = chooser.getSelectedFiles();
/*     */       
             

                   // 原：selectFile[0].getAbsoluteFile() 會造成無法編譯
/* 781 */       String hiddenFile = selectFile[0].getAbsoluteFile().toString();
/* 782 */       for (int i = 0; i < selectFile.length; i++) {
/* 783 */         getAllFile(selectFile[i]);
/*     */       }
/*     */       
/* 786 */       PF0101.tfHidden.setText(hiddenFile);

                    if(System.getProperty("os.name").toLowerCase().contains("windows")){

                        ActionControlInWindowsOS.keyin();
                    }else{

                        ActionControlInUnixLikeOS.keyin();
                    }

/*     */        
         }
              

            //    chooser.removeKeyListener(fileChooserKeyEventHandler);
            //    logger.info("event Handler removed");
/*     */   }
/*     */   
/*     */   public void getAllFile(File file) {
/* 792 */     if (file.isDirectory()) {
/* 793 */       File[] fileArr = file.listFiles();
/* 794 */       for (int i = 0; i < fileArr.length; i++) {
/* 795 */         if (fileArr[i].isDirectory()) {
/* 796 */           getAllFile(fileArr[i]);
/*     */         }
/*     */         else {
/* 799 */           PF0101.tfSelectFile.setText(PF0101.tfSelectFile.getText() + fileArr[i].getAbsolutePath() + ";");
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 804 */       PF0101.tfSelectFile.setText(PF0101.tfSelectFile.getText() + file.getAbsolutePath() + ";");
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/morris/programing/PackageFile.jar!/pf01/selectFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */