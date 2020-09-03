package com.geimu.domain;

public class Enemy {

    private int level = 1;
    private int hp = 50;
    private int hpMax = 50;

    private double atk = 10;
    private double def = 3;
    private double hit = 35;
    private double cri = 10;
    private double flee = 50;
    private double aspd = 1;

    private int exp = 65;

    public Enemy(int playerLevel) {
        if (Math.random() * 100 < 30 && playerLevel != 1) {
            this.level = playerLevel - 1;
        } else if (Math.random() * 100 < 25) {
            this.level = playerLevel + 1;
        } else {
            this.level = playerLevel;
        }

        this.hpMax = (int) Math.round(this.hpMax * this.level * (1 + this.level / 5 * 0.4) * (Math.random() * 0.2 + 0.9));
        this.hp = this.hpMax;
        this.atk = (int) Math.round(this.atk * this.level * 0.875 * (Math.random() * 0.1 + 0.95));
        this.def = (int) Math.round(this.def * this.level * 0.875 * (Math.random() * 0.2 + 0.9));
        this.hit = (int) Math.round(this.hit * this.level * 0.8 * (Math.random() * 0.2 + 0.9));
        this.cri = (int) Math.round(this.cri * this.level * 0.8 * (Math.random() * 0.2 + 0.9));
        this.flee = (int) Math.round(this.flee * this.level * 0.9 * (Math.random() * 0.2 + 0.9));
        this.aspd = (int) Math.round(this.aspd * this.level * (Math.random() * 0.2 + 0.9));
        this.exp = (int) Math.round(this.exp * this.level * 1.15 * (Math.random() * 0.4 + 0.8));
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getHit() {
        return hit;
    }

    public void setHit(double hit) {
        this.hit = hit;
    }

    public double getCri() {
        return cri;
    }

    public void setCri(double cri) {
        this.cri = cri;
    }

    public double getFlee() {
        return flee;
    }

    public void setFlee(double flee) {
        this.flee = flee;
    }

    public double getAspd() {
        return aspd;
    }

    public void setAspd(double aspd) {
        this.aspd = aspd;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
