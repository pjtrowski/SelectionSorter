import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class SelectionSorter
 {
private static final int DELAY = 100;

private int[] a;
private Lock sortStateLock;


private JComponent component;
private int markedPosition = -1;
private int alreadySorted = -1;
public SelectionSorter(int[] anArray, JComponent aComponent)
 {
 a = anArray;
 sortStateLock = new ReentrantLock();
 component = aComponent;
 }
//public void sort() throws InterruptedException
private void merge(int[] first, int[] second)
 {
int iFirst = 0; // Next element to consider in the first array
int iSecond = 0; // Next element to consider in the second array
int j = 0; // Next open position in a

 // As long as neither iFirst nor iSecond past the end, move
 // the smaller element into a
 while (iFirst < first.length && iSecond < second.length)
{
if (first[iFirst] < second[iSecond])
{
a[j] = first[iFirst];
iFirst++;
}
else
{
a[j] = second[iSecond];
iSecond++;
}
j++;
}
while (iFirst < first.length)
{
a[j] = first[iFirst];
iFirst++; j++;
}
while (iSecond < second.length)
{
a[j] = second[iSecond];
iSecond++; j++;
}}}
        
