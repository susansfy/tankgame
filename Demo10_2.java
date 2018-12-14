package test;

public class Demo10_2 {
	
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		
		Thread t = new Thread(dog);
		t.start();
	}

}


//建议用这个继承接口的方法使用线程
class Dog implements Runnable
{
	int times =0;
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			
			System.out.println("hell0"+times);
			if(times==10)
			{
				break;
			}
		}
	}
}
