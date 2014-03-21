package com.williapv.geo.representation;

/**
 * Created by paul on 3/21/14.
 */
public class GeonameZip {
    private Long id;
    private String country;
    private String postalCode;
    private String placeName;
    private String stateName;
    private String stateAbbr;
    private String countyProvince;
    private String countyProvinceAbbr;
    private String communityName;
    private String communityAbbr;
    private Float latitude;
    private Float longitude;
    private Integer accuracy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getCountyProvince() {
        return countyProvince;
    }

    public void setCountyProvince(String countyProvince) {
        this.countyProvince = countyProvince;
    }

    public String getCountyProvinceAbbr() {
        return countyProvinceAbbr;
    }

    public void setCountyProvinceAbbr(String countyProvinceAbbr) {
        this.countyProvinceAbbr = countyProvinceAbbr;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAbbr() {
        return communityAbbr;
    }

    public void setCommunityAbbr(String communityAbbr) {
        this.communityAbbr = communityAbbr;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }
}
