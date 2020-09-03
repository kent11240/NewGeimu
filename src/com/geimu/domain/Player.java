package com.geimu.domain;

public class Player {

    private int level = 1;
    private int exp = 0;
    private int expMax = 100;
    private int hp = 100;
    private int hpMax = 100;
    private int mp = 50;
    private int mpMax = 50;

    private int str = 1;
    private int agi = 1;
    private int vit = 1;
    private int wis = 1;
    private int dex = 1;
    private int luk = 1;

    private int points = 12;

    private double atk = 10;
    private double matk = 15;
    private double def = 5;
    private double hit = 12.5;
    private double cri = 5;
    private double flee = 10;
    private double aspd = 1;

    private double atkBuff = 0;
    private double matkBuff = 0;
    private double defBuff = 0;
    private double hitBuff = 0;
    private double criBuff = 0;
    private double fleeBuff = 0;
    private double aspdBuff = 0;

    private int skillPoints = 1;

    private int fireLevel = 0;
    private int healLevel = 0;
    private int bladeLevel = 0;
    private int blessLevel = 0;
    private int curseLevel = 0;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpMax() {
        return expMax;
    }

    public void setExpMax(int expMax) {
        this.expMax = expMax;
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

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMpMax() {
        return mpMax;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getLuk() {
        return luk;
    }

    public void setLuk(int luk) {
        this.luk = luk;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int point) {
        this.points = point;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getMatk() {
        return matk;
    }

    public void setMatk(double matk) {
        this.matk = matk;
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

    public double getAtkBuff() {
        return atkBuff;
    }

    public void setAtkBuff(double atkBuff) {
        this.atkBuff = atkBuff;
    }

    public double getMatkBuff() {
        return matkBuff;
    }

    public void setMatkBuff(double matkBuff) {
        this.matkBuff = matkBuff;
    }

    public double getDefBuff() {
        return defBuff;
    }

    public void setDefBuff(double defBuff) {
        this.defBuff = defBuff;
    }

    public double getHitBuff() {
        return hitBuff;
    }

    public void setHitBuff(double hitBuff) {
        this.hitBuff = hitBuff;
    }

    public double getCriBuff() {
        return criBuff;
    }

    public void setCriBuff(double criBuff) {
        this.criBuff = criBuff;
    }

    public double getFleeBuff() {
        return fleeBuff;
    }

    public void setFleeBuff(double fleeBuff) {
        this.fleeBuff = fleeBuff;
    }

    public double getAspdBuff() {
        return aspdBuff;
    }

    public void setAspdBuff(double aspdBuff) {
        this.aspdBuff = aspdBuff;
    }

    public double calAtkFull() {
        return atk + atkBuff;
    }

    public double calMatkFull() {
        return matk + matkBuff;
    }

    public double calDefFull() {
        return def + defBuff;
    }

    public double calHitFull() {
        return hit + hitBuff;
    }

    public double calCriFull() {
        return cri + criBuff;
    }

    public double calFleeFull() {
        return flee + fleeBuff;
    }

    public double calAspdFull() {
        return aspd + aspdBuff;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getFireLevel() {
        return fireLevel;
    }

    public void setFireLevel(int fireLevel) {
        this.fireLevel = fireLevel;
    }

    public int getHealLevel() {
        return healLevel;
    }

    public void setHealLevel(int healLevel) {
        this.healLevel = healLevel;
    }

    public int getBladeLevel() {
        return bladeLevel;
    }

    public void setBladeLevel(int bladeLevel) {
        this.bladeLevel = bladeLevel;
    }

    public int getBlessLevel() {
        return blessLevel;
    }

    public void setBlessLevel(int blessLevel) {
        this.blessLevel = blessLevel;
    }

    public int getCurseLevel() {
        return curseLevel;
    }

    public void setCurseLevel(int curseLevel) {
        this.curseLevel = curseLevel;
    }
}
