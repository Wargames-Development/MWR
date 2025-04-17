package com.wargames.mwr.data.armor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MarineOBJGroups implements ArmorGroupDefinitions {

    @Override
    public Set<String> getHelmetGroups() {
        return new HashSet<>(Arrays.asList(
                "head", "bone", "bone_000", "bone_001", "bone16", "bone2", "bone2_000", "bone2_001",
                "bone14", "bone14_000", "bone10", "bone18", "bone15", "bone15_000", "bone3",
                "bone5", "bone11", "bone12", "bone12_000", "bone13", "bone13_000", "bone4",
                "bone4_000", "bone4_001", "bone8", "bone8_000", "bone8_001", "bone8_002",
                "bone9", "bone9_000", "bone9_001"
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
                "bipedLeftArm", "leftarm1", "leftarm1_000", "leftarm2", "leftarm2_000", "leftarm3",
                "leftarm4", "leftarm5", "leftarm5_000", "leftarm5_001", "leftarm5_002", "leftarm5_003",
                "leftarm5_004", "leftarm5_005", "leftarm5_006", "leftarm5_007", "leftarm6", "leftarm6_000",
                "leftarm7"
        ));
    }

    @Override
    public Set<String> getRightArmGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedRightArm", "rightarm1", "rightarm1_000", "rightarm1_001", "rightarm1_002", "rightarm1_003",
                "rightarm1_004", "rightarm1_005", "rightarm1_006", "rightarm1_007", "rightarm1_008", "rightarm2",
                "rightarm3", "rightarm4", "rightarm5", "rightarm6", "rightarm6_000", "rightarm7"
        ));
    }

    @Override
    public Set<String> getLeftLegGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedLeftLeg", "leftleg1", "leftleg2", "leftleg3", "leftleg4", "leftleg4_000",
                "leftleg4_001", "leftleg4_002", "leftleg4_003", "leftleg4_004", "leftleg4_005", "leftleg5"
        ));
    }

    @Override
    public Set<String> getRightLegGroups() {
        return new HashSet<>(Arrays.asList(
                "bipedRightLeg", "rightleg1", "rightleg1_000", "rightleg1_001", "rightleg1_002", "rightleg1_003",
                "rightleg1_004", "rightleg1_005", "rightleg2", "rightleg3", "rightleg3_000", "rightleg4"
        ));
    }
}