package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
 
public class AccountController {
	enum AccountButt { 
		BASIC, MINUSACCOUNT, LIST, MINUS_LIST, FIND_BY_ID, FIND_BY_NAME,CHANGE_PW,DELETE_ACCOUNT, EXIT
	};
 
	public static void main(String[] args) {
		AccountButt[] buttons = { AccountButt.BASIC, AccountButt.MINUSACCOUNT, AccountButt.LIST, AccountButt.MINUS_LIST,
				AccountButt.FIND_BY_ID, AccountButt.FIND_BY_NAME, AccountButt.CHANGE_PW,
				AccountButt.DELETE_ACCOUNT,AccountButt.EXIT };
		AccountBean ac=null;  //★선언만 하는건 인터페이스, 클래스에선 초기화
		AccountService service = new AccountServiceImpl();
	
		while (true) {
			AccountButt select = (AccountButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, buttons, null);
			
			switch (select) {
			case EXIT:
				return;
			case BASIC: 
				ac = new AccountBean();
				ac.setName(JOptionPane.showInputDialog("이름"));
				ac.setUid(JOptionPane.showInputDialog("아이디"));
				ac.setPw(JOptionPane.showInputDialog("비번"));
				service.createAccount(ac);
				break;
			case MINUSACCOUNT:
				ac=new MinusAccountBean();
				ac.setName(JOptionPane.showInputDialog("이름"));
				ac.setUid(JOptionPane.showInputDialog("아이디"));
				ac.setPw(JOptionPane.showInputDialog("비번"));
				service.createMinusAccount((MinusAccountBean)ac);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case MINUS_LIST:
				
				break;
			case FIND_BY_ID:
				ac =new AccountBean();
				ac.setName(JOptionPane.showInputDialog("이름"));
				ac.setUid(JOptionPane.showInputDialog("아이디"));
				ac.setPw(JOptionPane.showInputDialog("비번"));
				JOptionPane.showInputDialog(null, service.findById(ac));
				break;
			case FIND_BY_NAME:
				JOptionPane.showInputDialog(null, service.findByName(JOptionPane.showInputDialog("이름?")));
				break;
			case CHANGE_PW:	
				ac = new AccountBean();
				ac.setUid(JOptionPane.showInputDialog("아이디"));
				ac.setPw((JOptionPane.showInputDialog("비밀번호")
						+"/"+
						JOptionPane.showInputDialog("새로운 비밀번호")));
				service.updatePw(ac);
				break;
			case DELETE_ACCOUNT:
				ac=new AccountBean();
				ac.setUid(JOptionPane.showInputDialog("삭제할 계좌의 아이디"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호")
						+"/"+
						JOptionPane.showInputDialog("비밀번호 확인"));
				
				service.deleteAccount(ac);
			break;
			default:
				break;
			}
		}
	}
}
