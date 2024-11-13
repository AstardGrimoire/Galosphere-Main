package net.orcinus.galosphere.crafting;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.orcinus.galosphere.blocks.MonstrometerBlock;

public class MonstrometerDispenseItemBehavior extends OptionalDispenseItemBehavior {

    @Override
    protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos pos = blockSource.pos().relative(direction);
        Level world = blockSource.level();
        BlockState state = world.getBlockState(pos);

        setSuccess(false);

        if (state.getBlock() instanceof MonstrometerBlock && !MonstrometerBlock.isCharged(state)) {
            MonstrometerBlock.setCharged(state, world, pos);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
            setSuccess(true);
            itemStack.shrink(1);
        }

        return itemStack;
    }

}
