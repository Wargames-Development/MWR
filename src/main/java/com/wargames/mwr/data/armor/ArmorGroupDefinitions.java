package com.wargames.mwr.data.armor;

import java.util.Set;

/**
 * Interface for supplying per-armor-group slot definitions.
 */
public interface ArmorGroupDefinitions {
    Set<String> getHelmetGroups();
    Set<String> getJacketGroups();
    Set<String> getLeftArmGroups();
    Set<String> getRightArmGroups();
    Set<String> getLeftLegGroups();
    Set<String> getRightLegGroups();
}