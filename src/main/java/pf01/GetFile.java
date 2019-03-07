/*     */ package pf01;
/*     */ 
/*     */ import java.awt.TextField;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;


/*     */ class GetFile
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent ae)
/*     */   {
/* 748 */     JFileChooser chooser = new JFileChooser(PF0101.tfGetFile.getText());
/* 749 */     chooser.setMultiSelectionEnabled(false);
/* 750 */     chooser.setFileSelectionMode(1);
/* 751 */     if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
/* 752 */       PF0101.tfGetFile.setText(chooser.getSelectedFile().getAbsolutePath());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/morris/programing/PackageFile.jar!/pf01/getFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */