package main.java.alysondantas.agendador.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup tipo = new ButtonGroup();
	private JTextField txtHoraminutosegundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agendar por horas restantes:");
		lblNewLabel.setBounds(10, 11, 156, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Agendar!");
		btnNewButton.setBounds(106, 35, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hora");
		rdbtnNewRadioButton.setSelected(true);
		tipo.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 64, 49, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMinuto = new JRadioButton("Minuto");
		tipo.add(rdbtnMinuto);
		rdbtnMinuto.setBounds(61, 64, 57, 23);
		contentPane.add(rdbtnMinuto);
		
		JRadioButton rdbtnSegundo = new JRadioButton("Segundo");
		tipo.add(rdbtnSegundo);
		rdbtnSegundo.setBounds(116, 64, 109, 23);
		contentPane.add(rdbtnSegundo);
		
		JLabel lblNewLabel_1 = new JLabel("Agendar por horario:");
		lblNewLabel_1.setBounds(10, 94, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		txtHoraminutosegundo = new JTextField();
		txtHoraminutosegundo.setText("hh:mm:ss");
		txtHoraminutosegundo.setBounds(10, 119, 86, 20);
		contentPane.add(txtHoraminutosegundo);
		txtHoraminutosegundo.setColumns(10);
		
		JButton btnAgendar = new JButton("Agendar!");
		btnAgendar.setBounds(106, 119, 89, 23);
		contentPane.add(btnAgendar);
		
		JButton btnNewButton_1 = new JButton("Anular!");
		btnNewButton_1.setBounds(10, 177, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
