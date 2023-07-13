package dev.glory.designpattern.createpattern.builder;

public class TourPlan {

    private String title;
    private String description;
    private String region;
    private String duration;
    private String price;

    private TourPlan() {
    }

    public TourPlan(String title, String description, String region, String duration, String price) {
        this.title = title;
        this.description = description;
        this.region = region;
        this.duration = duration;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
