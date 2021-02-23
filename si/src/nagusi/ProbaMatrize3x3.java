package windowProba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProbaMatrize3x3 extends JFrame {

	private static ProbaMatrize3x3 frame;

	//panel
	private JPanel contentPane;
	private JPanel gridLayoutPane;
	private JPanel panel;
	private JPanel paneHutsa;
	private JPanel paneErabilgarria;
	private JPanel paneLabel;
	private JPanel paneText;
	private JPanel paneHutsa_1;
	private JPanel panel_1;

	private JPanel gridBagPane=new JPanel(new GridBagLayout());

	//gelaxkak
	private JLabel lblGelaxka;
	private JTextField txtGelaxka;

	//idazteko movida hori
	private JLabel lblText;
	private JLabel lblLabel;
	private JTextField txtText;
	private JTextField txtLabel;
	private JButton btnOk;
	private JPanel exitPane;
	private JButton btnExit;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ProbaMatrize3x3();
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
	public ProbaMatrize3x3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getGridLayoutPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
	}

	private JPanel getGridLayoutPane() {
		if (gridLayoutPane == null) {
			gridLayoutPane = new JPanel();
			gridLayoutPane.setLayout(new GridLayout(3, 3));
			matrizeaSortu();
		}
		return gridLayoutPane;
	}
	private void matrizeaSortu() {
		for(int l=0;l<3;l++) {
			for(int z=0;z<3;z++) {
				gridLayoutPane.add(getGridLayoutPanel(l, z));
			}
		}
	}
	private JPanel getGridLayoutPanel(int zut,int errenkada) {
		GridBagConstraints c = new GridBagConstraints();

		//JPanel  gridBagLayout
		JPanel gridBagLayoutPane = new JPanel();

		GridBagLayout gbl_gridBagLayoutPane = new GridBagLayout();
		gbl_gridBagLayoutPane.columnWidths = new int[]{0};
		gbl_gridBagLayoutPane.rowHeights = new int[] {0, 0, 0};
		gbl_gridBagLayoutPane.columnWeights = new double[]{1.0};
		gbl_gridBagLayoutPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayoutPane.setLayout(gbl_gridBagLayoutPane);



		//JLabel
		JLabel lblGelaxkatxo=new JLabel("Label"+zut+errenkada);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.33;
		gridBagLayoutPane.add(lblGelaxkatxo,c);

		//JTextField
		JTextField txtGelaxkatxo=new JTextField();
		txtGelaxkatxo.setColumns(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=40;
		c.gridx=0;
		c.gridy=2;
		c.weightx=0.66;
		gridBagLayoutPane.add(txtGelaxkatxo,c);


		gridBagLayoutPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				gridBagPane.setBorder(new LineBorder(Color.BLACK));


				gridBagLayoutPane.setBorder(new LineBorder(Color.BLUE));
				gridBagPane=gridBagLayoutPane;
				lblGelaxka=lblGelaxkatxo;
				txtGelaxka=txtGelaxkatxo;

			}
		});

		gridBagLayoutPane.setBorder(new LineBorder(Color.BLACK));


		return gridBagLayoutPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(3, 1, 0, 0));
			panel.add(getPaneHutsa());
			panel.add(getPaneErabilgarria());
			panel.add(getExitPane());
		}
		return panel;
	}
	private JPanel getPaneHutsa() {
		if (paneHutsa == null) {
			paneHutsa = new JPanel();
		}
		return paneHutsa;
	}
	private JPanel getPaneErabilgarria() {
		if (paneErabilgarria == null) {
			paneErabilgarria = new JPanel();
			paneErabilgarria.setLayout(new GridLayout(3, 1, 0, 0));
			paneErabilgarria.add(getPaneLabel());
			paneErabilgarria.add(getPaneText());
			paneErabilgarria.add(getBtnOk());
		}
		return paneErabilgarria;
	}
	private JPanel getPaneLabel() {
		if (paneLabel == null) {
			paneLabel = new JPanel();
			paneLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			paneLabel.add(getLblLabel());
			paneLabel.add(getTxtLabel());
		}
		return paneLabel;
	}
	private JLabel getLblLabel() {
		if (lblLabel == null) {
			lblLabel = new JLabel("Label");
		}
		return lblLabel;
	}
	private JTextField getTxtLabel() {
		if (txtLabel == null) {
			txtLabel = new JTextField();
			txtLabel.setColumns(10);
		}
		return txtLabel;
	}
	private JPanel getPaneText() {
		if (paneText == null) {
			paneText = new JPanel();
			paneText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			paneText.add(getLblText());
			paneText.add(getTxtText());
		}
		return paneText;
	}
	private JLabel getLblText() {
		if (lblText == null) {
			lblText = new JLabel("Text");
		}
		return lblText;
	}
	private JTextField getTxtText() {
		if (txtText == null) {
			txtText = new JTextField();
			txtText.setColumns(10);
		}
		return txtText;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblGelaxka.setText(txtLabel.getText());
					txtGelaxka.setText(txtText.getText());
				}
			});
		}
		return btnOk;
	}
	private JPanel getExitPane() {
		if (exitPane == null) {
			exitPane = new JPanel();
			exitPane.setLayout(new GridLayout(3, 1, 0, 0));
			exitPane.add(getPaneHutsa_1());
			exitPane.add(getPanel_1());
		}
		return exitPane;
	}
	private JPanel getPaneHutsa_1() {
		if (paneHutsa_1 == null) {
			paneHutsa_1 = new JPanel();
		}
		return paneHutsa_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnExit());
		}
		return panel_1;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("itxi la mierda esta");
				}
			});
		}
		return btnExit;
	}
}

