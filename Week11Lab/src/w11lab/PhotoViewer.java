package w11lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Additional reading/documentation:
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
 *
 * For additional features:
 * http://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
 * http://www.java2s.com/Code/Java/2D-Graphics-GUI/ImageViewer.htm
 * https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
 */
public class PhotoViewer {
	private final JFrame jframe;

	private final JPanel buttonContainer;
	private final JButton openFileButton;
	private final JButton renameFileButton;
	// TODO define text area
	private final JTextArea prefixInputArea;
	
	private File dir = new File(".");
	
	private PhotoViewer() {
		this.jframe = new JFrame();
		openFileButton = new JButton("Choose directory");
		openFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});
		renameFileButton = new JButton("Rename files");
		// TODO add a listener to renameFileButton that does the renaming logic
		renameFileButton.setEnabled(false);
		renameFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				renameFiles(dir, prefixInputArea.getText());
			}
		});

		// TODO create a JTextArea field here for the text to add
		prefixInputArea = new JTextArea();
		prefixInputArea.setEditable(true);
		
		Container content = this.jframe.getContentPane();

		// We create a new panel inside of our panel so that we can have
		// our buttons side by side, while also at the bottom of the main
		// layout.
		buttonContainer = new JPanel();
		buttonContainer.add(openFileButton, BorderLayout.LINE_START);
		buttonContainer.add(renameFileButton, BorderLayout.LINE_END);
		content.add(buttonContainer, BorderLayout.PAGE_END);
		// TODO content.add([your JTextArea], BorderLayout.[see diagram in
		// handout])
		content.add(prefixInputArea, BorderLayout.CENTER);
	}

	private void showFileChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(jframe);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("User opened file " + chooser.getSelectedFile().getAbsolutePath());
			// TODO keep track of the selected directory so we can rename the
			// files in it.
			this.dir = chooser.getSelectedFile();
			this.renameFileButton.setEnabled(true);
		}
	}

	private void createAndShowGui() {
		// The following three lines will be included in basically every GUI
		// you see. If you don't include EXIT_ON_CLOSE, your application won't
		// close properly!
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}

	private void renameFiles(File directory, String prefix) {
		for (File f : directory.listFiles()) {
			System.out.println("File in directory: " + f.getAbsolutePath());
			// notice that File has a constructor which takes a directory and a
			// name,
			// so the destination for your renamess can be: new File(directory,
			// "prefix_DSCN0218.jpg")
			f.renameTo(new File(f.getParent(), prefix + f.getName()));
		}
	}

	public static void main(String[] args) {
		PhotoViewer v = new PhotoViewer();
		v.createAndShowGui();
	}
}