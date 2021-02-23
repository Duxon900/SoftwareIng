package nagusi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {
	

	//pane
	private JPanel contentPane;
	private JPanel flowLayout;
	private JPanel paneHutsa;
	private JPanel gridLayout;
	private JPanel erabiltzailePane;

	
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblErabiltzailea;
	private JPanel pasahitzaPane;
	private JLabel lblPasahitza;
	
	//field
	private JTextField textField;
	private JPasswordField passwordField;
	
	private static LogIn frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getFlowLayout(), BorderLayout.SOUTH);
		contentPane.add(getGridLayout(), BorderLayout.CENTER);
	}

	private JPanel getFlowLayout() {
		if (flowLayout == null) {
			flowLayout = new JPanel();
			flowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			flowLayout.add(getBtnOk());
			flowLayout.add(getBtnCancel());
		}
		return flowLayout;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(passwordField.getText().equals("is2021")) {
						
						frame.setVisible(false);

						windowProba.ProbaMatrize3x3.main(null);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Pasahitza okerra da brodel! :S");
						passwordField.setText("");
						textField.setText("");
					}
				}
			});
		}
		return btnOk;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
		}
		return btnCancel;
	}
	private JPanel getPaneHutsa() {
		if (paneHutsa == null) {
			paneHutsa = new JPanel();
			paneHutsa.setLayout(new GridLayout(4, 1, 0, 0));
		}
		return paneHutsa;
	}
	private JPanel getGridLayout() {
		if (gridLayout == null) {
			gridLayout = new JPanel();
			gridLayout.setLayout(new GridLayout(4, 1, 0, 0));
			gridLayout.add(getPaneHutsa());
			gridLayout.add(getErabiltzailePane());
			gridLayout.add(getPasahitzaPane());
		}
		return gridLayout;
	}
	private JPanel getErabiltzailePane() {
		if (erabiltzailePane == null) {
			erabiltzailePane = new JPanel();
			erabiltzailePane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			erabiltzailePane.add(getLblErabiltzailea());
			erabiltzailePane.add(getTextField());
		}
		return erabiltzailePane;
	}
	private JLabel getLblErabiltzailea() {
		if (lblErabiltzailea == null) {
			lblErabiltzailea = new JLabel("Erabiltzailea");
		}
		return lblErabiltzailea;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPasahitzaPane() {
		if (pasahitzaPane == null) {
			pasahitzaPane = new JPanel();
			pasahitzaPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pasahitzaPane.add(getLblPasahitza());
			pasahitzaPane.add(getPasswordField());
		}
		return pasahitzaPane;
	}
	private JLabel getLblPasahitza() {
		if (lblPasahitza == null) {
			lblPasahitza = new JLabel("Pasahitza");
		}
		return lblPasahitza;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
		}
		return passwordField;
	}
}
