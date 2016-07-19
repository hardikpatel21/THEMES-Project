package vivek;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.undo.*;

public class I_Writer_Assign extends javax.swing.JApplet {
private HTMLDocument document;
private File currentFile;
boolean debug=false;
String title;
String id;
String regnum;

protected UndoableEditListener undoHandler = new UndoHandler();

	/** UndoManager that we add edits to. */
	protected UndoManager undo = new UndoManager();
		
	private UndoAction undoAction = new UndoAction();
	private RedoAction redoAction = new RedoAction();
		
	private Action cutAction = new DefaultEditorKit.CutAction();
	private Action copyAction = new DefaultEditorKit.CopyAction();
	private Action pasteAction = new DefaultEditorKit.PasteAction();

	private Action boldAction = new StyledEditorKit.BoldAction();
        
	private Action underlineAction = new StyledEditorKit.UnderlineAction();
	private Action italicAction = new StyledEditorKit.ItalicAction();
		
	private Action insertBreakAction = new DefaultEditorKit.InsertBreakAction();
	private HTMLEditorKit.InsertHTMLTextAction unorderedListAction 
		= new HTMLEditorKit.InsertHTMLTextAction("Bullets", "<ul><li> </li></ul>",HTML.Tag.P,HTML.Tag.UL);
	private HTMLEditorKit.InsertHTMLTextAction bulletAction 
		= new HTMLEditorKit.InsertHTMLTextAction("Bullets", "<li> </li>",HTML.Tag.UL,HTML.Tag.LI);
        private HTMLEditorKit.InsertHTMLTextAction boldAction1=new HTMLEditorKit.InsertHTMLTextAction("Bold", "<B> </B>", HTML.Tag.B,HTML.Tag.B);
    
        public I_Writer_Assign()
        {
            HTMLEditorKit editorKit = new HTMLEditorKit();
		document = (HTMLDocument)editorKit.createDefaultDocument();
                //System.out.println("2222222222222222222");
		// Force SwingSet to come up in the Cross Platform L&F
		try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			// If you want the System L&F instead, comment out the above line and
			// uncomment the following:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			    System.err.println("Error loading L&F: " + exc);
		}
                
        }
        
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    jTextPane1.setContentType("text/html");
		    startNewDocument();
                    id=getParameter("vcode");
                    title=getParameter("title");
                    regnum=getParameter("regnum");
                    
                    
                    URLConnection connection=DocOpen();
        ArrayList name=new ArrayList();
        ArrayList li=new ArrayList();
        li.add(id);
        li.add(title);
        //li.add(regnum);
        //JOptionPane.showMessageDialog(rootPane, name);
