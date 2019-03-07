/*     */ package pf01;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.TextArea;
/*     */ import java.awt.TextField;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.nio.channels.FileChannel;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ class ActionControlInUnixLikeOS
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 378 */     String action = new String(e.getActionCommand());
/* 379 */     if ("清除".equals(action)) {
/* 380 */       clear();
/* 381 */     } else if ("瀏覽檔案".equals(action)) {
/* 382 */       keyin();
/* 383 */     } else if ("打包".equals(action)) {
/* 384 */       pack();
/* 385 */     } else if ("匯入Txt".equals(action)) {
/* 386 */       input();
/* 387 */     } else if ("匯出腳本".equals(action)) {
/* 388 */       outScript();
/* 389 */     } else if ("輸入".equals(action)) {
/* 390 */       keyin();
/* 391 */     } else if ("切換".equals(action)) {
/* 392 */       switchSourceAndCode();
/* 393 */     } else if ("加減WebRoot".equals(action)) {
/* 394 */       switchADWebRoot();
/* 395 */     } else if ("加減webapp".equals(action)) {
/* 396 */       switchADwebapp();
/* 397 */     } else if ("匯出Bat檔".equals(action)) {
/* 398 */       outBat();
/*     */     } else {
/* 400 */       JOptionPane.showMessageDialog(null, "按鍵錯誤", "警告", 2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void switchADWebRoot() {
/* 405 */     String tablePath = PF0101.taTable.getText();
/* 406 */     if (tablePath.contains("WebRoot")) {
/* 407 */       tablePath = tablePath.replaceAll("WebRoot", "");
/*     */     } else {
/* 409 */       String[] temp = tablePath.split("\n");
/* 410 */       tablePath = "";
/* 411 */       for (int i = 0; i < temp.length; i++) {
/* 412 */         if ((temp[i].length() > 0) && (!temp[i].equals(""))) {
/* 413 */           if (temp[i].substring(0, 1).equals("\\")) {
/* 414 */             temp[i] = ("WebRoot" + temp[i] + "\n");
/* 415 */             tablePath = tablePath + temp[i];
/*     */           } else {
/* 417 */             temp[i] = ("WebRoot\\" + temp[i] + "\n");
/* 418 */             tablePath = tablePath + temp[i];
/*     */           }
/*     */         } else {
/* 421 */           tablePath = tablePath + "\n";
/*     */         }
/*     */       }
/*     */     }
/* 425 */     PF0101.taTable.setText(tablePath);
/*     */   }
/*     */   
/*     */   public static void switchADwebapp() {
/* 429 */     String tablePath = PF0101.taTable.getText();
/* 430 */     if (tablePath.contains("webapp")) {
/* 431 */       tablePath = tablePath.replaceAll("webapp", "");
/*     */     } else {
/* 433 */       String[] temp = tablePath.split("\n");
/* 434 */       tablePath = "";
/* 435 */       for (int i = 0; i < temp.length; i++) {
/* 436 */         if ((temp[i].length() > 0) && (!temp[i].equals(""))) {
/* 437 */           if (temp[i].substring(0, 1).equals("\\")) {
/* 438 */             temp[i] = ("webapp" + temp[i] + "\n");
/* 439 */             tablePath = tablePath + temp[i];
/*     */           } else {
/* 441 */             temp[i] = ("webapp\\" + temp[i] + "\n");
/* 442 */             tablePath = tablePath + temp[i];
/*     */           }
/*     */         } else {
/* 445 */           tablePath = tablePath + "\n";
/*     */         }
/*     */       }
/*     */     }
/* 449 */     PF0101.taTable.setText(tablePath);
/*     */   }
/*     */   
/*     */   public static void switchSourceAndCode()
/*     */   {
/* 454 */     String tablePath = PF0101.taTable.getText();
/* 455 */     String savePath = PF0101.tfSaveFile.getText();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 460 */     if ((tablePath.contains("src")) || (savePath.contains("WebRoot"))) {
/* 461 */       tablePath = tablePath.replaceAll("src", "classes");
/* 462 */       if (tablePath.contains("java"))
/* 463 */         tablePath = tablePath.replaceAll("java", "class");
/* 464 */       if (tablePath.contains("WebRoot"))
/* 465 */         tablePath = tablePath.replaceAll("WebRoot", "webapp");
/* 466 */       if (savePath.contains("WebRoot"))
/* 467 */         savePath = savePath.replaceAll("WebRoot", "webapp");
/* 468 */     } else if ((tablePath.contains("classes")) || (savePath.contains("webapp"))) {
/* 469 */       tablePath = tablePath.replaceAll("classes", "src");
/* 470 */       if (tablePath.contains("class"))
/* 471 */         tablePath = tablePath.replaceAll("class", "java");
/* 472 */       if (tablePath.contains("webapp"))
/* 473 */         tablePath = tablePath.replaceAll("webapp", "WebRoot");
/* 474 */       if (savePath.contains("webapp")) {
/* 475 */         savePath = savePath.replaceAll("webapp", "WebRoot");
/*     */       }
/*     */     }
/* 478 */     PF0101.taTable.setText(tablePath);
/* 479 */     PF0101.tfSaveFile.setText(savePath);
/*     */   }
/*     */   
/*     */   public static void clear()
/*     */   {
/* 484 */     PF0101.taTable.setText("");
/*     */   }
/*     */   
/*     */   public static void keyin()
/*     */   {
/* 489 */     String getPath = PF0101.tfGetFile.getText();
/* 490 */     String savePath = PF0101.tfSaveFile.getText();
/* 491 */     String selectPath = PF0101.tfSelectFile.getText();
/* 492 */     PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
/* 493 */     PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
/* 494 */     PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
/* 495 */     PF0101.taTable.setBackground(new Color(255, 255, 255));
/* 496 */     if (PF0101.tfSelectFile.getText().equals(""))
/* 497 */       return;
/* 498 */     if (getPath.equals("")) {
/* 499 */       PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
/* 500 */       JOptionPane.showMessageDialog(null, "尚未輸入檔案母位置", "警告", 2);
/* 501 */       return; }
/* 502 */     if (savePath.equals("")) {
/* 503 */       PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
/* 504 */       JOptionPane.showMessageDialog(null, "尚未輸入存檔位置", "警告", 2);
/* 505 */       return; }
/* 506 */     if (selectPath.equals("")) {
/* 507 */       PF0101.tfSelectFile.setBackground(new Color(255, 160, 160));
/* 508 */       JOptionPane.showMessageDialog(null, "尚未輸入檔案位置", "警告", 2);
/* 509 */       return; }
              if (!getPath.substring(0, 6).equals("/home/") ) {
                PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
                JOptionPane.showMessageDialog(null, "檔案母位置須為絕對路徑，即起始於/home/...", "警告", 2);
               return; }
              if (!savePath.substring(0, 6).equals("/home/")) {
                PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
                JOptionPane.showMessageDialog(null, "存檔位置須為絕對路徑，即起始於/home/...", "警告", 2);
              return; }
/* 519 */     if ((!PF0101.taTable.getText().equals("")) && (
/* 520 */       (PF0101.taTable.getText().substring(0, 1).equals("1")) || 
/* 521 */       (PF0101.taTable.getText().substring(0, 1).equals("第")) || 
/* 522 */       (PF0101.taTable.getText().substring(0, 1).equals("尚")))) {
/* 523 */       PF0101.taTable.setText("");
/*     */     }
/*     */     
/* 526 */     String[] temp = PF0101.tfSelectFile.getText().split(";");
/* 527 */     for (int i = 0; i < temp.length; i++) {
                //進來的檔案路徑也都是絕對路徑  這裡用檔案母位置的路徑除去 進來的檔案路徑裡相同的部份
/* 530 */         temp[i] = temp[i].substring(getPath.length() + 1);
/*     */       
/* 532 */       PF0101.taTable.append(temp[i] + "\n");
/*     */     }
/* 534 */     PF0101.tfSelectFile.setText("");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void pack()
/*     */   {
/* 540 */     String getPath = PF0101.tfGetFile.getText();
/* 541 */     String savePath = PF0101.tfSaveFile.getText();
/* 542 */     String tablePath = PF0101.taTable.getText();
/* 543 */     StringBuffer errMes = new StringBuffer("");
/* 544 */     StringBuffer okMes = new StringBuffer("");
/* 545 */     PF0101.taMes.setText("");
/* 546 */     PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
/* 547 */     PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
/* 548 */     PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
/* 549 */     PF0101.taTable.setBackground(new Color(255, 255, 255));
/* 550 */     int count = 1;
/* 551 */     if (getPath.equals("")) {
/* 552 */       PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
/* 553 */       JOptionPane.showMessageDialog(null, "尚未輸入檔案母位置", "警告", 2);
/* 554 */       return; }
/* 555 */     if (savePath.equals("")) {
/* 556 */       PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
/* 557 */       JOptionPane.showMessageDialog(null, "尚未輸入存檔位置", "警告", 2);
/* 558 */       return; }
/* 559 */     if (tablePath.equals("")) {
/* 560 */       PF0101.taTable.setBackground(new Color(255, 160, 160));
/* 561 */       JOptionPane.showMessageDialog(null, "尚未輸入檔案位置", "警告", 2);
/* 562 */       return; }
/* 563 */     if (!getPath.substring(0, 6).equals("/home/") ) {
/* 564 */       PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
/* 565 */       JOptionPane.showMessageDialog(null, "檔案母位置須為絕對路徑，即起始於/home/...", "警告", 2);
/* 566 */       return; }
/* 567 */     if (!savePath.substring(0, 6).equals("/home/")) {
/* 568 */       PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
/* 569 */       JOptionPane.showMessageDialog(null, "存檔位置須為絕對路徑，即起始於/home/...", "警告", 2);
/* 570 */       return; }
/* 571 */     if (tablePath.substring(1, 2).equals(":")) {
/* 572 */       PF0101.taTable.setBackground(new Color(255, 160, 160));
/* 573 */       JOptionPane.showMessageDialog(null, "檔案列表不能為絕對路徑", "警告", 2);
/* 574 */       return;
/*     */     }
/*     */     
/* 577 */     okMes.append("===============打包開始===============\n");
/*     */     
/* 579 */     String[] temp = tablePath.split("\n");
/* 580 */     for (int i = 0; i < temp.length; i++) {
/* 581 */       if (!temp.equals("")) {
/* 582 */         String[] box = temp[i].split("/");
/* 583 */         String selectFilePath = new String();
/* 584 */         for (int j = 0; j < box.length - 1; j++) {
/* 585 */           selectFilePath = selectFilePath + "/" + box[j];
/*     */         }
/*     */         try
/*     */         {
    /* 589 */           File saveFile = new File(savePath + "/" + selectFilePath);
    /* 590 */           File getFile = new File(getPath + "/" + temp[i]);
    /* 591 */           File selectFile = new File(savePath + "/" + temp[i]);
    /* 592 */           String[] check = new File(getPath + "/" + temp[i]).getParentFile().list();
    /* 593 */           if (check != null) {
    /* 594 */             int checkFileName = 0;
    /* 595 */             for (int j = 0; j < check.length; j++) {
    /* 596 */               if (check[j].equals(box[(box.length - 1)])) {
    /* 597 */                 checkFileName++;
    /*     */               }
    /*     */             }
    /* 600 */             if (checkFileName == 1) {
    /* 601 */               okMes.append("第" + count + "次\n");
    /* 602 */               if (!saveFile.exists()) {
    /* 603 */                 okMes.append("建立的資料夾：" + savePath + "/" + selectFilePath + "\n");
    /* 604 */                 saveFile.mkdirs();
    /*     */               }
    /* 606 */               FileChannel inChannel = new FileInputStream(getPath + "/" + temp[i]).getChannel();
    /* 607 */               FileChannel outChannel = new FileOutputStream(savePath + "/" + temp[i]).getChannel();
    /* 608 */               long lastTime = getFile.lastModified();
    /* 609 */               okMes.append("將檔案" + getPath + "/" + temp[i] + "\n");
    /* 610 */               okMes.append("移動到" + savePath + "/" + temp[i] + "\n");
    /* 611 */               outChannel.transferFrom(inChannel, 0L, inChannel.size());
    /* 612 */               inChannel.close();
    /* 613 */               outChannel.close();
    /* 614 */               count++;
    /* 615 */               selectFile.setLastModified(lastTime);
    /* 616 */             } else if (getFile.exists()) {
    /* 617 */               errMes.append("目標檔案大小寫錯誤： " + getPath + "/" + temp[i] + " \n");
    /*     */             } else {
    /* 619 */               errMes.append("目標檔案不存在： " + getPath + "/" + temp[i] + " \n");
    /*     */             }
    /*     */           } else {
    /* 622 */             errMes.append("目標檔案不存在： " + getPath + "/" + temp[i] + " \n");
    /*     */           }
    /*     */         } catch (Exception e) {
    /* 625 */           e.printStackTrace();
    /*     */         }
    /*     */       }
    /*     */     }
    /* 629 */     okMes.append("===============打包完成===============\n");
    /* 630 */     PF0101.taMes.append(errMes.toString());
    /* 631 */     if (count > 1) PF0101.taMes.append(okMes.toString());
    /* 632 */     JOptionPane.showMessageDialog(null, PF0101.taMes, "打包紀錄", 1);
    /*     */   }
    /*     */   
    /*     */   public static void input()
    /*     */   {
    /*     */     try {
    /* 638 */       PF0101.tfGetFile.setBackground(new Color(255, 255, 255));
    /* 639 */       PF0101.tfSaveFile.setBackground(new Color(255, 255, 255));
    /* 640 */       PF0101.tfSelectFile.setBackground(new Color(255, 255, 255));
    /* 641 */       PF0101.taTable.setBackground(new Color(255, 255, 255));
    /* 642 */       String getPath = PF0101.tfGetFile.getText();
    /* 643 */       String savePath = PF0101.tfSaveFile.getText();
    /* 644 */       if (getPath.equals("")) {
    /* 645 */         PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
    /* 646 */         JOptionPane.showMessageDialog(null, "尚未輸入檔案母位置", "警告", 2);
    /* 647 */         return; }
    /* 648 */       if (savePath.equals("")) {
    /* 649 */         PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
    /* 650 */         JOptionPane.showMessageDialog(null, "尚未輸入存檔位置", "警告", 2);
    /* 651 */         return; }
                    if (!getPath.substring(0, 6).equals("/home/") ) {
                        PF0101.tfGetFile.setBackground(new Color(255, 160, 160));
                        JOptionPane.showMessageDialog(null, "檔案母位置須為絕對路徑，即起始於/home/...", "警告", 2);
                    return; }
                    if (!savePath.substring(0, 6).equals("/home/")) {
                        PF0101.tfSaveFile.setBackground(new Color(255, 160, 160));
                        JOptionPane.showMessageDialog(null, "存檔位置須為絕對路徑，即起始於/home/...", "警告", 2);
                    return; }
    /* 661 */       String inputPath = new String();
    /* 662 */       JFileChooser chooser = new JFileChooser();
    /* 663 */       chooser.setMultiSelectionEnabled(false);
    /* 664 */       chooser.setFileSelectionMode(0);
    /* 665 */       chooser.changeToParentDirectory();
    /* 666 */       FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
    /* 667 */       chooser.setFileFilter(filter);
    /* 668 */       if (chooser.showOpenDialog(PF0101.f1.getContentPane()) == 0) {
    /* 669 */         inputPath = chooser.getSelectedFile().getAbsolutePath();
    /* 670 */         FileReader fr = new FileReader(inputPath);
    /* 671 */         BufferedReader br = new BufferedReader(fr);
    /* 672 */         String input = new String();
    /* 673 */         while ((input = br.readLine()) != null) {
    /* 674 */           if ((PF0101.taTable.getText().substring(0, 1).equals("1")) || 
    /* 675 */             (PF0101.taTable.getText().substring(0, 1).equals("第")) || 
    /* 676 */             (PF0101.taTable.getText().substring(0, 1).equals("尚"))) {
    /* 677 */             PF0101.taTable.setText("");
    /*     */           }
    /* 679 */           if ((input.substring(1, 2).equals(":")) || (input.substring(1, 2).equals("\\"))) {
    /* 680 */             input = input.substring(getPath.length() + 1);
    /*     */           }
    /* 682 */           PF0101.taTable.append(input + "\n");
    /*     */         }
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 686 */       e.printStackTrace();
    /*     */     }
    /*     */   }
    /*     */   
    /*     */   public void outScript() {
    /*     */     try {
    /* 692 */       String getPath = PF0101.tfGetFile.getText();
    /* 693 */       String savePath = PF0101.tfSaveFile.getText();
    /* 694 */       String tablePath = PF0101.taTable.getText();
    /* 695 */       JFileChooser chooser = new JFileChooser();
    /* 696 */       FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
    /* 697 */       chooser.setFileFilter(filter);
    /* 698 */       chooser.setFileSelectionMode(1);
    /* 699 */       if (chooser.showSaveDialog(PF0101.f1.getContentPane()) == 0) {
    /* 700 */         File jf = chooser.getSelectedFile();
    /* 701 */         File scriptFile = new File(jf.getAbsolutePath() + ".txt");
    /* 702 */         FileWriter fwriter = new FileWriter(scriptFile);
    /* 703 */         fwriter.write(getPath + "\r\n");
    /* 704 */         fwriter.write(savePath + "\r\n");
    /* 705 */         fwriter.write(tablePath + "\r\n");
    /* 706 */         fwriter.close();
    /*     */       }
    /*     */     }
    /*     */     catch (Exception e) {
    /* 710 */       e.printStackTrace();
    /*     */     }
    /*     */   }
    /*     */   
    /*     */   public void outBat() {
    /*     */     try {
    /* 716 */       String getPath = PF0101.tfGetFile.getText();
    /* 717 */       String savePath = PF0101.tfSaveFile.getText();
    /* 718 */       String tablePath = PF0101.taTable.getText();
    /* 719 */       JFileChooser chooser = new JFileChooser();
    /* 720 */       FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", new String[] { "TXT" });
    /* 721 */       chooser.setFileFilter(filter);
    /* 722 */       chooser.setFileSelectionMode(1);
    /* 723 */       if (chooser.showSaveDialog(PF0101.f1.getContentPane()) == 0) {
    /* 724 */         File jf = chooser.getSelectedFile();
    /* 725 */         File scriptFile = new File(jf.getAbsolutePath() + ".bat");
    /* 726 */         FileWriter fwriter = new FileWriter(scriptFile);
    /* 727 */         fwriter.write("@檔案位置\r\n");
    /* 728 */         fwriter.write("set getPath=" + getPath + "\r\n");
    /* 729 */         fwriter.write("@存檔位置\r\n");
    /* 730 */         fwriter.write("set savePath=" + savePath + "\r\n");
    /* 731 */         String[] temp = tablePath.split("\n");
    /* 732 */         for (int i = 0; i < temp.length; i++) {
    /* 733 */           fwriter.write("mkdir %savePath%\\" + temp[i].substring(0, temp[i].lastIndexOf("\\")) + "\r\n");
    /* 734 */           fwriter.write("copy /Y %getPath%\\" + temp[i] + " %savePath%\\" + temp[i] + "\r\n");
    /*     */         }
    /* 736 */         fwriter.close();
    /*     */       }
    /*     */     }
    /*     */     catch (Exception e) {
    /* 740 */       e.printStackTrace();
    /*     */     }
    /*     */   }
    /*     */ }
    
    
    /* Location:              /home/morris/programing/PackageFile.jar!/pf01/actionControl.class
     * Java compiler version: 6 (50.0)
     * JD-Core Version:       0.7.1
     */