package xuzhenzhen.com.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetCounterDialog implements ActionListener{
	private JDialog dialog;
	private JTextField counterNum;
	private JButton OKBtn;
	private JButton cancelBtn;
	private int counterCount;
	public SetCounterDialog(int counterCount) {
		this.counterCount = counterCount;
		init();
	}
	public void init(){
		dialog = new JDialog(new JDialog(),"设置服务台个数",true);
		counterNum=new JTextField();
		counterNum.setText(this.counterCount+"");
		OKBtn=new JButton("确定");
		cancelBtn=new JButton("取消");
		OKBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		dialog.setLayout(new BorderLayout());
		JPanel panel=new JPanel(new GridLayout(1, 2,1,2));
		panel.add(new JLabel("服务台个数：",JLabel.CENTER));
		panel.add(counterNum);
		JPanel btnPanel=new JPanel(new GridLayout(1, 2));
		btnPanel.add(OKBtn);
		btnPanel.add(cancelBtn);
		dialog.add(panel,BorderLayout.CENTER);
		dialog.add(btnPanel,BorderLayout.SOUTH);
        dialog.setSize(200, 100);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
	}
	public int getCounterValue(){
		return this.counterCount;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		if(event.equals("确定")){
			try {
				int temp=Integer.parseInt(counterNum.getText());
				this.counterCount=temp;
				dialog.dispose();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "数据输入错误！", "警告",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(event.equals("取消")){
			dialog.dispose();
		}
	}
}