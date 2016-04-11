import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SelectionSorterComponent extends JComponent
{
private SelectionSorter sorter;
public SelectionSorterComponent() 
{
    int[]values = {300,45,44,32,234,213,122,100,6,12,44,67,86,32,11,
        23,22,288,254,4,14,75,98,176,190,156,112,107,192,141,163,169};
    sorter = new SelectionSorter(values, this); 
}
public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    sorter.draw(g2);
}

public void startAnimation() {
class AnimationRunnable implements Runnable {
public void run() {
    try
    {
    sorter.merge();
    }
catch (InterruptedException exception)
{}
    }
      }

Runnable r = new AnimationRunnable();
Thread t = new Thread(r);
t.start();
}}