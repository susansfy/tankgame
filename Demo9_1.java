/***
 * 功能：java绘图原理
 * 绘图原理：
 * component类提供了两个和绘图相关的方法：
 * 1、paint(Graphics g)绘制组件的外观
 * 2、repaint()刷新组件的外观--如果要让坦克动起来，这个函数不能少
 * 
 * 当组件第一次在屏幕显示的时候，程序会自动的调用paint（）方法来绘制组件？？？--MyPanel中的paint函数
 */
package test;
import javax.swing.*;
import java.awt.*;

public class Demo9_1 extends JFrame{
	
	MyPanel1 mp = null;
	
	public static void main(String[] args) {
		Demo9_1 demo9_1 = new Demo9_1();
	}
	
	//构造函数
	public Demo9_1()
	{
		mp = new MyPanel1();
		this.add(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

//定义一个自己的画板
class MyPanel1 extends JPanel
{
	//覆盖JPanel 的paint方法
	public void paint(Graphics g)
	{
		//1、调用父类函数完成初始化
		//这句话不能少
		super.paint(g);
		//先画一个圆
//		g.drawOval(10, 10, 30, 30);
//		//画出斜线
//		g.drawLine(10, 10, 40, 40);
//		//画出矩形边框,前两个数字表示x,y的地方，即左上角的位置
//		g.drawRect(10, 10, 40, 60);
//		//颜色是对下一个定义的矩形
//		g.setColor(Color.BLUE);
//		g.fillRect(10, 10, 40, 40);
		
		//在画板上画出图片,路径怎么一直不通？?
		Image im = 
				Toolkit.getDefaultToolkit().getImage
				(Panel.class.getResource("/addcategory3.png"));
		g.drawImage(im, 90, 90, 1920,943,this);
		
		g.setFont(new Font("华文彩云",Font.BOLD,50));
	}
}