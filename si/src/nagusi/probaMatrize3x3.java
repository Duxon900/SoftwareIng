package nagusi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
			
public class probaMatrize3x3 extends JFrame {

	private JPanel contentPane;
	private JPanel gridLayoutPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					probaMatrize3x3 frame = new probaMatrize3x3();
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
	public probaMatrize3x3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getGridLayoutPane(), BorderLayout.CENTER);
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
		JLabel label=new JLabel("Label"+zut+errenkada);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.33;
		gridBagLayoutPane.add(label,c);
		
		//JTextField
		JTextField textField=new JTextField();
		textField.setColumns(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=40;
		c.gridx=0;
		c.gridy=2;
		c.weightx=0.66;
		gridBagLayoutPane.add(textField,c);
		
		return gridBagLayoutPane;
	}
}

