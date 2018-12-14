package han.thread;

//坦克类,因为有我的坦克，敌人的坦克,这里先定义坐标
public class Tank
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
	int direct = 0;
	int speed = 1;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public Tank(int x,int y)
	{
		this.x = x;
		this.y = y;
		
	}
}

//我的坦克
class Hero extends Tank
{
	//子弹
	Shot s = null;
	
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	//开火
	public void shotenemy()
	{
		switch(this.direct)
		{
		case 0:
			//这里的x,y怎么不用先定义的？？？
			s=new Shot(x+10,y,0);
			//在哪创建类，就在哪启动线程
			
			break;
		//case 1:
			
		}
		Thread t = new Thread(s);
		t.start();
	}
	
	//坦克向上移动？？？
}

//敌人的坦克
class Enemy extends Tank
{
	public Enemy(int x,int y)
	{
		super(x,y);
	}
}

//子弹类
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=1;
	public Shot(int x,int y,int direct)
	{
		this.x = x;
		this.y = y;
		this.direct=direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0:
				y-=speed;
				break;
				
			}
			System.out.println(direct+","+x+y);
			//子弹何时死亡
			
		}
	}
}