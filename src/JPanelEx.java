import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class JPanelEx extends JFrame {
   class MyPanel extends JPanel {
      public MyPanel() {
         new Thread(new Runnable() {
            public void run() {
               try {
                  while( true ) {
                     repaint();
                     Thread.sleep(400); //400ms초 간격으로 맞추기
                  }
                  } catch(Exception e) {
                  e.printStackTrace();
               }
            }
         }).start(); //스레드동작
      }
      public void paintComponent(Graphics g) {
         Random r = new Random();
         int x = r.nextInt(getWidth()-50);
         int y = r.nextInt(getHeight()-50);
         g.clearRect(0, 0, getWidth(), getHeight()); 
         g.drawOval(x, y, 50, 50); //(50.50)자리에 타원그리기
      }
   }
   public JPanelEx() {
      final MyPanel panel = new MyPanel();
      panel.setFocusable(true);
      setContentPane( panel );
      setSize(300, 300); //사이즈 정하기
      setDefaultCloseOperation(EXIT_ON_CLOSE);//x누르면 종료
      setVisible(true);
   }
   public static void main(String[] args) {
      new JPanelEx();
   }
}