package xuzhenzhen.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import xuzhenzhen.com.menu.FileMenu;
import xuzhenzhen.com.menu.OperationMenu;
import xuzhenzhen.com.menu.SettingMenu;

public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5976758585383446855L;
	private JMenuBar bar;
	private FileMenu fileMenu;
	private SettingMenu settingMenu;
	private OperationMenu operationMenu;
	private MainTabbedPane panel;
	public MainFrame(){
		init();
	}
	public void init(){
		bar=new JMenuBar();
		fileMenu=new FileMenu();
		settingMenu=new SettingMenu();
		operationMenu=new OperationMenu();
		fileMenu.addListener(this);
		settingMenu.addListener(this);
		operationMenu.addListener(this);
		bar.add(fileMenu);
		bar.add(settingMenu);
		bar.add(operationMenu);
		setJMenuBar(bar);
		panel=new MainTabbedPane();
		this.setContentPane(panel);
		this.setTitle("排队系统分析软件");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dealQuit();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		if(event.equals("打开"))	dealOpen();
		if(event.equals("保存"))	dealSave();
		if(event.equals("退出"))	dealQuit();
		if(event.equals("设置服务台"))dealSetting();
		if(event.equals("先来先服务"))panel.operateFcfs();
		if(event.equals("短作业优先服务"))panel.operateSjf();
		if(event.equals("高响应比优先服务"))panel.operateFpf();
	}
	public void dealQuit(){
		int result=JOptionPane.showConfirmDialog(null, "是否退出软件？", "提示",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(result==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	public void dealOpen(){
		panel.loadFromFile();
	}
	public void dealSave(){
		
	}
	public void dealSetting(){
		SetCounterDialog dialog=new SetCounterDialog(panel.getServiceCount());
		panel.setServiceCount(dialog.getCounterValue());
	}
}
