package algo2.semana12.gui.teoria.framedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameDemo1JFrame {
	JFrame frame;
	
	FrameDemo1JFrame(){
		setupFrame();
	}
	
	public static void main(String[] args) {
		FrameDemo1JFrame demo = new FrameDemo1JFrame();
	}

	private void setupFrame() {
		JButton btnDialogo = new JButton("Demo de diálogos");
		frame = new JFrame();
		
		frame.setTitle("demo de la vemtana");
		frame.setSize(400, 200);
		frame.setLocation(790, 440);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(btnDialogo);
		btnDialogo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogDemo();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowIconified(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Minimizando");	
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
	
	private void dialogDemo() {
		String dato = JOptionPane.showInputDialog(null, "Ingrese un valor:", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(frame, "El valor ingresado es " + dato);
		
		int opc = JOptionPane.showConfirmDialog(null, "Cerrar la aplicación?");
		if (opc == JOptionPane.YES_OPTION) {
			frame.dispose();			
		} else if (opc == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Elegiste no salir");
		} else {
			JOptionPane.showMessageDialog(null, "Elegiste cancelar");
		}
	}
}
