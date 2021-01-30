package com.amadornes.rscircuits;

import com.amadornes.rscircuits.content.block.circuit.CircuitEntityRenderer;
import com.amadornes.rscircuits.content.block.circuit.CircuitTileEntity;
import com.amadornes.rscircuits.registrate.SCMRegistrate;
import com.tterrag.registrate.builders.TileEntityBuilder;
import com.tterrag.registrate.util.entry.TileEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class AllTileEntites {
    private static final SCMRegistrate REGISTRATE = SCM.registrate().itemGroup(() -> SCM.createTab);

    public static final TileEntityEntry<CircuitTileEntity> CIRCUIT_TILE_ENTITY = REGISTRATE
            .object("circuit_tile_entity")
            .tileEntity(CircuitTileEntity::new)
            .validBlock(AllBlocks.CIRCUIT)
            .register();

    @OnlyIn(value = Dist.CLIENT)
    public static void registerRenderers() {
        //RenderTypeLookup.setRenderLayer(StartupCommon.blockMBE21, RenderType.getCutoutMipped());
        //MinecraftForge.EVENT_BUS.register(AnimationTickCounter.class);  // counts ticks, used for animation

        ClientRegistry.bindTileEntityRenderer(AllTileEntites.CIRCUIT_TILE_ENTITY.get(), CircuitEntityRenderer::new);
    }

    public static void register() {}
}