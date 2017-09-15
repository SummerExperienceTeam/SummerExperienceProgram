import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javafx.scene.paint.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;


public class DbQuery extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;  
	private JTable table;
	private JLabel experiencesLabel;
	
	
	Experience testExperience = new Experience(true,true,"Greenpeace","California", "Monteray", 
			"Saving the whales", "It was fun", 30, Experience.StudentStanding.SENIOR, Experience.CompensationType.UNPAID,
			Experience.MainActivity.VOLUNTEERING);
	/*
	 * boolean international, boolean internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, int hoursPerWeek, StudentStanding standing,
			CompensationType compensation, MainActivity activity
	 */

	public static void main(String[] args) {
		DbQuery ourGUI = new DbQuery();
	}

	
	public DbQuery() {
		
		setTitle("Database Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 1200, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		
		
		
		
//		JLabel enterQuery = new JLabel("Enter Query");
//		panel.add(enterQuery);
//		
//		lastNameTextField = new JTextField();
//		panel.add(lastNameTextField);
//		lastNameTextField.setColumns(10);
//		
//		btnSearch = new JButton("Search");
//		panel.add(btnSearch);
//		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		experiencesLabel = new JLabel(testExperience.toString());
		experiencesLabel.setLayout(new GridLayout());
		contentPane.add(experiencesLabel, BorderLayout.CENTER);
		
		
		
	
	//Drop down menus/ 
		
		String[] StateFilter = { "Select State", "Alabama", "Alaska", "Arkansas", "California"};
		JComboBox stateList = new JComboBox(StateFilter);
		panel.add(stateList);
		
		String[] studentStandingFilter = { "Select Year" ,"Rising Sophmore", "Rising Junior", "Rising Senior"};
		JComboBox studentStandingList = new JComboBox(studentStandingFilter);
		panel.add(studentStandingList);
		
		String[] compensationFilter = { "Select Financial Compensation", "Unpaid", "Paid", "Stipend"};
		JComboBox compensationList = new JComboBox(compensationFilter);
		panel.add(compensationList);
		
		String[] mainActivityFilter = { "Select Main Activity", "Block at CC", "Music performance/study", "Time off traveling", "Study abroad"
				,"Summer Job", "Class at another institution", "Academic research position","Volunteer/service position" };
		JComboBox mainActivityList = new JComboBox(mainActivityFilter);
		panel.add(mainActivityList);
		
		JCheckBox internationalBox = new JCheckBox("International Students");
		internationalBox.setMnemonic(KeyEvent.VK_C); 
		internationalBox.setSelected(false);
		panel.add(internationalBox);
		

		JCheckBox internshipBox = new JCheckBox("Internship");
		internshipBox.setMnemonic(KeyEvent.VK_C); 
		internshipBox.setSelected(false);
		panel.add(internshipBox);
		//internationalBox.addItemListener(this);
		setVisible(true);
		
		
	}

}
