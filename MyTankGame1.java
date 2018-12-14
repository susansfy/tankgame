/***
 * 功能：坦克游戏的1.0
 * 1、画出坦克
 */
package test;
import javax.swing.*;
import java.awt.*;

public class MyTankGame1 extends JFrame {
	
	MyPanel mp = null;
	
	public static void main(String[] args) {
		MyTankGame1 mt = new MyTankGame1();
	}
	
	//构造函数
	public MyTankGame1()
	{
		mp = new MyPanel();
		mp.setBackground(Color.gray);
		//不能直接JFrame.setbackground，这不会起作用；可以对panel进行设置背景色
		//this.setBackground(Color.BLACK);
		this.add(mp);
		
		this.setVisible(true);
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

//我的面板
class MyPanel extends JPanel
{
	
	//定义一个我的坦克
	Hero hero = null;
	
	//构造函数
	public MyPanel()
	{
		hero = new Hero(100,100);
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);

	}
	
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type)
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
			
			g.setColor(Color.CYAN);
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
		}
	}
}

//坦克类,因为有我的坦克，敌人的坦克,这里先定义坐标
class Tank
{
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int x = 0;
	int y = 0;
	
	public Tank(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}

//我的坦克
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
}
