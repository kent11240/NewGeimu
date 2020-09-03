package com.geimu.domain;

import com.geimu.service.BattleService;

public class Message {

    public static String MEET_MSG = "遭遇敵人！\n";
    public static String LOSE_MSG = "你已經死亡！\n";

    public static String BLADE_ENABLE_MSG = "你對武器注入了魔力!\n";
    public static String BLADE_DISABLE_MSG = "武器中的魔力已經散去\n";

    public static String BLESS_ENABLE_MSG = "受到天使的祝福，全能力提升!\n";
    public static String BLESS_DISABLE_MSG = "天使的祝福結束了\n";

    public static String CURSE_MSG = "敵人遭受了詛咒，能力值下降!\n";

    public static String NOT_AVAILABLE_SKILL = "無法使用技能\n";
    public static String NOT_ENOUGH_MP = "MP不足!\n";

    public static String SAVE_SUCCESS = "存檔成功\n";
    public static String LOAD_SUCCESS = "讀取成功\n";
    public static String LOAD_FAIL = "讀取失敗，沒有人物存檔\n";
    public static String NOT_AVAILABLE_SAVE = "戰鬥中無法存檔\n";
    
    public static String[] LOSE_ALERT = {"你已經死亡！確定後結束遊戲。","GAME OVER"};
    public static String[] LOAD_ALERT = {"開始戰鬥後即無法再讀取人物檔案，確定要以新角色開始？","提示"};

    public static String getPlayerDmgMsg(int dmg) {
        if (dmg == 0) {
            return "敵人躲開了你的攻擊\n";
        }
        if (BattleService.PLAYER_CRITICAL) {
            return "你對敵人爆擊造成" + dmg + "點傷害\n";
        } else {
            return "你對敵人造成" + dmg + "點傷害\n";
        }

    }

    public static String getEnemyDmgMsg(int dmg) {
        if (dmg == 0) {
            return "你躲開了敵人的攻擊\n";
        }
        if (BattleService.ENEMY_CRITICAL) {
            return "敵人對你爆擊造成" + dmg + "點傷害\n";
        } else {
            return "敵人對你造成" + dmg + "點傷害\n";
        }
    }

    public static String getFireDmgMsg(int fireDmg) {
        return "你使用火球術對敵人造成" + fireDmg + "點傷害\n";
    }

    public static String getHealMsg(int healAmount) {
        return "你對自己使用治癒術恢復了" + healAmount + "點血量\n";
    }

    public static String getWinMsg(int exp) {
        return "獲勝! Exp+" + exp + "\n";
    }
}
