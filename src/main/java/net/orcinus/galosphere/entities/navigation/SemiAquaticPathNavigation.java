package net.orcinus.galosphere.entities.navigation;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.PathType;

public class SemiAquaticPathNavigation extends AmphibiousPathNavigation {

    public SemiAquaticPathNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    @Override
    public boolean canCutCorner(PathType pathType) {
        return pathType != PathType.WATER_BORDER && super.canCutCorner(pathType);
    }

    @Override
    protected PathFinder createPathFinder(int i) {
        this.nodeEvaluator = new SemiAquaticNodeEvaluator(true);
        this.nodeEvaluator.setCanPassDoors(true);
        return new PathFinder(this.nodeEvaluator, i);
    }

    static class SemiAquaticNodeEvaluator extends AmphibiousNodeEvaluator {

        public SemiAquaticNodeEvaluator(boolean bl) {
            super(bl);
        }

        @Override
        public Node getStart() {
            return this.getStartNode(new BlockPos(Mth.floor(this.mob.getBoundingBox().minX), Mth.floor(this.mob.getBoundingBox().minY), Mth.floor(this.mob.getBoundingBox().minZ)));
        }

    }

}
