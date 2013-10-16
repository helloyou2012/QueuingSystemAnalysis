package xuzhenzhen.com.menu;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FileMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7796528198277716694L;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem exitItem;
	public FileMenu(){
		super("文件");
		setMnemonic('F');
		init();
	}
	public void init(){
		openItem=new JMenuItem("打开",new ImageIcon("icons/open.gif"));
		saveItem=new JMenuItem("保存",new ImageIcon("icons/save.gif"));
		exitItem=new JMenuItem("退出");
		openItem.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.Event.CTRL_MASK, false));
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.Event.CTRL_MASK, false));
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', java.awt.Event.CTRL_MASK, false));
		add(openItem);
		add(saveItem);
		addSeparator();
		add(exitItem);
	}
	public void addListener(ActionListener l){
		openItem.addActionListener(l);
		saveItem.addActionListener(l);
		exitItem.addActionListener(l);
	}
}
