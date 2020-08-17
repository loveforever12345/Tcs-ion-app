package com.example.model;

public class StudentDataModel {
	int ID; 
	String STUDENTNAME;
	String BATCH;
	String BRANCH;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the sTUDENTNAME
	 */
	public String getSTUDENTNAME() {
		return STUDENTNAME;
	}
	/**
	 * @param sTUDENTNAME the sTUDENTNAME to set
	 */
	public void setSTUDENTNAME(String sTUDENTNAME) {
		STUDENTNAME = sTUDENTNAME;
	}
	/**
	 * @return the bATCH
	 */
	public String getBATCH() {
		return BATCH;
	}
	/**
	 * @param bATCH the bATCH to set
	 */
	public void setBATCH(String bATCH) {
		BATCH = bATCH;
	}
	/**
	 * @return the bRANCH
	 */
	public String getBRANCH() {
		return BRANCH;
	}
	/**
	 * @param bRANCH the bRANCH to set
	 */
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	@Override
	public String toString() {
		return "StudentDataModel [ID=" + ID + ", STUDENTNAME=" + STUDENTNAME + ", BATCH=" + BATCH + ", BRANCH=" + BRANCH
				+ "]";
	} 
}
