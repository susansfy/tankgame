/***
 * 演示如何通过继承Thread来开发线程
 */
package test;

public class Demo10_1 {
	
	public static void main(String[] args)
	{
		Cat1 cat = new Cat1();
		cat.start();
	}

}

class Cat1 extends Thread{
	
	//重写run函数
	public void run()
	{
		int times = 0;
		while(true)
		{
			//休眠一秒
			//1000表示1000毫秒
			//sleep就会让该线程进入到Blocked状态，并释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("hello"+times);
			if(times==10)
			{
				//退出
				break;
			}
		}
		
	}
}