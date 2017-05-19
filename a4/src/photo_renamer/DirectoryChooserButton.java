package photo_renamer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DirectoryChooserButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Initialize a DirectoryChooserButton
	 * 
	 * @param text
	 * 			The name of the button.
	 * @param p
	 * 			The PhotoRenamer that this DirectoryChooserButton should appear in.
	 */
	public DirectoryChooserButton(String text, PhotoRenamer p) {
		super(text);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this.dFrame = this.buildWindow();
		//this.dFrame.setVisible(true);
		
	}

}
