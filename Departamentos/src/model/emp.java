package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class emp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int EMPNO;
	private String ENAME;
	private String JOB;
	private int MGR;
	private float SAL;
	private float COMM;
	private int DEPTNO;

	@Temporal(TemporalType.DATE)
	private Date HIREDATE;

	public emp() {
		super();
	}

	public emp(int EMPNO, String ENAME, String JOB, int MGR, float SAL, float COMM, int DEPTNO, Date HIREDATE) {
		super();
		this.EMPNO = EMPNO;
		this.ENAME = ENAME;
		this.JOB = JOB;
		this.MGR = MGR;
		this.SAL = SAL;
		this.COMM = COMM;
		this.DEPTNO = DEPTNO;
		this.HIREDATE = HIREDATE;
	}

	public int getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(int EMPNO) {
		this.EMPNO = EMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String ENAME) {
		this.ENAME = ENAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String JOB) {
		this.JOB = JOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int MGR) {
		this.MGR = MGR;
	}

	public float getSAL() {
		return SAL;
	}

	public void setSAL(float SAL) {
		this.SAL = SAL;
	}

	public float getCOMM() {
		return COMM;
	}

	public void setCOMM(float COMM) {
		this.COMM = COMM;
	}

	public int getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(int DEPTNO) {
		this.DEPTNO = DEPTNO;
	}

	public Date getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(Date HIREDATE) {
		this.HIREDATE = HIREDATE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(EMPNO, ENAME, JOB, MGR, SAL, COMM, DEPTNO, HIREDATE);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		emp other = (emp) obj;
		return EMPNO == other.EMPNO &&
			   MGR == other.MGR &&
			   Float.compare(other.SAL, SAL) == 0 &&
			   Float.compare(other.COMM, COMM) == 0 &&
			   DEPTNO == other.DEPTNO &&
			   Objects.equals(ENAME, other.ENAME) &&
			   Objects.equals(JOB, other.JOB) &&
			   Objects.equals(HIREDATE, other.HIREDATE);
	}

	@Override
	public String toString() {
		return "emp [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB +
			   ", MGR=" + MGR + ", SAL=" + SAL + ", COMM=" + COMM +
			   ", DEPTNO=" + DEPTNO + ", HIREDATE=" + HIREDATE + "]";
	}
}