//         try
//         {
//            ObjectOutputStream oos=new ObjectOutputStream(connection.getOutputStream());
//            oos.writeObject(li);
//
//
//            ObjectInputStream ois=new ObjectInputStream(connection.getInputStream());
//            name=(ArrayList) ois.readObject();
//
//           // JOptionPane.showMessageDialog(rootPane, "my doc is"+name);
//         }
//         catch(Exception ex)
//         {
//             JOptionPane.showMessageDialog(rootPane, ex);
//         }
        
		try  {

//                                document=(HTMLDocument)name.get(0);
                                jTextPane1.setDocument(document);
                                resetUndoManager();
                     }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane(document);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem(undoAction);
        jMenuItem7 = new javax.swing.JMenuItem(redoAction);
        jMenuItem8 = new javax.swing.JMenuItem(cutAction);
        jMenuItem9 = new javax.swing.JMenuItem(copyAction);
        jMenuItem10 = new javax.swing.JMenuItem(pasteAction);
        jMenu3 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem(boldAction);
        jMenuItem14 = new javax.swing.JMenuItem(underlineAction);
        jMenuItem15 = new javax.swing.JMenuItem(italicAction);
        jMenuItem16 = new javax.swing.JMenuItem(unorderedListAction);
        jMenu4 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Green", Color.green));
        jMenuItem21 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Red", Color.red));
        jMenuItem22 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Blue", Color.blue));
        jMenuItem23 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Yellow", Color.yellow));
        jMenuItem24 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Cyan", Color.cyan));
        jMenuItem25 = new javax.swing.JMenuItem(new StyledEditorKit.ForegroundAction("Orange", Color.orange));
        jMenu5 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem(new StyledEditorKit.AlignmentAction("Align Left", StyleConstants.ALIGN_LEFT));
        jMenuItem19 = new javax.swing.JMenuItem(new StyledEditorKit.AlignmentAction("Align Center", StyleConstants.ALIGN_CENTER));
        jMenuItem20 = new javax.swing.JMenuItem(new StyledEditorKit.AlignmentAction("Align Right", StyleConstants.ALIGN_RIGHT));
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        jTextPane1.setMinimumSize(new java.awt.Dimension());
        jScrollPane1.setViewportView(jTextPane1);

        jMenu1.setText("File");

        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("open");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Exit");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem6.setText("Undo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Redo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Cut");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Copy");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Paste");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Style");

        jMenuItem13.setText("Bold");
        jMenu3.add(jMenuItem13);

        jMenuItem14.setText("Underline");
        jMenu3.add(jMenuItem14);

        jMenuItem15.setText("Italic");
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Bullets");
        jMenu3.add(jMenuItem16);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Color");

        jMenuItem17.setText("Green");
        jMenu4.add(jMenuItem17);

        jMenuItem21.setText("Red");
        jMenu4.add(jMenuItem21);

        jMenuItem22.setText("Blue");
        jMenu4.add(jMenuItem22);

        jMenuItem23.setText("Yellow");
        jMenu4.add(jMenuItem23);

        jMenuItem24.setText("Cyan");
        jMenu4.add(jMenuItem24);

        jMenuItem25.setText("Orange");
        jMenu4.add(jMenuItem25);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Align");

        jMenuItem18.setText("Align Left");
        jMenu5.add(jMenuItem18);

        jMenuItem19.setText("Align Center");
        jMenu5.add(jMenuItem19);

        jMenuItem20.setText("Align Right");
        jMenu5.add(jMenuItem20);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Font");

        String[] fontTypes = {"Calibri (Body)","Times New Roman","Wide Latin","Arial Black","SansSerif", "Serif", "Monospaced", "Dialog", "DialogInput"};
        for (int i = 0; i < fontTypes.length;i++){
            if (debug) System.out.println(fontTypes[i]);
            JMenuItem nextTypeItem = new JMenuItem(fontTypes[i]);
            nextTypeItem.setAction(new StyledEditorKit.FontFamilyAction(fontTypes[i], fontTypes[i]));
            jMenu7.add(nextTypeItem);
        }
        jMenu7.setText("Font Face");
        jMenu6.add(jMenu7);

        int[] fontSizes = {6, 8,10,12,14, 16, 20,24, 32,36,48,72};
        for (int i = 0; i < fontSizes.length;i++){
            if (debug) System.out.println(fontSizes[i]);
            JMenuItem nextSizeItem = new JMenuItem(String.valueOf(fontSizes[i]));
            nextSizeItem.setAction(new StyledEditorKit.FontSizeAction(String.valueOf(fontSizes[i]), fontSizes[i]));
            jMenu8.add(nextSizeItem);
        }
        jMenu8.setText("Font Size");
        jMenu6.add(jMenu8);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        try {
				undo.undo();
			} catch (CannotUndoException ex) {
				System.out.println("Unable to undo: " + ex);
				ex.printStackTrace();
			}
			undoAction.update();
			redoAction.update();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
				undo.redo();
			} catch (CannotRedoException ex) {
				System.err.println("Unable to redo: " + ex);
				ex.printStackTrace();
			}
			redoAction.update();
			undoAction.update();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        startNewDocument();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          
        saveDocument();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        openDocument();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        try {
                                JOptionPane.showMessageDialog(rootPane,"hi");
				System.exit(0);
			} catch (Exception ex) {
				System.out.println("Unable to exit: " + ex);
				ex.printStackTrace();
			}
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    
    public void openDocument(){
        JFileChooser fc = new JFileChooser();
       fc.showOpenDialog(fc);

            String dir1=fc.getSelectedFile().toString();
            String fn=fc.getName();
            String path=dir1;
            try
            {
                FileInputStream fis=new FileInputStream(path);
                byte ary[]=new byte[fis.available()];
                fis.read(ary);
                String data=new String(ary);
                System.out.println("data is "+data);
                jTextPane1.setText(data);
                fis.close();

            }catch(Exception ex)
            {
                ex.printStackTrace();
            }


        
//
//		try{
////
////				currentFile=new File("D:\\My netbean\\current project\\ITJCC03\\Docs Packup\\f1.doc");
////				FileReader fr = new FileReader(currentFile);
//                                document=(HTMLDocument)name.get(0);
//
////                                JOptionPane.showMessageDialog(rootPane, fr);
////				Document oldDoc = jTextPane1.getDocument();
////				if(oldDoc != null)
////					    oldDoc.removeUndoableEditListener(undoHandler);
////				HTMLEditorKit editorKit = new HTMLEditorKit();
////				document = (HTMLDocument)editorKit.createDefaultDocument();
////				editorKit.read(fr,document,0);
////				document.addUndoableEditListener(undoHandler);
//				jTextPane1.setDocument(document);
//                                jTextPane2.setText(name.get(1).toString());
//				resetUndoManager();
//                     }
//                catch(Exception ex)
//                {
//                    ex.printStackTrace();
//                }

	}
    
    
    public void saveDocument(){
        
        
      JFileChooser fc = new JFileChooser();
       fc.showSaveDialog(fc);

            String dir1=fc.getSelectedFile().toString();
            String fn=fc.getName();
            String path=dir1;
   try{
                FileOutputStream fos=new FileOutputStream(path);
                String content =jTextPane1.getText();
                System.out.println("content is "+content);
              FileWriter fw = new FileWriter(path);
					fw.write(jTextPane1.getText());
                                        fw.close();
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
	}
    
    
   
    
    
    
    public void startNewDocument()
    {
        Document oldDoc = jTextPane1.getDocument();
          System.out.println("the old doc is"+oldDoc);
		if(oldDoc != null)
			oldDoc.removeUndoableEditListener(undoHandler);
		HTMLEditorKit editorKit = new HTMLEditorKit();
		document = (HTMLDocument)editorKit.createDefaultDocument();
		jTextPane1.setDocument(document);	
		currentFile = null;
                
		//setTitle("HTMLDocumentEditor");	
		jTextPane1.getDocument().addUndoableEditListener(undoHandler);
                
		resetUndoManager();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    
    protected void resetUndoManager()
    {
                undo.discardAllEdits();
		undoAction.update();
		redoAction.update(); 
    }
    
    class UndoHandler implements UndoableEditListener {

		
		public void undoableEditHappened(UndoableEditEvent e) {
			undo.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}
	}
    
    class UndoAction extends AbstractAction {
		public UndoAction() {
			super("Undo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
		
       	
		}

		protected void update() {
			if(undo.canUndo()) {
				setEnabled(true);
				putValue(Action.NAME, undo.getUndoPresentationName());
			}else {
				setEnabled(false);
				putValue(Action.NAME, "Undo");
			}
		}
	}

	class RedoAction extends AbstractAction {
		
		public RedoAction() {
			super("Redo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
				
		}
	
		protected void update() {
			if(undo.canRedo()) {
				setEnabled(true);
				putValue(Action.NAME, undo.getRedoPresentationName());
			}else {
				setEnabled(false);
				putValue(Action.NAME, "Redo");
			}
		}
	}
        
//        private URLConnection action()
//    {
//        //JOptionPane.showMessageDialog(rootPane, "now ia m in action");
//       URLConnection url=null;
//       try
//       {
//           URL u=new URL("http://localhost:8084/ITJCC03/synch_Correction_SaveAction");
//           url=u.openConnection();
//           url.setDoInput(true);
//           url.setDoOutput(true);
//           url.setUseCaches(false);
//           url.setRequestProperty("Content-Type","application/x-java-serialized-object");
//       }
//       catch(Exception e)
//       {
//           e.printStackTrace();
//       }
//       return url;
//
//    }
        private URLConnection openAction()
    {
        URLConnection url=null;
       try
       {
           JOptionPane.showMessageDialog(rootPane, "action");
           URL u=new URL("http://localhost:8084/ITJCC03/synch_Correction_OpenAction");
           url=u.openConnection();
           url.setDoInput(true);
           url.setDoOutput(true);
           url.setUseCaches(false);
           url.setRequestProperty("Content-Type","application/x-java-serialized-object");
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return url;
    }
        
    private URLConnection DocOpen()
   {
      URLConnection url=null; 
       try
       {
           URL u=new URL("http://localhost:8084/ITJCC03/synchDocOpen");
           url=u.openConnection();
           url.setDoInput(true);
           url.setDoOutput(true);
           url.setUseCaches(false);
           url.setRequestProperty("Content-Type","application/x-java-serialized-object");
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return url;
            
   }    
        
}

