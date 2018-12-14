/***
 * 功能：讲解事件处理机制，对鼠标的监听
 * 事件源--事件--监听者
 */

package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo9_3 extends JFrame implements ActionListener{
	
	JPanel mp = null;
	JButton jb1= null;
	JButton jb2 = null;
	
	
	public static void main(String[] args)
	{
		Demo9_3 demo9 = new Demo9_3();
	}
	
	public Demo9_3()
	{
		mp = new JPanel();
		//JButton的对象，即事件源
		jb1 = new JButton("black");
		jb2 = new JButton("red");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat mycat1 = new Cat();
		
		//注册监听
		//this这里的参数是指希望被哪个类监听
		//demo9，mycat1就是监听者；
		//注意，是类的对象为监听者，不是类是监听者
		jb1.addActionListener(this);
		jb1.addActionListener(mycat1);
		//指定action命令
		jb1.setActionCommand("black");
		jb2.addActionListener(this);
		jb2.setActionCommand("red");
		
		this.setSize(200,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	//对事件处理的方法
	//点击按钮将发生ActionEvent事件，ActionEvent e 这个就是事件
	//e就是一个事件对象
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("ok");
		//判断是哪个按钮被点击
		if(e.getActionCommand().equals("black"))
		{
			System.out.println("你点击了黑色按钮");
			mp.setBackground(Color.black);
		}else if(e.getActionCommand().equals("red"))
		{
			System.out.println("red");
			mp.setBackground(Color.red);
		}else {
			System.out.println("不知道");
		}
	}

}


class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("black"))
		{
			System.out.println("猫指定了黑色");
		}else 
		{
			System.out.println("其它");
		}
	}
	
}


//class MyPanel extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		
//	}
//}