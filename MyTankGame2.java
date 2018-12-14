/***
 * 功能：画出坦克2.0，增加事件机制
 */

package han.thread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MyTankGame2 extends JFrame{
	
	MyPanel mp = null;
	
	public static void main(String[] args) {
		MyTankGame2 mt = new MyTankGame2();
	}
	
	//构造函数
	public MyTankGame2()
	{
		mp = new MyPanel();
		mp.setBackground(Color.gray);
		//不能直接JFrame.setbackground，这不会起作用；可以对panel进行设置背景色
		//this.setBackground(Color.BLACK);
		this.add(mp);
		this.addKeyListener(mp);
		
		Thread mypanel = new Thread(mp);
		mypanel.start();
		
		this.setVisible(true);
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//同一个包里，类的方法可以直接使用，类似在同一个类中？？？
	//定义一个我的坦克
	Hero hero = null;
	//定义敌人的坦克
	Vector<Enemy> ets = new Vector<Enemy>();
	int ensize = 3;

	
	//构造函数
	public MyPanel()
	{
		//这里为什么不是按400/2,300-30，得到最下面的位置的？？？
		hero = new Hero(200,200);
		
		for(int i=0;i<ensize;i++)
		{
			Enemy et = new Enemy((i+1)*50,0);
			et.setDirect(1);
			ets.add(et);
		}
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0,hero.getSpeed());
		
		//画出子弹
		if(hero.s!=null)
		{
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1, ets.get(i).getSpeed());
		}

	}
	
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type,int speed)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			break;
		}
		
		//判断方向
		switch(direct)
		{
		//向上
		case 0:
			
			//g.setColor(Color.CYAN);
			//画出左边矩阵
			g.fill3DRect(x, y, 5, 30,false);
			//画出右边矩阵
			g.fill3DRect(x+15, y, 5, 30,false);
			//画出中间矩阵
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//画出中间的圆
			g.fillOval(x+5, y+10, 10, 10);
			//画出中间的线
			g.drawLine(x+10, y, x+10, y+15);
			break;
			
		//向下	
		case 1:
			//g.setColor(Color.CYAN);
			//画出左边矩阵
			g.fill3DRect(x, y, 5, 30,false);
			//画出右边矩阵
			g.fill3DRect(x+15, y, 5, 30,false);
			//画出中间矩阵
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//画出中间的圆
			g.fillOval(x+5, y+10, 10, 10);
			//画出中间的线
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		
		//向左
		case 2:
			//g.setColor(Color.CYAN);
			//画出左边矩阵
			g.fill3DRect(x, y, 30, 5,false);
			//画出右边矩阵
			g.fill3DRect(x, y+15, 30, 5,false);
			//画出中间矩阵
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//画出中间的圆
			g.fillOval(x+10, y+5, 10, 10);
			//画出中间的线
			g.drawLine(x, y+10, x+15, y+10);
			break;
		
		//向右
		case 3:
			//g.setColor(Color.CYAN);
			//画出左边矩阵
			g.fill3DRect(x, y, 30, 5,false);
			//画出右边矩阵
			g.fill3DRect(x, y+15, 30, 5,false);
			//画出中间矩阵
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//画出中间的圆
			g.fillOval(x+10, y+5, 10, 10);
			//画出中间的线
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		}
	}

	//设置w向上 a向左 s向下 d向右
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			hero.direct=0;
			hero.y-=hero.speed;
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			hero.direct=2;
			hero.x-=hero.speed;
			//this.hero.moveUP();
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			hero.direct=1;
			hero.y+=hero.speed;
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			hero.direct=3;
			hero.x+=hero.speed;
			this.repaint();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			//开火
			this.hero.shotenemy();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			//System.out.println("hello");
		}
	}
}

