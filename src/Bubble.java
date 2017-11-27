import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
public class Bubble extends JFrame
{
   int bubbleRadius = 5;//버블 반지름
   ArrayList<Point> bubblePosition = new ArrayList<Point>();//버블 저장할 리스트
   public Bubble()
   {
      setVisible(true);
      setSize(500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Timer timer = new Timer();//타이머 생성
      timer.schedule(new TimerTask()//타이머를 20/1000초마다 실행
      {
         @Override
         public void run()
         {
            for(int i=0;i < bubblePosition.size();i++)
            {
               bubblePosition.get(i).y -= 5;//위로 이동
               if(bubblePosition.get(i).y < 0)//위로 다 올라갔다면
               {
                  bubblePosition.remove(i);//리스트에서 삭제
               }
            }
            repaint();//화면 새로고침
         }
      }, 0, 20);
      addMouseListener(new MouseAdapter()//마우스 리스너 추가
      {
         @Override
         public void mousePressed(MouseEvent e)
         {
            bubblePosition.add(e.getPoint());//마우스 누룬 위치에 리스트에 저장 
         }
      });
   }
   @Override
   public void paint(Graphics g)
   {
      Image img = createImage(getWidth(), getHeight());
      Graphics bg = img.getGraphics();//백버퍼 조작을 위해
      for(int i=0;i < bubblePosition.size();i++)
      {  
         int x = bubblePosition.get(i).x;//버블의 위치 얻어오기
         int y = bubblePosition.get(i).y;
         bg.drawOval(x-bubbleRadius, y-bubbleRadius, bubbleRadius+bubbleRadius, bubbleRadius+bubbleRadius);
      }//그리기
     
      g.drawImage(img, 0, 0, this);//이미지출력
   }
   @Override
   public void update(Graphics g)
   {
      paint(g);
   }
   static public void main(String str[])
   {
      new Bubble();
   }
}