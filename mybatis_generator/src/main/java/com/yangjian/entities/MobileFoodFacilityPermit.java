package com.yangjian.entities;

import javax.persistence.*;

/**
 * 表名：t_mobile_food_facility_permit
*/
@Table(name = "t_mobile_food_facility_permit")
public class MobileFoodFacilityPermit {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer locationid;

    private Integer cnn;

    private Integer lot;

    @Column(name = "X")
    private Double x;

    @Column(name = "Y")
    private Double y;

    @Column(name = "Latitude")
    private Double latitude;

    @Column(name = "Longitude")
    private Double longitude;

    @Column(name = "Received")
    private Integer received;

    @Column(name = "PriorPermit")
    private Integer priorpermit;

    @Column(name = "`Fire Prevention Districts`")
    private Integer firePreventionDistricts;

    @Column(name = "`Police Districts`")
    private Integer policeDistricts;

    @Column(name = "`Supervisor Districts`")
    private Integer supervisorDistricts;

    @Column(name = "`Zip Codes`")
    private Integer zipCodes;

    @Column(name = "Neighborhoods")
    private Integer neighborhoods;

    @Column(name = "Applicant")
    private String applicant;

    @Column(name = "FacilityType")
    private String facilitytype;

    @Column(name = "LocationDescription")
    private String locationdescription;

    @Column(name = "Address")
    private String address;

    private String blocklot;

    private String block;

    private String permit;

    @Column(name = "Status")
    private String status;

    @Column(name = "FoodItems")
    private String fooditems;

    @Column(name = "Schedule")
    private String schedule;

    private String dayshours;

    @Column(name = "NOISent")
    private String noisent;

    @Column(name = "Approved")
    private String approved;

    @Column(name = "ExpirationDate")
    private String expirationdate;

    @Column(name = "Location")
    private String location;

    /**
     * @return locationid
     */
    public Integer getLocationid() {
        return locationid;
    }

    /**
     * @param locationid
     */
    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    /**
     * @return cnn
     */
    public Integer getCnn() {
        return cnn;
    }

    /**
     * @param cnn
     */
    public void setCnn(Integer cnn) {
        this.cnn = cnn;
    }

    /**
     * @return lot
     */
    public Integer getLot() {
        return lot;
    }

    /**
     * @param lot
     */
    public void setLot(Integer lot) {
        this.lot = lot;
    }

    /**
     * @return x
     */
    public Double getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * @return y
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return received
     */
    public Integer getReceived() {
        return received;
    }

    /**
     * @param received
     */
    public void setReceived(Integer received) {
        this.received = received;
    }

    /**
     * @return priorpermit
     */
    public Integer getPriorpermit() {
        return priorpermit;
    }

    /**
     * @param priorpermit
     */
    public void setPriorpermit(Integer priorpermit) {
        this.priorpermit = priorpermit;
    }

    /**
     * @return firePreventionDistricts
     */
    public Integer getFirePreventionDistricts() {
        return firePreventionDistricts;
    }

    /**
     * @param firePreventionDistricts
     */
    public void setFirePreventionDistricts(Integer firePreventionDistricts) {
        this.firePreventionDistricts = firePreventionDistricts;
    }

    /**
     * @return policeDistricts
     */
    public Integer getPoliceDistricts() {
        return policeDistricts;
    }

    /**
     * @param policeDistricts
     */
    public void setPoliceDistricts(Integer policeDistricts) {
        this.policeDistricts = policeDistricts;
    }

    /**
     * @return supervisorDistricts
     */
    public Integer getSupervisorDistricts() {
        return supervisorDistricts;
    }

    /**
     * @param supervisorDistricts
     */
    public void setSupervisorDistricts(Integer supervisorDistricts) {
        this.supervisorDistricts = supervisorDistricts;
    }

    /**
     * @return zipCodes
     */
    public Integer getZipCodes() {
        return zipCodes;
    }

    /**
     * @param zipCodes
     */
    public void setZipCodes(Integer zipCodes) {
        this.zipCodes = zipCodes;
    }

    /**
     * @return neighborhoods
     */
    public Integer getNeighborhoods() {
        return neighborhoods;
    }

    /**
     * @param neighborhoods
     */
    public void setNeighborhoods(Integer neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    /**
     * @return applicant
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * @param applicant
     */
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    /**
     * @return facilitytype
     */
    public String getFacilitytype() {
        return facilitytype;
    }

    /**
     * @param facilitytype
     */
    public void setFacilitytype(String facilitytype) {
        this.facilitytype = facilitytype;
    }

    /**
     * @return locationdescription
     */
    public String getLocationdescription() {
        return locationdescription;
    }

    /**
     * @param locationdescription
     */
    public void setLocationdescription(String locationdescription) {
        this.locationdescription = locationdescription;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return blocklot
     */
    public String getBlocklot() {
        return blocklot;
    }

    /**
     * @param blocklot
     */
    public void setBlocklot(String blocklot) {
        this.blocklot = blocklot;
    }

    /**
     * @return block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * @return permit
     */
    public String getPermit() {
        return permit;
    }

    /**
     * @param permit
     */
    public void setPermit(String permit) {
        this.permit = permit;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return fooditems
     */
    public String getFooditems() {
        return fooditems;
    }

    /**
     * @param fooditems
     */
    public void setFooditems(String fooditems) {
        this.fooditems = fooditems;
    }

    /**
     * @return schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * @param schedule
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * @return dayshours
     */
    public String getDayshours() {
        return dayshours;
    }

    /**
     * @param dayshours
     */
    public void setDayshours(String dayshours) {
        this.dayshours = dayshours;
    }

    /**
     * @return noisent
     */
    public String getNoisent() {
        return noisent;
    }

    /**
     * @param noisent
     */
    public void setNoisent(String noisent) {
        this.noisent = noisent;
    }

    /**
     * @return approved
     */
    public String getApproved() {
        return approved;
    }

    /**
     * @param approved
     */
    public void setApproved(String approved) {
        this.approved = approved;
    }

    /**
     * @return expirationdate
     */
    public String getExpirationdate() {
        return expirationdate;
    }

    /**
     * @param expirationdate
     */
    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
}