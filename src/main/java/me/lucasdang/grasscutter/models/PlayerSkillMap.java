package me.lucasdang.grasscutter.models;

import emu.grasscutter.game.avatar.Avatar;

public class PlayerSkillMap {
    private Avatar avatar;
    private Integer skillId;
    private Integer nou;

    public PlayerSkillMap(Avatar avatar, int skillId, int nou) {
        this.avatar = avatar;
        this.skillId = skillId;
        this.nou = nou;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getNou() {
        return nou;
    }

    public void setNou(Integer nou) {
        this.nou = nou;
    }
}
