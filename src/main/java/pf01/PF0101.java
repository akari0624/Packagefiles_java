/*     */ package pf01;
/*     */ 
/*     */ import java.awt.Button;
/*     */ import java.awt.Color;
/*     */ import java.awt.Label;
/*     */ import java.awt.TextArea;
/*     */ import java.awt.TextField;
/*     */ import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class PF0101
/*     */ {

            private static final Logger logger = LoggerFactory.getLogger(PF0101.class);
/*  12 */   static JFrame f1 = new JFrame("Package your file");
/*  13 */   static TextArea taTable = new TextArea("1.)新增切換案鈕方便打包，\n  src←→classes，java←→class。\n\n2.)檔案位址請使用'\\'(左上右下斜線)做區隔。\n\n3.)多檔案位置可使用';'(分號)區隔位置。\n\n4.)若有重複檔案，此程式將自行覆蓋，請小心使用。\n\n5.)檔案母位置：為不打包部分，供檔案複製用。\n\n  例：D:\\project\\TBVD\\TBVD\\moiland-web100\\WebRoot\n\n6.)存檔位置：為檔案打包須存放之位置。\n\n  例：D:\\TBVD\\webapp\n\n7.)檔案位置：為須打包覆部分。\n\n  例：REG\\RAA01\\RAA0101.jsp\n\n8.)於檔案位置點擊Enter鍵可直接輸入。\n\n9.)如須抓取網路上之檔案，請於檔案母位置先行輸入IP\n\n10.)修改為打包時程式大小寫需相同\n\n11.)修改為可點選資料夾抓取以下所有檔案\n", 

/*  27 */     25, 50);
/*  28 */   static Label lbTitleVersion = new Label("Ver.20190307-18:00");
/*  29 */   static Label lbTitleContent = new Label("打包程式");
/*  30 */   static Label lbGetFile = new Label("檔案母位置：");
/*  31 */   static Label lbSaveFile = new Label("存檔位置：");
/*  32 */   static Label lbSelectFile = new Label("檔案位置：");
/*  33 */   static Label lbTalbe = new Label("檔案列表：");
/*  34 */   static TextField tfGetFile = new TextField("", 30);
/*  35 */   static TextField tfSaveFile = new TextField("", 30);
/*  36 */   static TextField tfSelectFile = new TextField("", 30);
/*  37 */   static TextField tfHidden = new TextField("", 30);
/*  38 */   static Button btGetFile = new Button("瀏覽");
/*  39 */   static Button btSaveFile = new Button("瀏覽");
/*  40 */   static Button btSelectFile = new Button("瀏覽");
/*  41 */   static Button btKeyin = new Button("輸入");
/*  42 */   static Button btInput = new Button("匯入Txt");
/*  43 */   static Button btPack = new Button("打包");
/*  44 */   static Button btClear = new Button("清除");
/*  45 */   static Button btOutScript = new Button("匯出腳本");
/*  46 */   static Button btInScript = new Button("匯入腳本");
/*  47 */   static Button btSwitch = new Button("切換");
/*  48 */   static Button btADWebRoot = new Button("加減WebRoot");
/*  49 */   static Button btADwebapp = new Button("加減webapp");
/*  50 */   static Button btOutBat = new Button("匯出Bat檔");
/*  51 */   static TextArea taMes = new TextArea("", 30, 80);
/*  52 */   static Label block = new Label("");
/*     */   
/*     */   public static void main(String[] args) throws Exception
/*     */   {
/*  56 */     f1.setLocation(300, 100);
/*  57 */     f1.setSize(500, 580);
/*  58 */     f1.setBackground(new Color(220, 220, 255));
/*  59 */     f1.addWindowListener(new WindowEventHandler());
/*  60 */     f1.setLayout(new java.awt.GridBagLayout());
/*  61 */     f1.setDefaultCloseOperation(3);
/*  62 */     java.awt.GridBagConstraints c1 = new java.awt.GridBagConstraints();
/*  63 */     btGetFile.setBackground(new Color(220, 220, 255));
/*  64 */     btSaveFile.setBackground(new Color(220, 220, 255));
/*  65 */     btSelectFile.setBackground(new Color(220, 220, 255));
/*  66 */     btKeyin.setBackground(new Color(220, 220, 255));
/*  67 */     btInput.setBackground(new Color(220, 220, 255));
/*  68 */     btPack.setBackground(new Color(220, 220, 255));
/*  69 */     btClear.setBackground(new Color(220, 220, 255));
/*  70 */     btOutScript.setBackground(new Color(220, 220, 255));
/*  71 */     btInScript.setBackground(new Color(220, 220, 255));
/*  72 */     btSwitch.setBackground(new Color(220, 220, 255));
/*  73 */     btADWebRoot.setBackground(new Color(220, 220, 255));
/*  74 */     btADwebapp.setBackground(new Color(220, 220, 255));
/*  75 */     btOutBat.setBackground(new Color(220, 220, 255));
/*     */     
/*  77 */     c1.gridx = 0;
/*  78 */     c1.gridy = 0;
/*  79 */     c1.gridwidth = 1;
/*  80 */     c1.gridheight = 1;
/*  81 */     c1.weightx = 0.0D;
/*  82 */     c1.weighty = 0.0D;
/*  83 */     c1.fill = 2;
/*  84 */     c1.anchor = 18;
/*  85 */     f1.add(lbTitleVersion, c1);
/*     */     
/*  87 */     c1.gridx = 0;
/*  88 */     c1.gridy = 1;
/*  89 */     c1.gridwidth = 1;
/*  90 */     c1.gridheight = 1;
/*  91 */     c1.weightx = 0.0D;
/*  92 */     c1.weighty = 0.0D;
/*  93 */     c1.fill = 0;
/*  94 */     c1.anchor = 17;
/*  95 */     f1.add(lbGetFile, c1);
/*  96 */     c1.gridx = 1;
/*  97 */     c1.gridy = 1;
/*  98 */     c1.gridwidth = 1;
/*  99 */     c1.gridheight = 1;
/* 100 */     c1.weightx = 0.0D;
/* 101 */     c1.weighty = 0.0D;
/* 102 */     c1.fill = 0;
/* 103 */     c1.anchor = 17;
/* 104 */     f1.add(tfGetFile, c1);
/* 105 */     c1.gridx = 3;
/* 106 */     c1.gridy = 1;
/* 107 */     c1.gridwidth = 1;
/* 108 */     c1.gridheight = 1;
/* 109 */     c1.weightx = 0.0D;
/* 110 */     c1.weighty = 0.0D;
/* 111 */     c1.fill = 2;
/* 112 */     c1.anchor = 17;
/* 113 */     f1.add(btGetFile, c1);
/*     */     
/* 115 */     c1.gridx = 0;
/* 116 */     c1.gridy = 2;
/* 117 */     c1.gridwidth = 1;
/* 118 */     c1.gridheight = 1;
/* 119 */     c1.weightx = 0.0D;
/* 120 */     c1.weighty = 0.0D;
/* 121 */     c1.fill = 0;
/* 122 */     c1.anchor = 17;
/* 123 */     f1.add(lbSaveFile, c1);
/* 124 */     c1.gridx = 1;
/* 125 */     c1.gridy = 2;
/* 126 */     c1.gridwidth = 1;
/* 127 */     c1.gridheight = 1;
/* 128 */     c1.weightx = 0.0D;
/* 129 */     c1.weighty = 0.0D;
/* 130 */     c1.fill = 0;
/* 131 */     c1.anchor = 17;
/* 132 */     f1.add(tfSaveFile, c1);
/* 133 */     c1.gridx = 3;
/* 134 */     c1.gridy = 2;
/* 135 */     c1.gridwidth = 1;
/* 136 */     c1.gridheight = 1;
/* 137 */     c1.weightx = 0.0D;
/* 138 */     c1.weighty = 0.0D;
/* 139 */     c1.fill = 2;
/* 140 */     c1.anchor = 17;
/* 141 */     f1.add(btSaveFile, c1);
/*     */     
/* 143 */     c1.gridx = 0;
/* 144 */     c1.gridy = 3;
/* 145 */     c1.gridwidth = 1;
/* 146 */     c1.gridheight = 1;
/* 147 */     c1.weightx = 0.0D;
/* 148 */     c1.weighty = 0.0D;
/* 149 */     c1.fill = 0;
/* 150 */     c1.anchor = 17;
/* 151 */     f1.add(lbSelectFile, c1);
/* 152 */     c1.gridx = 1;
/* 153 */     c1.gridy = 3;
/* 154 */     c1.gridwidth = 1;
/* 155 */     c1.gridheight = 1;
/* 156 */     c1.weightx = 0.0D;
/* 157 */     c1.weighty = 0.0D;
/* 158 */     c1.fill = 0;
/* 159 */     c1.anchor = 17;
/* 160 */     f1.add(tfSelectFile, c1);
/* 161 */     c1.gridx = 3;
/* 162 */     c1.gridy = 3;
/* 163 */     c1.gridwidth = 1;
/* 164 */     c1.gridheight = 1;
/* 165 */     c1.weightx = 0.0D;
/* 166 */     c1.weighty = 0.0D;
/* 167 */     c1.fill = 2;
/* 168 */     c1.anchor = 17;
/* 169 */     f1.add(btSelectFile, c1);
/*     */     
/* 171 */     c1.gridx = 3;
/* 172 */     c1.gridy = 7;
/* 173 */     c1.gridwidth = 1;
/* 174 */     c1.gridheight = 1;
/* 175 */     c1.weightx = 0.0D;
/* 176 */     c1.weighty = 0.0D;
/* 177 */     c1.fill = 2;
/* 178 */     c1.anchor = 17;
/* 179 */     f1.add(btKeyin, c1);
/* 180 */     c1.gridx = 3;
/* 181 */     c1.gridy = 8;
/* 182 */     c1.gridwidth = 1;
/* 183 */     c1.gridheight = 1;
/* 184 */     c1.weightx = 0.0D;
/* 185 */     c1.weighty = 0.0D;
/* 186 */     c1.fill = 2;
/* 187 */     c1.anchor = 17;
/*     */     
/* 189 */     c1.gridx = 3;
/* 190 */     c1.gridy = 9;
/* 191 */     c1.gridwidth = 1;
/* 192 */     c1.gridheight = 1;
/* 193 */     c1.weightx = 0.0D;
/* 194 */     c1.weighty = 0.0D;
/* 195 */     c1.fill = 2;
/* 196 */     c1.anchor = 17;
/* 197 */     f1.add(btPack, c1);
/* 198 */     c1.gridx = 3;
/* 199 */     c1.gridy = 10;
/* 200 */     c1.gridwidth = 1;
/* 201 */     c1.gridheight = 1;
/* 202 */     c1.weightx = 0.0D;
/* 203 */     c1.weighty = 0.0D;
/* 204 */     c1.fill = 2;
/* 205 */     c1.anchor = 17;
/* 206 */     f1.add(btClear, c1);
/* 207 */     c1.gridx = 3;
/* 208 */     c1.gridy = 11;
/* 209 */     c1.gridwidth = 1;
/* 210 */     c1.gridheight = 1;
/* 211 */     c1.weightx = 0.0D;
/* 212 */     c1.weighty = 0.0D;
/* 213 */     c1.fill = 2;
/* 214 */     c1.anchor = 17;
/*     */     
/* 216 */     c1.gridx = 3;
/* 217 */     c1.gridy = 12;
/* 218 */     c1.gridwidth = 1;
/* 219 */     c1.gridheight = 1;
/* 220 */     c1.weightx = 0.0D;
/* 221 */     c1.weighty = 0.0D;
/* 222 */     c1.fill = 2;
/* 223 */     c1.anchor = 17;
/*     */     
/* 225 */     c1.gridx = 3;
/* 226 */     c1.gridy = 13;
/* 227 */     c1.gridwidth = 1;
/* 228 */     c1.gridheight = 1;
/* 229 */     c1.weightx = 0.0D;
/* 230 */     c1.weighty = 0.0D;
/* 231 */     c1.fill = 2;
/* 232 */     c1.anchor = 17;
/* 233 */     f1.add(btSwitch, c1);
/* 234 */     c1.gridx = 3;
/* 235 */     c1.gridy = 15;
/* 236 */     c1.gridwidth = 1;
/* 237 */     c1.gridheight = 1;
/* 238 */     c1.weightx = 0.0D;
/* 239 */     c1.weighty = 0.0D;
/* 240 */     c1.fill = 2;
/* 241 */     c1.anchor = 17;
/* 242 */     f1.add(btADWebRoot, c1);
/* 243 */     c1.gridx = 3;
/* 244 */     c1.gridy = 16;
/* 245 */     c1.gridwidth = 1;
/* 246 */     c1.gridheight = 1;
/* 247 */     c1.weightx = 0.0D;
/* 248 */     c1.weighty = 0.0D;
/* 249 */     c1.fill = 2;
/* 250 */     c1.anchor = 17;
/* 251 */     f1.add(btADwebapp, c1);
/* 252 */     c1.gridx = 3;
/* 253 */     c1.gridy = 17;
/* 254 */     c1.gridwidth = 1;
/* 255 */     c1.gridheight = 1;
/* 256 */     c1.weightx = 0.0D;
/* 257 */     c1.weighty = 0.0D;
/* 258 */     c1.fill = 2;
/* 259 */     c1.anchor = 17;
/* 260 */     f1.add(btOutBat, c1);
/*     */     
/* 262 */     c1.gridx = 0;
/* 263 */     c1.gridy = 5;
/* 264 */     c1.gridwidth = 1;
/* 265 */     c1.gridheight = 1;
/* 266 */     c1.weightx = 0.0D;
/* 267 */     c1.weighty = 0.0D;
/* 268 */     c1.fill = 2;
/* 269 */     c1.anchor = 17;
/* 270 */     f1.add(block, c1);
/*     */     
/*     */ 
/* 273 */     c1.gridx = 0;
/* 274 */     c1.gridy = 6;
/* 275 */     c1.gridwidth = 1;
/* 276 */     c1.gridheight = 1;
/* 277 */     c1.weightx = 0.0D;
/* 278 */     c1.weighty = 0.0D;
/* 279 */     c1.fill = 2;
/* 280 */     c1.anchor = 17;
/* 281 */     f1.add(lbTalbe, c1);
/*     */     
/* 283 */     c1.gridx = 0;
/* 284 */     c1.gridy = 7;
/* 285 */     c1.gridwidth = 3;
/* 286 */     c1.gridheight = 12;
/* 287 */     c1.weightx = 0.0D;
/* 288 */     c1.weighty = 0.0D;
/* 289 */     c1.fill = 2;
/* 290 */     c1.anchor = 17;
/* 291 */     f1.add(taTable, c1);

  if(System.getProperty("os.name").toLowerCase().contains("windows")){

     // os是 windows 
     logger.info("os 是{}","windows");
    btKeyin.addActionListener(new ActionControlInWindowsOS());
    btPack.addActionListener(new ActionControlInWindowsOS());
    btClear.addActionListener(new ActionControlInWindowsOS());
    btGetFile.addActionListener(new GetFile());
    btSaveFile.addActionListener(new SaveFile());
    btSelectFile.addActionListener(new SelectFile());
    btInput.addActionListener(new ActionControlInWindowsOS());
    btOutScript.addActionListener(new ActionControlInWindowsOS());
    btSwitch.addActionListener(new ActionControlInWindowsOS());
    btADWebRoot.addActionListener(new ActionControlInWindowsOS());
    btADwebapp.addActionListener(new ActionControlInWindowsOS());
    btOutBat.addActionListener(new ActionControlInWindowsOS());
  }else{
     // os 是 unix-like
     logger.info("os 是{}","unix-like");
    btKeyin.addActionListener(new ActionControlInUnixLikeOS());
    btPack.addActionListener(new ActionControlInUnixLikeOS());
    btClear.addActionListener(new ActionControlInUnixLikeOS());
    btGetFile.addActionListener(new GetFile());
    btSaveFile.addActionListener(new SaveFile());
    btSelectFile.addActionListener(new SelectFile());
    btInput.addActionListener(new ActionControlInUnixLikeOS());
    btOutScript.addActionListener(new ActionControlInUnixLikeOS());
    btSwitch.addActionListener(new ActionControlInUnixLikeOS());
    btADWebRoot.addActionListener(new ActionControlInUnixLikeOS());
    btADwebapp.addActionListener(new ActionControlInUnixLikeOS());
    btOutBat.addActionListener(new ActionControlInUnixLikeOS());

  }
/*     */     
/* 293 */     
/*     */     
/*     */ 
/* 307 */     f1.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /home/morris/programing/PackageFile.jar!/pf01/PF0101.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */