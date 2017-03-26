package com.jeff.po;

import javax.persistence.*;

public class Country {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Continent")
    private String continent;

    @Column(name = "Region")
    private String region;

    @Column(name = "SurfaceArea")
    private Float surfacearea;

    @Column(name = "IndepYear")
    private Short indepyear;

    @Column(name = "Population")
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Float lifeexpectancy;

    @Column(name = "GNP")
    private Float gnp;

    @Column(name = "GNPOld")
    private Float gnpold;

    @Column(name = "LocalName")
    private String localname;

    @Column(name = "GovernmentForm")
    private String governmentform;

    @Column(name = "HeadOfState")
    private String headofstate;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2")
    private String code2;

    /**
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @param continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * @return Region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return SurfaceArea
     */
    public Float getSurfacearea() {
        return surfacearea;
    }

    /**
     * @param surfacearea
     */
    public void setSurfacearea(Float surfacearea) {
        this.surfacearea = surfacearea;
    }

    /**
     * @return IndepYear
     */
    public Short getIndepyear() {
        return indepyear;
    }

    /**
     * @param indepyear
     */
    public void setIndepyear(Short indepyear) {
        this.indepyear = indepyear;
    }

    /**
     * @return Population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * @param population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * @return LifeExpectancy
     */
    public Float getLifeexpectancy() {
        return lifeexpectancy;
    }

    /**
     * @param lifeexpectancy
     */
    public void setLifeexpectancy(Float lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    /**
     * @return GNP
     */
    public Float getGnp() {
        return gnp;
    }

    /**
     * @param gnp
     */
    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    /**
     * @return GNPOld
     */
    public Float getGnpold() {
        return gnpold;
    }

    /**
     * @param gnpold
     */
    public void setGnpold(Float gnpold) {
        this.gnpold = gnpold;
    }

    /**
     * @return LocalName
     */
    public String getLocalname() {
        return localname;
    }

    /**
     * @param localname
     */
    public void setLocalname(String localname) {
        this.localname = localname;
    }

    /**
     * @return GovernmentForm
     */
    public String getGovernmentform() {
        return governmentform;
    }

    /**
     * @param governmentform
     */
    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    /**
     * @return HeadOfState
     */
    public String getHeadofstate() {
        return headofstate;
    }

    /**
     * @param headofstate
     */
    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    /**
     * @return Capital
     */
    public Integer getCapital() {
        return capital;
    }

    /**
     * @param capital
     */
    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    /**
     * @return Code2
     */
    public String getCode2() {
        return code2;
    }

    /**
     * @param code2
     */
    public void setCode2(String code2) {
        this.code2 = code2;
    }
}