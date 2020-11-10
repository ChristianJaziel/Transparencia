package transparency;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


	class prueba extends JPanel {
		 private JFrame ventana;
		    private Container contenedor;
		    public prueba() {
				
				// inicializar la ventana
				        ventana = new JFrame("Transparencia de figuras");
				        // definir tamaño a ventana
				        ventana.setSize(600, 300);
				        ventana.setVisible(true);
				        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        ventana.setResizable(false);
				        
				        contenedor = ventana.getContentPane();
				        contenedor.setSize(500, 500);
				        // agregar la ventana en el contenedor
				        contenedor.add(this, BorderLayout.CENTER);
			}
		    
		    private void doDrawing(Graphics g) {        
		        
		        Graphics2D g2d = (Graphics2D) g.create();
		       
		        for (int i = 1; i <= 10; i++) {
		        g2d.setPaint(Color.black);
		            float alpha = 0.9f;
		            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		            g2d.setComposite(alcom);
		            g2d.fillOval(50 * i, 20, 40, 40);
		        } 
		       
		        g2d.dispose();
		        
		    }
		    
		    private void doDrawing2(Graphics g) {        
		        
		        Graphics2D g2d = (Graphics2D) g.create();
		       
		        for (int i = 10; i >= 1; i--) {
		        g2d.setPaint(Color.blue);
		            float alpha = i * 0.1f;
		            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		            g2d.setComposite(alcom);
		            g2d.fillRect(50 * i , 30, 40, 40);
		        }  
		       
		        g2d.dispose();
		       
		    }
		    @Override
		    protected void paintComponent (Graphics g) {
				super.paintComponent(g);
				doDrawing(g);
				doDrawing2(g);
				
		    }
	}
