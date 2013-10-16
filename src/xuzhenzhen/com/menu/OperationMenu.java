package xuzhenzhen.com.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class OperationMenu extends JMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1739915004810336972L;
	private JMenuItem FCFSItem;
	private JMenuItem SJFItem;
	private JMenuItem FPFItem;
	public OperationMenu() {
		super("操作");
		init();
	}
	public void init(){
		FCFSItem=new JMenuItem("先来先服务");
		SJFItem=new JMenuItem("短作业优先服务");
		FPFItem=new JMenuItem("高响应比优先服务");
		FCFSItem.setAccelerator(KeyStroke.getKeyStroke('F', java.awt.Event.ALT_MASK, false));
		SJFItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.Event.ALT_MASK, false));
		FPFItem.setAccelerator(KeyStroke.getKeyStroke('P', java.awt.Event.ALT_MASK, false));
		add(FCFSItem);
		add(SJFItem);
		add(FPFItem);
	}
	public void addListener(ActionListener l){
		FCFSItem.addActionListener(l);
		SJFItem.addActionListener(l);
		FPFItem.addActionListener(l);
	}
}
