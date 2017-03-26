package com.jeff.po;

import javax.persistence.*;

public class Countrylanguage {
    @Id
    @Column(name = "CountryCode")
    private String countrycode;

    @Id
    @Column(name = "Language")
    private String language;

    @Column(name = "IsOfficial")
    private String isofficial;

    @Column(name = "Percentage")
    private Float percentage;

    /**
     * @return CountryCode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * @param countrycode
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * @return Language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return IsOfficial
     */
    public String getIsofficial() {
        return isofficial;
    }

    /**
     * @param isofficial
     */
    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial;
    }

    /**
     * @return Percentage
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * @param percentage
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}