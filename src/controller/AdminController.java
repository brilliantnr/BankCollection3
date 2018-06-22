package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

enum AdminButt {
	// JOIN은 일반유저 추가, ADD는 직원 추가
	EXIT, 
	JOIN, ADD_STAFF_ONLY, 
	LIST, FIND_BY_ID, FIND_BY_NAME, COUNT,
	UPDATE, 
	REMOVE,
};

public class AdminController {
	public static void main(String[] args) {
		AdminButt[] buttons = { AdminButt.EXIT, 
				AdminButt.JOIN, AdminButt.ADD_STAFF_ONLY, 
				AdminButt.LIST,AdminButt.COUNT, AdminButt.FIND_BY_ID, AdminButt.FIND_BY_NAME, 
				AdminButt.UPDATE,
				AdminButt.REMOVE };

		MemberBean admin = null;
		AdminService service = new AdminServiceImpl();

		while (true) {
			AdminButt select = (AdminButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, buttons, null);
			switch (select) {
			case EXIT:
				return;
			case JOIN:
				admin = new UserBean();
				admin.setUid(JOptionPane.showInputDialog("ID"));
				admin.setPw(JOptionPane.showInputDialog("비번")); 
				admin.setName(JOptionPane.showInputDialog("이름"));
				admin.setSsn(JOptionPane.showInputDialog("주민번호"));
				admin.setPhone(JOptionPane.showInputDialog("전화번호"));
				admin.setEmail(JOptionPane.showInputDialog("이메일"));
				admin.setAddr(JOptionPane.showInputDialog("주소"));
				break;

			case ADD_STAFF_ONLY:
				admin = new StaffBean();
				admin.setUid(JOptionPane.showInputDialog("ID"));
				admin.setPw(JOptionPane.showInputDialog("비번")); 
				admin.setName(JOptionPane.showInputDialog("이름"));
				admin.setSsn(JOptionPane.showInputDialog("주민번호"));
				admin.setPhone(JOptionPane.showInputDialog("전화번호"));
				admin.setEmail(JOptionPane.showInputDialog("이메일"));
				admin.setAddr(JOptionPane.showInputDialog("주소"));
				break;
			case LIST:
				
				break;
			case COUNT:
			
				break;
			case FIND_BY_ID:
				
				break;
			case FIND_BY_NAME:
	
				break;
			case UPDATE:
			
				break;
			case REMOVE:
				
				break;
			default:
				break;
			}
		}
	}
}
