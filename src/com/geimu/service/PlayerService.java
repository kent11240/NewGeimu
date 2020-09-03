package com.geimu.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.geimu.domain.Enemy;
import com.geimu.domain.Player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerService {

    private final SkillService skillService = new SkillService();

    public void addPoint(Player player, String status, boolean bladeEnable, boolean blessEnable) {
        if (player.getPoints() <= 0) {
            return;
        }
        switch (status) {
            case "str":
                player.setStr(player.getStr() + 1);
                player.setAtk(player.getAtk() + 5.5);
                break;
            case "agi":
                player.setAgi(player.getAgi() + 1);
                player.setAspd(player.getAspd() + 1);
                player.setFlee(player.getFlee() + 15);
                player.setDef(player.getDef() + 1);
                break;
            case "vit":
                player.setVit(player.getVit() + 1);
                player.setHp(player.getHp() + 20);
                player.setHpMax(player.getHpMax() + 20);
                player.setDef(player.getDef() + 2.5);
                break;
            case "wis":
                player.setWis(player.getWis() + 1);
                player.setMp(player.getMp() + 10);
                player.setMpMax(player.getMpMax() + 10);
                player.setMatk(player.getMatk() + 3);
                break;
            case "dex":
                player.setDex(player.getDex() + 1);
                player.setHit(player.getHit() + 10);
                player.setFlee(player.getFlee() + 5);
                break;
            case "luk":
                player.setLuk(player.getLuk() + 1);
                player.setAtk(player.getAtk() + 3);
                player.setCri(player.getCri() + 11.5);
                break;
        }
        player.setPoints(player.getPoints() - 1);
    }

    public void addSkill(Player player, String skills) {
        if (player.getSkillPoints() <= 0) {
            return;
        }
        switch (skills) {
            case "fire":
                player.setFireLevel(player.getFireLevel() + 1);
                break;
            case "blade":
                player.setBladeLevel(player.getBladeLevel() + 1);
                break;
            case "heal":
                player.setHealLevel(player.getHealLevel() + 1);
                break;
            case "bless":
                player.setBlessLevel(player.getBlessLevel() + 1);
                break;
            case "curse":
                player.setCurseLevel(player.getCurseLevel() + 1);
                break;
        }
        player.setSkillPoints(player.getSkillPoints() - 1);
        skillService.calculateMp(player);
    }

    public void gainExp(Player player, Enemy enemy) {
        int exp = enemy.getExp();

        if (player.getLevel() > enemy.getLevel()) {
            exp = (int) Math.round(0.8 * exp);
        } else if (player.getLevel() < enemy.getLevel()) {
            exp = (int) Math.round(1.2 * exp);
        }

        enemy.setExp(exp);

        player.setExp(player.getExp() + enemy.getExp());
        while (player.getExp() >= player.getExpMax()) {
            levelUp(player);
        }
    }

    private void levelUp(Player player) {
        player.setLevel(player.getLevel() + 1);
        player.setPoints(player.getPoints() + 4);
        player.setSkillPoints(player.getSkillPoints() + 1);
        player.setExp(player.getExp() - player.getExpMax());
        player.setExpMax(player.getExpMax() + player.getLevel() * 30);
        player.setHpMax((int) (player.getHpMax() * 1.05 + 50));
        player.setMpMax((int) (player.getMpMax() * 1.025 + 10));
        player.setHp(player.getHpMax());
        player.setMp(player.getMpMax());
    }

    public void recoverMp(Player player) {
        if (player.getMp() < player.getMpMax()) {
            player.setMp(player.getMp() + player.getWis());
            if (player.getMp() > player.getMpMax()) {
                player.setMp(player.getMpMax());
            }
        }
    }

    public void savePlayer(Player player) {

        double atkBuff = player.getAtkBuff();
        double matkBuff = player.getMatkBuff();
        double defBuff = player.getDefBuff();
        double hitBuff = player.getHitBuff();
        double criBuff = player.getCriBuff();
        double fleeBuff = player.getFleeBuff();
        double aspdBuff = player.getAspdBuff();
        player.setAtkBuff(0);
        player.setMatkBuff(0);
        player.setDefBuff(0);
        player.setHitBuff(0);
        player.setCriBuff(0);
        player.setFleeBuff(0);
        player.setAspdBuff(0);

        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(player);
            json = AESService.Encrypt(json);

            try (PrintWriter writer = new PrintWriter("player.json", "UTF-8")) {
                writer.print(json);
                writer.flush();
            }
        } catch (Exception ex) {
            Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        player.setAtkBuff(atkBuff);
        player.setMatkBuff(matkBuff);
        player.setDefBuff(defBuff);
        player.setHitBuff(hitBuff);
        player.setCriBuff(criBuff);
        player.setFleeBuff(fleeBuff);
        player.setAspdBuff(aspdBuff);
    }

    public Player loadPlayer() {
        Player player = null;

        try {
            String json = "";

            try (BufferedReader br = new BufferedReader(new FileReader("player.json"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }

                json = AESService.Decrypt(sb.toString());
            }

            ObjectMapper mapper = new ObjectMapper();
            player = mapper.readValue(json, Player.class);
        } catch (Exception ex) {
            Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return player;
    }
}
