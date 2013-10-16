package xuzhenzhen.com.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class SettingMenu extends JMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = -721137626887704367L;
	private JMenuItem setCounterItem;//设置服务台个数
	public SettingMenu(){
		super("设置");
		init();
	}
	public void init(){
		setCounterItem=new JMenuItem("设置服务台");
		setCounterItem.setAccelerator(KeyStroke.getKeyStroke('R', java.awt.Event.CTRL_MASK, false));
		add(setCounterItem);
	}
	public void addListener(ActionListener l){
		setCounterItem.addActionListener(l);
	}
}
