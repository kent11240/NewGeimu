package com.geimu.service;

import com.geimu.domain.Enemy;
import com.geimu.domain.Player;

public class SkillService {

    public static int FIRE_COOL_DOWN = 5 * 1000;
    public static int FIRE_MP = 10;

    public static int BLADE_TIME = 40 * 1000;
    public static int BLADE_COOL_DOWN = 15 * 1000;
    public static int BLADE_MP = 50;
    private static double BLADE_ATK_BUFF = 0;

    public static int HEAL_COOL_DOWN = 10 * 1000;
    public static int HEAL_MP = 25;

    public static int BLESS_TIME = 30 * 1000;
    public static int BLESS_COOL_DOWN = 15 * 1000;
    public static int BLESS_MP = 30;
    private static double BLESS_ATK_BUFF = 0;
    private static double BLESS_MATK_BUFF = 0;
    private static double BLESS_DEF_BUFF = 0;
    private static double BLESS_HIT_BUFF = 0;
    private static double BLESS_CRI_BUFF = 0;
    private static double BLESS_FLEE_BUFF = 0;

    public static int CURSE_COOL_DOWN = 40 * 1000;
    public static int CURSE_MP = 30;

    public int useFire(Player player, Enemy enemy) {
        player.setMp(player.getMp() - FIRE_MP);

        int fireDmg;
        fireDmg = (int) Math.round((40 + (player.getFireLevel() - 1) * 20 + 0.6 * player.calMatkFull() * (1 + 0.5 * (player.getFireLevel() - 1)) + 0.4 * player.calMatkFull()) * (Math.random() * 0.1 + 0.95));

        if (enemy.getHp() > fireDmg) {
            enemy.setHp(enemy.getHp() - fireDmg);
        } else {
            enemy.setHp(0);
        }

        return fireDmg;
    }

    public void enableBlade(Player player) {
        player.setMp(player.getMp() - BLADE_MP);
        BLADE_ATK_BUFF = (1 + 0.4 * player.getBladeLevel()) * player.getMatk();
        player.setAtkBuff(player.getAtkBuff() + BLADE_ATK_BUFF);
    }

    public void disableBlade(Player player) {
        player.setAtkBuff(player.getAtkBuff() - BLADE_ATK_BUFF);
    }

    public int useHeal(Player player) {
        player.setMp(player.getMp() - HEAL_MP);

        int healAmount;
        healAmount = (int) Math.round((30 + (player.getHealLevel() - 1) * 30 + 0.6 * player.calMatkFull() * (1 + 0.5 * (player.getHealLevel() - 1)) + 0.4 * player.calMatkFull()) * (Math.random() * 0.1 + 0.95));

        if (player.getHp() + healAmount > player.getHpMax()) {
            player.setHp(player.getHpMax());
        } else {
            player.setHp(player.getHp() + healAmount);
        }

        return healAmount;
    }

    public void enableBless(Player player) {
        player.setMp(player.getMp() - BLESS_MP);
        BLESS_ATK_BUFF = player.getAtk() * (1 + 0.1 * player.getBlessLevel());
        BLESS_MATK_BUFF = player.getMatk() * (1 + 0.1 * player.getBlessLevel());
        BLESS_DEF_BUFF = player.getDef() * (1 + 0.085 * player.getBlessLevel());
        BLESS_HIT_BUFF = player.getHit() * (1 + 0.1 * player.getBlessLevel());
        BLESS_CRI_BUFF = player.getCri() * (1 + 0.1 * player.getBlessLevel());
        BLESS_FLEE_BUFF = player.getFlee() * (1 + 0.1 * player.getBlessLevel());
        player.setAtkBuff(player.getAtkBuff() + BLESS_ATK_BUFF);
        player.setMatkBuff(player.getMatkBuff() + BLESS_MATK_BUFF);
        player.setDefBuff(player.getDefBuff() + BLESS_DEF_BUFF);
        player.setHitBuff(player.getHitBuff() + BLESS_HIT_BUFF);
        player.setCriBuff(player.getCriBuff() + BLESS_CRI_BUFF);
        player.setFleeBuff(player.getFleeBuff() + BLESS_FLEE_BUFF);
    }

    public void disableBless(Player player) {
        player.setAtkBuff(player.getAtkBuff() - BLESS_ATK_BUFF);
        player.setMatkBuff(player.getMatkBuff() - BLESS_MATK_BUFF);
        player.setDefBuff(player.getDefBuff() - BLESS_DEF_BUFF);
        player.setHitBuff(player.getHitBuff() - BLESS_HIT_BUFF);
        player.setCriBuff(player.getCriBuff() - BLESS_CRI_BUFF);
        player.setFleeBuff(player.getFleeBuff() - BLESS_FLEE_BUFF);
    }

    public void useCurse(Player player, Enemy enemy) {
        player.setMp(player.getMp() - CURSE_MP);

        enemy.setAtk(enemy.getAtk() * (1 - 0.08 * player.getCurseLevel()));
        enemy.setDef(enemy.getDef() * (1 - 0.08 * player.getCurseLevel()));
        enemy.setHit(enemy.getHit() * (1 - 0.08 * player.getCurseLevel()));
        enemy.setCri(enemy.getCri() * (1 - 0.08 * player.getCurseLevel()));
        enemy.setFlee(enemy.getFlee() * (1 - 0.08 * player.getCurseLevel()));

        if (enemy.getAtk() <= 0) {
            enemy.setAtk(1);
        }
        if (enemy.getDef() <= 0) {
            enemy.setDef(1);
        }
        if (enemy.getHit() <= 0) {
            enemy.setHit(1);
        }
        if (enemy.getCri() <= 0) {
            enemy.setCri(1);
        }
        if (enemy.getFlee() <= 0) {
            enemy.setFlee(1);
        }
    }

    public void calculateMp(Player player) {
        switch (player.getFireLevel()) {
            case 0:
            case 1:
                FIRE_MP = 10;
                break;
            default:
                FIRE_MP = 10 + (player.getFireLevel() - 1) * 10;
        }
        switch (player.getBladeLevel()) {
            case 0:
            case 1:
                BLADE_MP = 50;
                break;
            default:
                BLADE_MP = 50 + (player.getBladeLevel() - 1) * 10;
        }
        switch (player.getHealLevel()) {
            case 0:
            case 1:
                HEAL_MP = 25;
                break;
            default:
                HEAL_MP = 25 + (player.getHealLevel() - 1) * 5;
        }
        switch (player.getBlessLevel()) {
            case 0:
            case 1:
                BLESS_MP = 30;
                break;
            default:
                BLESS_MP = 30 + (player.getBlessLevel() - 1) * 10;
        }
        switch (player.getCurseLevel()) {
            case 0:
            case 1:
                CURSE_MP = 30;
                break;
            default:
                CURSE_MP = 30 + (player.getCurseLevel() - 1) * 5;
        }
    }
}
