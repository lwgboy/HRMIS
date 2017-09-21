/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.exception.NoFindedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.service.ManagerService;
import com.brainstrongtech.hrmis.service.ManagerServiceImpl;

/**
 * ��¼���� 
 * GUI Swing ���� 
 * @author ����
 *
 */
public class Login extends JFrame implements ActionListener{
	
	private JTextField text_username;
    private JPasswordField password_pwd;
    private JButton button_lg, button_close;
    private JLabel msgArea;
    
	public Login() {
		super("��¼");
		
		this.setBounds(500, 240, 500, 260);
		setResizable(false);
		setBackground(java.awt.Color.lightGray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new GridLayout(4, 1, 20, 10));
		getContentPane().add(new JLabel("�˰���Ѷ������Դ����ϵͳ", JLabel.CENTER));
		
		JPanel panel_1 = new JPanel(new GridLayout(2, 4, 0, 5));
		getContentPane().add(panel_1);
		
		panel_1.add(new JLabel(""));
		panel_1.add(new JLabel("�û�����", JLabel.CENTER));
		text_username = new JTextField(30);
		panel_1.add(text_username);
		panel_1.add(new JLabel(""));
		panel_1.add(new JLabel(""));
		panel_1.add(new JLabel("��    �룺", JLabel.CENTER));
		password_pwd = new JPasswordField(30);
		panel_1.add(password_pwd);
		panel_1.add(new JLabel(""));

		JPanel panel_2 = new JPanel(new GridLayout(1, 3, 30, 0));
		getContentPane().add(panel_2);
		panel_2.add(new JLabel(""));
		button_lg = new JButton("��½");
		panel_2.add(button_lg);
		panel_2.add(new JLabel(""));
		button_lg.addActionListener(this);
		
		JPanel panel_3 = new JPanel(new GridLayout(1, 4, 30, 0));
		msgArea = new JLabel();
		panel_3.add(new JLabel(""));
		panel_3.add(msgArea);
		panel_3.add(new JLabel(""));
		
		getContentPane().add(panel_3);
		setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
        
    	ManagerService managerService = new ManagerServiceImpl();
    	ManagerAccount managerAccount = null;
    	
        if (e.getSource() == button_lg) {
            if (text_username.getText().isEmpty() && password_pwd.getText().isEmpty()) {
                msgArea.setText("�������û���������!");
                return;
            }
            if (text_username.getText().isEmpty()) {
                msgArea.setText("�û�������Ϊ��!");
                return;
            }
            if (password_pwd.getText().isEmpty()) {
                msgArea.setText("���벻��Ϊ��!");
                return;
            }
			
				managerAccount = managerService.getManagerByName(text_username.getText());
				if (password_pwd.getText().equals(managerAccount.getPassWord())) {
					this.setVisible(false);
					UIloader.runUI(UIType.MAINMENU);
				}
				else{
				msgArea.setText("�û��������벻��ȷ��");
			    }
        }
    }

}
