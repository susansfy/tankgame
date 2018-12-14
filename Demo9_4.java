/***
 * 功能：小球根据键盘走动，对键盘的监听
 * 
 * JFrame 是事件源，它是底层
 * MyPanel是事件监听者
 * 
 */
package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo9_4 extends JFrame{
	
	MyPanel4 mp = null;
	
	public static void main(String[] args)
	{
		Demo9_4 demo9_4 = new Demo9_4();
	}

	//构造函数
	public Demo9_4()
	{
		mp = new MyPanel4();
		
		
		//Container ct = this.getContentPane();
		
		this.setSize(400,300);
		this.add(mp);
		//注意mp需要加监听接口
		this.addKeyListener(mp);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

//身为监听者，需要实现对应的监听接口KeyListener
class MyPanel4 extends JPanel implements KeyListener{
	
	int x = 10;
	int y = 10;
	
	public void paint(Graphics g)
	{
		super.paint(g);
	
		g.fillOval(x, y, 20, 20);
	}

	//键被按下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			y++;
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			y--;
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x--;
			this.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x++;
			this.repaint();
		}
	}

	//键被释放
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//键的一个值被输出
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}