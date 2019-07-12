package com.ybveg.ls.phoneapp.module.pojo;

public class Phone {
    private String id;  //明细id
    private String phoneId; // 手机id
    private String phoneName; // 手机名称
    private String sellPoint; //卖点
    private String prize; // 价格
    private String timeToMarket;  //上市时间
    private String phoneSize;  // 手机三维
    private String phoneScreenSize;  // 屏幕尺寸
    private String screenResolution;  //分辨率
    private String RearCamera;   //后置摄像头
    private String FrontCamera;  //前置摄像头
    private String os;   //操作系统
    private String cpu;
    private String ram;        //运行内存
    private String rom;  //存储
    private String pics;  //
    private String pic;  //
    private String RelatedArticles; // 相关文章链接

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getTimeToMarket() {
        return timeToMarket;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setTimeToMarket(String timeToMarket) {
        this.timeToMarket = timeToMarket;
    }

    public String getPhoneSize() {
        return phoneSize;
    }

    public void setPhoneSize(String phoneSize) {
        this.phoneSize = phoneSize;
    }

    public String getPhoneScreenSize() {
        return phoneScreenSize;
    }

    public void setPhoneScreenSize(String phoneScreenSize) {
        this.phoneScreenSize = phoneScreenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getRearCamera() {
        return RearCamera;
    }

    public void setRearCamera(String rearCamera) {
        RearCamera = rearCamera;
    }

    public String getFrontCamera() {
        return FrontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        FrontCamera = frontCamera;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getRelatedArticles() {
        return RelatedArticles;
    }

    public void setRelatedArticles(String relatedArticles) {
        RelatedArticles = relatedArticles;
    }

    public Phone(String id, String phoneId, String phoneName, String sellPoint, String prize, String timeToMarket, String phoneSize, String phoneScreenSize, String screenResolution, String rearCamera, String frontCamera, String os, String cpu, String ram, String rom, String pics, String relatedArticles) {
        this.id = id;
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.sellPoint = sellPoint;
        this.prize = prize;
        this.timeToMarket = timeToMarket;
        this.phoneSize = phoneSize;
        this.phoneScreenSize = phoneScreenSize;
        this.screenResolution = screenResolution;
        RearCamera = rearCamera;
        FrontCamera = frontCamera;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.pics = pics;
        RelatedArticles = relatedArticles;
    }
}
