package com.wargames.mwr.data.armor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MarineOBJGroups implements ArmorGroupDefinitions {

    @Override
    public Set<String> getHelmetGroups() {
        return new HashSet<>(Arrays.asList(
                "head", "bone", "bone_1", "bone_2", "bone16", "bone2", "bone2_1", "bone2_2",
                "bone14", "bone14_1", "bone10", "bone18", "bone15", "bone15_1", "bone3",
                "bone5", "bone11", "bone12", "bone12_1", "bone13", "bone13_1", "bone4",
                "bone4_1", "bone4_2", "bone8", "bone8_1", "bone8_2", "bone8_3",
                "bone9", "bone9_1", "bone9_2"
        ));
    }

    @Override
    public Set<String> getJacketGroups() {
        return new HashSet<>(Arrays.asList(
                "jacket1", "jacket2", "jacket3", "jacket4", "jacket5", "jacket6", "jacket7", "bipedBody"
        ));
    }

    @Override
    public Set<String> getLeftArmGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedLeftArm", "leftarm1", "leftarm1_1", "leftarm2", "leftarm2_1", "leftarm3",
                "leftarm4", "leftarm5", "leftarm5_1", "leftarm5_2", "leftarm5_3", "leftarm5_4",
                "leftarm5_5", "leftarm5_6", "leftarm5_7", "leftarm5_8", "leftarm6", "leftarm6_1",
                "leftarm7"
        ));
    }

    @Override
    public Set<String> getRightArmGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedRightArm", "rightarm1", "rightarm1_1", "rightarm1_2", "rightarm1_3", "rightarm1_4",
                "rightarm1_5", "rightarm1_6", "rightarm1_7", "rightarm1_8", "rightarm1_9", "rightarm2",
                "rightarm3", "rightarm4", "rightarm5", "rightarm6", "rightarm6_1", "rightarm7"
        ));
    }

    @Override
    public Set<String> getLeftLegGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedLeftLeg", "leftleg1", "leftleg2", "leftleg3", "leftleg4", "leftleg4_1",
                "leftleg4_2", "leftleg4_3", "leftleg4_4", "leftleg4_5", "leftleg4_6", "leftleg5"
        ));
    }

    @Override
    public Set<String> getRightLegGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedRightLeg", "rightleg1", "rightleg1_1", "rightleg1_2", "rightleg1_3", "rightleg1_4",
                "rightleg1_5", "rightleg1_6", "rightleg2", "rightleg3", "rightleg3_1", "rightleg4"
        ));
    }
}