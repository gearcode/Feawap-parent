package com.gearcode.feawap.domain;

import java.util.Date;

public class Train {
    private Integer id;

    private String title;

    private Date start;

    private Date end;

    private Integer days;

    private Integer peoples;

    private Integer cost;

    private String place;

    private String address;

    private String icon;

    private Integer type;

    private Date updateTime;

    private Date created;

    private String color;

    private String positionTitle;

    private String positionDescription;

    private Double positionLat;

    private Double positionLng;

    private String hotels;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getPeoples() {
        return peoples;
    }

    public void setPeoples(Integer peoples) {
        this.peoples = peoples;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle == null ? null : positionTitle.trim();
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription == null ? null : positionDescription.trim();
    }

    public Double getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(Double positionLat) {
        this.positionLat = positionLat;
    }

    public Double getPositionLng() {
        return positionLng;
    }

    public void setPositionLng(Double positionLng) {
        this.positionLng = positionLng;
    }

    public String getHotels() {
        return hotels;
    }

    public void setHotels(String hotels) {
        this.hotels = hotels == null ? null : hotels.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}