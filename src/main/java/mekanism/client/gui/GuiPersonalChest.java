package mekanism.client.gui;

import mekanism.client.gui.element.tab.GuiSecurityTab;
import mekanism.common.inventory.InventoryPersonalChest;
import mekanism.common.inventory.container.ContainerPersonalChest;
import mekanism.common.tile.TileEntityPersonalChest;
import mekanism.common.util.LangUtils;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPersonalChest extends GuiMekanismTile<TileEntityPersonalChest> {

    public GuiPersonalChest(InventoryPlayer inventory, TileEntityPersonalChest tile) {
        super(tile, new ContainerPersonalChest(inventory, tile));
        xSize += 26;
        ySize += 64;
        addGuiElement(new GuiSecurityTab(this, tileEntity, getGuiLocation()));
    }

    public GuiPersonalChest(InventoryPlayer inventory, InventoryPersonalChest inv) {
        super(null, new ContainerPersonalChest(inventory, inv));
        xSize += 26;
        ySize += 64;
        addGuiElement(new GuiSecurityTab(this, getGuiLocation(), inv.currentHand));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(LangUtils.localize("tile.MachineBlock.PersonalChest.name"), 8, 6, 0x404040);
        fontRenderer.drawString(LangUtils.localize("container.inventory"), 8, (ySize - 96) + 2, 0x404040);
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    protected ResourceLocation getGuiLocation() {
        return MekanismUtils.getResource(ResourceType.GUI, "GuiPersonalChest.png");
    }
}