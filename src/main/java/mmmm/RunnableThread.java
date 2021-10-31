package mmmm;

//THIS IS THE THREAD CLASS
public class RunnableThread implements Runnable {
	
	private Thread t;
	private String threadName;
	
	public RunnableThread(String name) {
		threadName = name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RUNNING THREAD: " + threadName);
		try {
			if(threadName == "verifysnap") {
				System.out.println("VERIFYING SNAPCHAT...");
//				THIS CODE WILL VERIFY SNAPCHAT!
				vars.snapverified = true;
				if(vars.snapverified) {
					System.out.println("SNAPCHAT VERIFIED!");
					new snapManualGUI();
				} else {
					System.out.println("SNAPCHAT IS NOT VERIFIED!");
				}
			}
		} catch (Exception e) {}
	}
	
	public void start() {
		
	}
	

}
