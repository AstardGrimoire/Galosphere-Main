package net.orcinus.galosphere.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.criterion.GCriterion;
import net.orcinus.galosphere.init.GBlocks;
import net.orcinus.galosphere.init.GCriteriaTriggers;
import net.orcinus.galosphere.init.GEntityTypes;
import net.orcinus.galosphere.init.GItems;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class GAdvancementsProvider extends FabricAdvancementProvider {

    public GAdvancementsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        this.generateAdventures(consumer, registryLookup);
        this.generateHusbandry(consumer);
    }

    private void generateHusbandry(Consumer<AdvancementHolder> consumer) {
        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("husbandry/plant_seed"))
                .display(
                        GItems.LUMIERE_SHARD,
                        Component.translatable("advancements.galosphere.lumiere_compost.title"),
                        Component.translatable("advancements.galosphere.lumiere_compost.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "lumiere_compost",
                        GCriteriaTriggers.LUMIERE_COMPOST.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("husbandry/lumiere_compost").toString());
    }

    private void generateAdventures(Consumer<AdvancementHolder> consumer, HolderLookup.Provider provider) {
        Advancement.Builder.advancement()
                .parent(Galosphere.id("adventure/find_pink_salt_shrine"))
                .display(
                        GBlocks.PINK_SALT_CHAMBER,
                        Component.translatable("advancements.galosphere.activate_pink_salt_chamber.title"),
                        Component.translatable("advancements.galosphere.activate_pink_salt_chamber.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "activate_pink_salt_chamber",
                        GCriteriaTriggers.ACTIVATE_PINK_SALT_CHAMBER.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/activate_pink_salt_chamber").toString());

        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
                .display(
                        GBlocks.AMETHYST_LAMP,
                        Component.translatable("advancements.galosphere.crystal_lamps.title"),
                        Component.translatable("advancements.galosphere.crystal_lamps.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "crystal_lamps",
                        InventoryChangeTrigger.TriggerInstance.hasItems(GBlocks.ALLURITE_LAMP, GBlocks.LUMIERE_LAMP, GBlocks.AMETHYST_LAMP)
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/crystal_lamps").toString());

//            Advancement.Builder.advancement()
//                    .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
//                    .display(
//                            GBlocks.PINK_SALT_BRICKS,
//                            Component.translatable("advancements.galosphere.find_pink_salt_shrine.title"),
//                            Component.translatable("advancements.galosphere.find_pink_salt_shrine.description"),
//                            null,
//                            AdvancementType.TASK,
//                            true,
//                            true,
//                            false
//                    )
//                    .addCriterion(
//                            "pink_salt_shrine",
//                            PlayerTrigger.TriggerInstance.located(
//                                    LocationPredicate.Builder.inStructure(provider.lookupOrThrow(Registries.STRUCTURE).getOrThrow(GStructures.PINK_SALT_SHRINE))
//                            )
//                    )
//                    .requirements(AdvancementRequirements.Strategy.AND)
//                    .save(consumer, Galosphere.id("adventure/find_pink_salt_shrine"));

        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
                .display(
                        GItems.GLOW_FLARE,
                        Component.translatable("advancements.galosphere.light_spread.title"),
                        Component.translatable("advancements.galosphere.light_spread.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "light_spread",
                        GCriteriaTriggers.LIGHT_SPREAD.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/light_spread").toString());

        Advancement.Builder.advancement()
                .parent(Galosphere.id("adventure/silver_ingot"))
                .display(
                        GItems.SILVER_BOMB,
                        Component.translatable("advancements.galosphere.silver_bomb.title"),
                        Component.translatable("advancements.galosphere.silver_bomb.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "silver_bomb",
                        InventoryChangeTrigger.TriggerInstance.hasItems(GItems.SILVER_BOMB)
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/silver_bomb").toString());

        Advancement.Builder.advancement()
                .parent(Galosphere.id("adventure/silver_ingot"))
                .display(
                        GItems.STERLING_HELMET,
                        Component.translatable("advancements.galosphere.sterling_armor.title"),
                        Component.translatable("advancements.galosphere.sterling_armor.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "sterling_armor",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                GItems.STERLING_HELMET,
                                GItems.STERLING_CHESTPLATE,
                                GItems.STERLING_LEGGINGS,
                                GItems.STERLING_BOOTS
                        )
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/sterling_armor").toString());

        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
                .display(
                        GItems.PRESERVED_FLESH,
                        Component.translatable("advancements.galosphere.summon_berserker.title"),
                        Component.translatable("advancements.galosphere.summon_berserker.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "summoned",
                        SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(GEntityTypes.BERSERKER))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/summon_berserker").toString());

        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
                .display(
                        GItems.SPECTRE_FLARE,
                        Component.translatable("advancements.galosphere.use_spectre_flare.title"),
                        Component.translatable("advancements.galosphere.use_spectre_flare.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "use_spectre_flare",
                        GCriteriaTriggers.USE_SPECTRE_FLARE.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/use_spectre_flare").toString());

        Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("adventure/root"))
                .display(
                        GItems.SPECTRE_BOUND_SPYGLASS,
                        Component.translatable("advancements.galosphere.use_spectre_spyglass.title"),
                        Component.translatable("advancements.galosphere.use_spectre_spyglass.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "use_spectre_spyglass",
                        GCriteriaTriggers.USE_SPECTRE_SPYGLASS.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/use_spectre_spyglass").toString());

        Advancement.Builder.advancement()
                .parent(Galosphere.id("adventure/silver_ingot"))
                .display(
                        Items.ENDER_PEARL,
                        Component.translatable("advancements.galosphere.warped_teleport.title"),
                        Component.translatable("advancements.galosphere.warped_teleport.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "warped_teleport",
                        GCriteriaTriggers.WARPED_TELEPORT.createCriterion(new GCriterion.TriggerInstance(Optional.empty()))
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, Galosphere.id("adventure/warped_teleport").toString());
    }

}
