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
			
//			IF METHOD IS VERIFY SNAP, IF BOOL SNAPVERIFIED IS TRUE, DISPOSE OF STARTGUI AND MAKE MAINSNAPGUI
			
			if(threadName == "verifysnap") {
				System.out.println("RUNNING THE MAIN SNAP GUI");
				new MainSnapGUI();
				Main.startGUI.frame.dispose();
			}			
			if(threadName == "niy") {
				System.out.println("RUNNING NIY GUI");
				new NIYGUI();
				Main.startGUI.frame.dispose();
			}
		} catch (Exception e) {}
	}
	
	public void start() {
		
	}
	

}
