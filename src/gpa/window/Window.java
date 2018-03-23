package gpa.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import gpa.data.GradeData;
import gpa.utill.Calculate;
import gpa.utill.FileRead;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Window {

	private JFrame frmGpa;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;

	private ArrayList<GradeData> gradeDatas = new ArrayList<GradeData>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmGpa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGpa = new JFrame();
		frmGpa.setTitle("GPA计算器");
		frmGpa.setBounds(100, 100, 450, 300);
		frmGpa.setSize(800, 500);
		frmGpa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpa.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(547, 17, 229, 39);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frmGpa.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("GPA：");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("0.0");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 25));
		panel_2.add(lblNewLabel_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(557, 77, 229, 395);
		frmGpa.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("成绩表");
		lblNewLabel_5.setBounds(77, 5, 75, 26);
		lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 25));
		panel_4.add(lblNewLabel_5);

		// table = new JTable(rowDatas, columnNames);
		// panel_table.add(table.getTableHeader(), BorderLayout.NORTH);

		JButton btnNewButton_4 = new JButton("绩点计算");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (gradeDatas.size() == 0) {
					lblNewLabel_1.setText("0.0");
				} else {
					Calculate calculate = new Calculate();
					float gpa = calculate.calculate(gradeDatas);
					lblNewLabel_1.setText(String.valueOf(gpa));
				}

			}
		});

		JPanel panel_table = new JPanel();
		panel_table.setBounds(0, 43, 229, 315);
		panel_4.add(panel_table);
		panel_table.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		// textArea.setWrapStyleWord(true);
		textArea.setBounds(6, 5, 217, 304);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(229, 315);
		panel_table.add(scrollPane);
		btnNewButton_4.setBounds(9, 370, 96, 30);
		panel_4.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("清空成绩表");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gradeDatas.clear();
				textArea.setText("");
				lblNewLabel_1.setText("0.0");

			}
		});
		btnNewButton_5.setBounds(110, 370, 109, 29);
		panel_4.add(btnNewButton_5);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(18, 62, 517, 395);
		frmGpa.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("课程名称：");
		lblNewLabel_2.setBounds(25, 23, 65, 16);
		panel_3.add(lblNewLabel_2);

		textField_0 = new JTextField();
		textField_0.setBounds(87, 18, 65, 26);
		panel_3.add(textField_0);
		textField_0.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("课程学分：");
		lblNewLabel_3.setBounds(178, 23, 65, 16);
		panel_3.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(241, 18, 65, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("课程成绩：");
		lblNewLabel_4.setBounds(334, 23, 65, 16);
		panel_3.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBounds(395, 18, 65, 26);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JLabel label = new JLabel("课程名称：");
		label.setBounds(25, 73, 65, 16);
		panel_3.add(label);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(87, 68, 65, 26);
		panel_3.add(textField_3);

		JLabel label_1 = new JLabel("课程学分：");
		label_1.setBounds(178, 73, 65, 16);
		panel_3.add(label_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(241, 68, 65, 26);
		panel_3.add(textField_4);

		JLabel label_2 = new JLabel("课程成绩：");
		label_2.setBounds(334, 73, 65, 16);
		panel_3.add(label_2);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(395, 68, 65, 26);
		panel_3.add(textField_5);

		JLabel label_3 = new JLabel("课程名称：");
		label_3.setBounds(25, 123, 65, 16);
		panel_3.add(label_3);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(87, 118, 65, 26);
		panel_3.add(textField_6);

		JLabel label_4 = new JLabel("课程学分：");
		label_4.setBounds(178, 123, 65, 16);
		panel_3.add(label_4);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(241, 118, 65, 26);
		panel_3.add(textField_7);

		JLabel label_5 = new JLabel("课程成绩：");
		label_5.setBounds(334, 123, 65, 16);
		panel_3.add(label_5);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(395, 118, 65, 26);
		panel_3.add(textField_8);

		JLabel label_6 = new JLabel("课程名称：");
		label_6.setBounds(25, 173, 65, 16);
		panel_3.add(label_6);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(87, 168, 65, 26);
		panel_3.add(textField_9);

		JLabel label_7 = new JLabel("课程学分：");
		label_7.setBounds(178, 173, 65, 16);
		panel_3.add(label_7);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(241, 168, 65, 26);
		panel_3.add(textField_10);

		JLabel label_8 = new JLabel("课程成绩：");
		label_8.setBounds(334, 173, 65, 16);
		panel_3.add(label_8);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(395, 168, 65, 26);
		panel_3.add(textField_11);

		JLabel label_9 = new JLabel("课程名称：");
		label_9.setBounds(25, 223, 65, 16);
		panel_3.add(label_9);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(87, 216, 65, 26);
		panel_3.add(textField_12);

		JLabel label_10 = new JLabel("课程学分：");
		label_10.setBounds(178, 223, 65, 16);
		panel_3.add(label_10);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(241, 216, 65, 26);
		panel_3.add(textField_13);

		JLabel label_11 = new JLabel("课程成绩：");
		label_11.setBounds(334, 223, 65, 16);
		panel_3.add(label_11);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(395, 216, 65, 26);
		panel_3.add(textField_14);

		JLabel label_12 = new JLabel("课程名称：");
		label_12.setBounds(25, 273, 65, 16);
		panel_3.add(label_12);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(87, 268, 65, 26);
		panel_3.add(textField_15);

		JLabel label_13 = new JLabel("课程学分：");
		label_13.setBounds(178, 273, 65, 16);
		panel_3.add(label_13);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(241, 268, 65, 26);
		panel_3.add(textField_16);

		JLabel label_14 = new JLabel("课程成绩：");
		label_14.setBounds(334, 273, 65, 16);
		panel_3.add(label_14);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(395, 268, 65, 26);
		panel_3.add(textField_17);

		JLabel label_15 = new JLabel("课程名称：");
		label_15.setBounds(25, 323, 65, 16);
		panel_3.add(label_15);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(87, 318, 65, 26);
		panel_3.add(textField_18);

		JLabel label_16 = new JLabel("课程学分：");
		label_16.setBounds(178, 323, 65, 16);
		panel_3.add(label_16);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(241, 318, 65, 26);
		panel_3.add(textField_19);

		JLabel label_17 = new JLabel("课程成绩：");
		label_17.setBounds(334, 323, 65, 16);
		panel_3.add(label_17);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(395, 318, 65, 26);
		panel_3.add(textField_20);

		JButton btnNewButton_3 = new JButton("添加成绩到成绩表");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_1.getText().trim().equals("") && textField_2.getText().trim().equals("")) {

				} else {
					GradeData gradeData1 = new GradeData();

					String course1 = textField_0.getText();
					String credit1 = textField_1.getText();
					float grade1 = Float.valueOf(textField_2.getText());

					gradeData1.setCourse(course1);
					gradeData1.setCredit(credit1);
					gradeData1.setGrade(grade1);

					gradeDatas.add(gradeData1);
				}

				if (textField_4.getText().trim().equals("") && textField_5.getText().trim().equals("")) {

				} else {
					GradeData gradeData2 = new GradeData();

					String course2 = textField_3.getText();
					String credit2 = textField_4.getText();
					float grade2 = Float.valueOf(textField_5.getText());

					gradeData2.setCourse(course2);
					gradeData2.setCredit(credit2);
					gradeData2.setGrade(grade2);

					gradeDatas.add(gradeData2);
				}

				if (textField_7.getText().trim().equals("") && textField_8.getText().trim().equals("")) {

				} else {
					GradeData gradeData3 = new GradeData();

					String course3 = textField_6.getText();
					String credit3 = textField_7.getText();
					float grade3 = Float.valueOf(textField_8.getText());

					gradeData3.setCourse(course3);
					gradeData3.setCredit(credit3);
					gradeData3.setGrade(grade3);

					gradeDatas.add(gradeData3);
				}

				if (textField_10.getText().trim().equals("") && textField_11.getText().trim().equals("")) {

				} else {
					GradeData gradeData4 = new GradeData();

					String course4 = textField_9.getText();
					String credit4 = textField_10.getText();
					float grade4 = Float.valueOf(textField_11.getText());

					gradeData4.setCourse(course4);
					gradeData4.setCredit(credit4);
					gradeData4.setGrade(grade4);

					gradeDatas.add(gradeData4);
				}

				if (textField_13.getText().trim().equals("") && textField_14.getText().trim().equals("")) {

				} else {
					GradeData gradeData5 = new GradeData();

					String course5 = textField_12.getText();
					String credit5 = textField_13.getText();
					float grade5 = Float.valueOf(textField_14.getText());

					gradeData5.setCourse(course5);
					gradeData5.setCredit(credit5);
					gradeData5.setGrade(grade5);

					gradeDatas.add(gradeData5);
				}

				if (textField_16.getText().trim().equals("") && textField_17.getText().trim().equals("")) {

				} else {
					GradeData gradeData6 = new GradeData();

					String course6 = textField_15.getText();
					String credit6 = textField_16.getText();
					float grade6 = Float.valueOf(textField_17.getText());

					gradeData6.setCourse(course6);
					gradeData6.setCredit(credit6);
					gradeData6.setGrade(grade6);

					gradeDatas.add(gradeData6);
				}

				if (textField_19.getText().trim().equals("") && textField_20.getText().trim().equals("")) {

				} else {
					GradeData gradeData7 = new GradeData();

					String course7 = textField_18.getText();
					String credit7 = textField_19.getText();
					float grade7 = Float.valueOf(textField_20.getText());

					gradeData7.setCourse(course7);
					gradeData7.setCredit(credit7);
					gradeData7.setGrade(grade7);

					gradeDatas.add(gradeData7);
				}

				String showInfo = "";
				int num = 1;

				for (GradeData gradeData : gradeDatas) {

					showInfo = showInfo + num + ". |" + " 课程名称：" + gradeData.getCourse() + " | 课程学分："
							+ gradeData.getCredit() + " | 课程成绩：" + gradeData.getGrade() + " |    //   ";

					num++;

				}

				textArea.setText(showInfo);

				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");

			}
		});
		btnNewButton_3.setBounds(251, 370, 209, 26);
		panel_3.add(btnNewButton_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 17, 517, 39);
		frmGpa.getContentPane().add(panel_1);

		JButton btnNewButton = new JButton("手动输入计算");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "你已在当前页面");
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("TXT文件上传计算");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setMultiSelectionEnabled(false);

				int returnVal = jFileChooser.showOpenDialog(btnNewButton_1);

				FileRead txtRead = new FileRead();

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					String filepath = jFileChooser.getSelectedFile().getAbsolutePath();
					// System.out.println(filepath);

					gradeDatas = txtRead.txtRead(filepath);
					if (gradeDatas.size() == 0) {
						lblNewLabel_1.setText("0.0");
						JOptionPane.showMessageDialog(null, "该文件无符合格式的成绩信息！！！");
					} else {
						String showInfo = "";
						int num = 1;
						for (GradeData gradeData : gradeDatas) {
							showInfo = showInfo + num + ". |" + " 课程名称：" + gradeData.getCourse() + " | 课程学分："
									+ gradeData.getCredit() + " | 课程成绩：" + gradeData.getGrade() + " |    //   ";
							num++;
						}
						textArea.setText(showInfo);
						Calculate calculate = new Calculate();
						float gpa = calculate.calculate(gradeDatas);
						lblNewLabel_1.setText(String.valueOf(gpa));
					}
				}
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excel文件上传计算");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setMultiSelectionEnabled(false);

				int returnVal = jFileChooser.showOpenDialog(btnNewButton_1);

				FileRead txtRead = new FileRead();

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					String filepath = jFileChooser.getSelectedFile().getAbsolutePath();
					// System.out.println(filepath);

					gradeDatas = txtRead.excelRead(filepath);
					if (gradeDatas.size() == 0) {
						lblNewLabel_1.setText("0.0");
						JOptionPane.showMessageDialog(null, "该文件无符合格式的成绩信息！！！");
					} else {
						String showInfo = "";
						int num = 1;
						for (GradeData gradeData : gradeDatas) {
							showInfo = showInfo + num + ". |" + " 课程名称：" + gradeData.getCourse() + " | 课程学分："
									+ gradeData.getCredit() + " | 课程成绩：" + gradeData.getGrade() + " |    //   ";
							num++;
						}
						textArea.setText(showInfo);
						Calculate calculate = new Calculate();
						float gpa = calculate.calculate(gradeDatas);
						lblNewLabel_1.setText(String.valueOf(gpa));
					}
				}
			}
		});
		panel_1.add(btnNewButton_2);

	}
}
