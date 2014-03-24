package seu.Client.test;

import javax.swing.SwingUtilities;

import seu.Client.view.ClauseLogin;
/**
 * 客户端主类
 * @author kidd
 *
 */
public class testField {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				  //new SplashWithImage();
		        //Thread.sleep(9000);
				// TODO Auto-generated method stub
				ClauseLogin login = new ClauseLogin();
			}
		});
		  

	}

}
