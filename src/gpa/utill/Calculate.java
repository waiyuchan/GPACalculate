package gpa.utill;

import java.util.ArrayList;
import gpa.data.GradeData;

public class Calculate {

	private float gpa = 0;// 计算出来的gpa结果
	private float oGrade = 0; // 每行的学分*成绩
	private float totalGrade = 0; // 所有的学分成绩积的和
	private float credit;// 每一行的学分
	private float totalCredit = 0;// 所有学分的和

	public float calculate(ArrayList<GradeData> gradeDatas) {

		//求和所有的学分成绩积的计算
		for (GradeData gData : gradeDatas) {
			oGrade = Float.parseFloat(gData.getCredit()) * gData.getGrade();
			totalGrade += oGrade;
		}

		//求和所有学分的计算
		for (GradeData gData : gradeDatas) {
			credit = Float.parseFloat(gData.getCredit());
			totalCredit += credit;
		}

		//gpa计算
		gpa = totalGrade / totalCredit;
		return gpa;
	}

}
