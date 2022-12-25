package wsp;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable
{
	private int firstAttestation;
	private int secondAttestation;
	private int finalExam;

	public Mark(){
		firstAttestation = -1;
		secondAttestation = -1;
		finalExam = -1;
	}
	
	public void firstAttestation(int x) {
		this.firstAttestation = x;
	}
	
	public void secondAttestation(int x) {
		this.secondAttestation = x;
	}
	
	public void finalExam(int x) {
		this.finalExam = x;
	}

	public String getMark() {
		return "First Attestation : " + firstAttestation + "\n" + 
			   "Second Attestation : " + secondAttestation + "\n" + 
			   "Final Exam Mark : " + finalExam + "\n";	
	}
	
	public int getMarkINT() {
		return firstAttestation + secondAttestation + finalExam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(finalExam, firstAttestation, secondAttestation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return finalExam == other.finalExam && firstAttestation == other.firstAttestation
				&& secondAttestation == other.secondAttestation;
	}
}
