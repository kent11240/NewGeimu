package com.geimu.service;

import com.geimu.domain.Enemy;
import com.geimu.domain.Player;

public class BattleService {

    public static boolean PLAYER_CRITICAL = false;
    public static boolean PLAYER_HIT = true;

    public static boolean ENEMY_CRITICAL = false;
    public static boolean ENEMY_HIT = true;

    public int getPlayerDamage(Player player, Enemy enemy) {
        int dmg;
        isPlayerCritical(player);
        isPlayerHit(player, enemy);
        if (!PLAYER_HIT) {
            return 0;
        }
        if (PLAYER_CRITICAL) {
            dmg = (int) Math.round((player.calAtkFull() * 1.7 * (Math.random() * 0.1 + 0.95)));
        } else {
            dmg = (int) Math.round((player.calAtkFull() * (Math.random() * 0.2 + 0.9)));
        }

        if (!PLAYER_CRITICAL) {
            dmg = dmg - (int) Math.round(enemy.getDef());
        } else {
            dmg = dmg - (int) Math.round(enemy.getDef() * 0.5);
        }

        if (dmg <= 1) {
            dmg = 1;
        }

        return dmg;
    }

    private void isPlayerCritical(Player player) {
        PLAYER_CRITICAL = Math.random() * 100 < 1.3 * Math.sqrt(2.6 * player.calCriFull());
    }

    private void isPlayerHit(Player player, Enemy enemy) {
        PLAYER_HIT = Math.random() * 100 < (1.4 * Math.sqrt(2.6 * player.calHitFull()) + 50) - (0.685 * Math.sqrt(0.85 * enemy.getFlee()));
    }

    public int getEnemyDamage(Enemy enemy, Player player) {
        int dmg;

        isEnemyCritical(enemy);
        isEnemyHit(player, enemy);
        if (!ENEMY_HIT) {
            return 0;
        }
        if (ENEMY_CRITICAL) {
            dmg = (int) Math.round((enemy.getAtk() * 1.7 * (Math.random() * 0.1 + 0.95)));
        } else {
            dmg = (int) Math.round((enemy.getAtk() * (Math.random() * 0.1 + 0.95)));
        }

        if (!ENEMY_CRITICAL) {
            dmg = dmg - (int) Math.round(player.calDefFull());
        } else {
            dmg = dmg - (int) Math.round(player.calDefFull() * 0.5);
        }

        if (dmg <= 1) {
            dmg = 1;
        }

        return dmg;
    }

    private void isEnemyCritical(Enemy enemy) {
        ENEMY_CRITICAL = Math.random() * 100 < 1.5 * Math.sqrt(2.25 * enemy.getCri());
    }

    private void isEnemyHit(Player player, Enemy enemy) {
        ENEMY_HIT = Math.random() * 100 < (1.4 * Math.sqrt(2.5 * enemy.getHit()) + 50) - (1.3 * Math.sqrt(1.6 * player.calFleeFull()));
    }

    public int getPlayerAttackRate(Player player) {
        int rate = 2000;

        rate = (int) Math.round(rate - (33 * Math.sqrt(20 * player.calAspdFull())));

        return rate;
    }

    public int getEnemyAttackRate(Enemy enemy) {
        int rate = 2000;

        rate = (int) Math.round(rate - (33 * Math.sqrt(20 * enemy.getAspd())));

        return rate;
    }

    public boolean playerAttack(Enemy enemy, int playerDmg) {
        enemy.setHp(enemy.getHp() - playerDmg);
        if (enemy.getHp() <= 0) {
            enemy.setHp(0);
            return true;
        }
        return false;
    }

    public boolean enemyAttack(Player player, int playerDmg) {
        player.setHp(player.getHp() - playerDmg);
        if (player.getHp() <= 0) {
            player.setHp(0);
            return true;
        }
        return false;
    }
}
