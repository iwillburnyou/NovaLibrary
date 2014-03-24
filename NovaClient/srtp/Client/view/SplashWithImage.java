package seu.Client.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JWindow;
/**
 * 客户端开启的闪屏特效界面
 * @author kidd
 *
 */
public class SplashWithImage extends JWindow{
    private String imageUrl = "/image/login1.png";
    public SplashWithImage() {
        //this.setBackground(Color.GRAY);
        this.setBounds(new Rectangle(800,600));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void paint(Graphics g) {
        // 画图
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(imageUrl));
        
        // 设置画笔
        g.setColor(Color.DARK_GRAY);
        Font font = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,25);
        g.setFont(font);
        
        // 显示5S消失掉。
        int i = 0;
        while (i < 5) {
            try {
          
            	g.drawString("正在进入SEU校园管理系统1.0，请稍后...", 300, 330);
            	Thread.sleep(1000);
                g.drawImage(image, 0, 0, 800,600,this);
                Thread.sleep(500);
                
            
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
            if (i == 5) {
            	System.out.print("aa");
                this.dispose();
            }
        }
    }
   

}
