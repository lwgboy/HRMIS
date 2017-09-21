/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.DataAccessException;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * 
 * 主界面
 * @author 田宇
 *
 */
public class MainMenu implements BaseUI {

	@Override
	public void run() {

		boolean isContinue = true;

		while (isContinue) {

			System.out.println("\n兴邦资讯 - Employee Information - Main Menu");
			System.out.println("=====================================================\n");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 – Print All Current Records (formatted)");
			System.out.println("3 – Print Names and Phone Numbers");
			System.out.println("4 – Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 – Delete Records");
			System.out.println("8 – Alter Records");
			System.out.println("9 – Add Managers Records\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection:");

			try {
				String entry = SysUtils.getEntry(false);
				switch(entry.toUpperCase().charAt(0)){
				  case '1':
					  UIloader.runUI(UIType.EMP_LISTER);
					  SysUtils.pause("\nPress Enter to continue...");
					  break;
				  case '2':
					  UIloader.runUI(UIType.EMP_FORMATTEDLISTER);
					  SysUtils.pause("\nPress Enter to continue...");
					  break;
				  case '3':
					  UIloader.runUI(UIType.EMP_SIMPLE_LISTER);
					  SysUtils.pause("\nPress Enter to continue...");
					  break;
				  case '4':
					  UIloader.runUI(UIType.EMP_FORMATTED_SIMPLE_LISTER);
					  SysUtils.pause("\nPress Enter to continue...");
					  break;
				  case '5':
					  UIloader.runUI(UIType.EMP_SERCHED_LISTER);
					  SysUtils.pause("\nPress Enter to continue...");
					  break;
				  case '6':
					  UIloader.runUI(UIType.EMP_ENROLL);
					  break;
				  case '7':
					  UIloader.runUI(UIType.EMP_DELETION);				 
					  break;
				  case '8':
					  UIloader.runUI(UIType.EMP_MODIFICATION);
					  break;
				  case '9':
					  UIloader.runUI(UIType.MANAGER_ENROLL);
					  break;
				  case 'Q':
					  isContinue = false;
					  break;
				  default:
					  SysUtils.pause("Invalid code! Press Enter to continue…");
				}
				continue;
			} catch (BlankEntryException e) {
				SysUtils.pause("No selection entered. Press Enter to continue…");
				continue;
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		 UIloader.runUI(UIType.EXIT);
	}

}
