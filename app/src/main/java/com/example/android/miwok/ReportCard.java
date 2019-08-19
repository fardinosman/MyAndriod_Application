package com.example.android.miwok;

public class ReportCard {


    String studenName;
    char englsihGrade = 'A';
    String mathGrade = "A-";
    int historyGrade = 85;
    double biologyGrade = 95.5;

    public ReportCard(String sn, char eg, String mg, int hg,double bg){
        this.studenName= sn;
        this.englsihGrade=eg;
        this.mathGrade=mg;
        this.historyGrade=hg;
        this.biologyGrade=bg;
    }

    public int getHistoryGrade(){
        return historyGrade;
    }
    public void setHistoryGrade(int grade){
        historyGrade = grade;
    }

    @Override
    public String toString() {
        String report = "Name: " + studenName+ "\n" +"EnglsihGrade: "+ englsihGrade +"\n"+"MathGrade: "+ mathGrade+"\n"+
                "HistroyGrade: "+ historyGrade+"\n"+
                "BiologyGrade: " + biologyGrade;
        return report;
    }
}
