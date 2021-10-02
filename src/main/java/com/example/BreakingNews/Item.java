package com.example.BreakingNews;

public class Item {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String guid;
    private String tags;
    public Item(String title, String description, String link, String pubDate, String guid, String tags) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
        this.guid = guid;
        this.tags = tags;
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
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
}
