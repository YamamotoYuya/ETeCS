import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

	public class PerformancePanel extends JFrame{
		private Image img;
		public static double time =0;
		private static JProgressBar bar;
		PerformancePanel(){
			try{
				img = getToolkit().getImage("image\\ETeCSIconSmall.png");
			}catch(Exception e){

			}
			setLayout(new BorderLayout());
			setTitle("ETeCS Loading...");
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
			java.awt.DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();
			int width = displayMode.getWidth()/10*2;
			int height = displayMode.getHeight()/10*2;
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			setBounds(d.width/2-width/2,d.height/2-height/2,400,400);

			setBar(new JProgressBar(0,400));
			Timer timer = new Timer(10,new timeListener());
			timer.start();

			add(new MyPanel(),BorderLayout.CENTER);
			add(getBar(),BorderLayout.SOUTH);
			setVisible(true);
		}
		class MyPanel extends JPanel{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img,25,25,this);
			}
		}
		public void exit(){
			setVisible(false);
		}
		public static JProgressBar getBar() {
			return bar;
		}
		public static void setBar(JProgressBar bar) {
			PerformancePanel.bar = bar;
		}
		class timeListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				time=time+2.5+1.5*Math.random();
				getBar().setValue((int)time);
			}
		}
	}
