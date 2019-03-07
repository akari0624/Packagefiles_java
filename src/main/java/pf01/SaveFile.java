/*     */ package pf01;
/*     */ 
/*     */ import java.awt.TextField;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;

/*     */ public class SaveFile
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent ae)
/*     */   {
/* 759 */     JFileChooser chooser = new JFileChooser(PF0101.tfSaveFile.getText());
/* 760 */     chooser.setMultiSelectionEnabled(false);
/* 761 */     chooser.setFileSelectionMode(1);
/* 762 */     if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
/* 763 */       PF0101.tfSaveFile.setText(chooser.getSelectedFile().getAbsolutePath());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/morris/programing/PackageFile.jar!/pf01/saveFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */