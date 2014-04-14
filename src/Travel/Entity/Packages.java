package Travel.Entity;

import java.util.Date;

public class Packages {

	private Integer packageId;
	private String packageName;
	private Date packageStartDate;
	private Date packageEndDate;
	private String packageDesc;
	private Double packagePrice;
	private Double packageAgencyComm;
	
	/**
	 * @return the packageId
	 */
	public Integer getPackageId() {
		return packageId;
	}
	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * @return the packageStartDate
	 */
	public Date getPackageStartDate() {
		return packageStartDate;
	}
	/**
	 * @param packageStartDate the packageStartDate to set
	 */
	public void setPackageStartDate(Date packageStartDate) {
		this.packageStartDate = packageStartDate;
	}
	/**
	 * @return the packageEndDate
	 */
	public Date getPackageEndDate() {
		return packageEndDate;
	}
	/**
	 * @param packageEndDate the packageEndDate to set
	 */
	public void setPackageEndDate(Date packageEndDate) {
		this.packageEndDate = packageEndDate;
	}
	/**
	 * @return the packageDesc
	 */
	public String getPackageDesc() {
		return packageDesc;
	}
	/**
	 * @param packageDesc the packageDesc to set
	 */
	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}
	/**
	 * @return the packagePrice
	 */
	public Double getPackagePrice() {
		return packagePrice;
	}
	/**
	 * @param packagePrice the packagePrice to set
	 */
	public void setPackagePrice(Double packagePrice) {
		this.packagePrice = packagePrice;
	}
	/**
	 * @return the packageAgencyComm
	 */
	public Double getPackageAgencyComm() {
		return packageAgencyComm;
	}
	/**
	 * @param packageAgencyComm the packageAgencyComm to set
	 */
	public void setPackageAgencyComm(Double packageAgencyComm) {
		this.packageAgencyComm = packageAgencyComm;
	}
	
	@Override
	public String toString() {
		return this.packageName;
	}
}
