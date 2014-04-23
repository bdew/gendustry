/*
 * Copyright (c) bdew, 2013 - 2014
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/gendustry/master/MMPL-1.0.txt
 */

package net.bdew.gendustry.machines.liquifier

import net.bdew.gendustry.Gendustry
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import net.bdew.lib.block.HasTE
import net.bdew.lib.tile.inventory.BreakableInventoryBlock
import net.bdew.gendustry.gui.BlockGuiWrenchable

object BlockLiquifier extends Block(Material.rock) with HasTE[TileLiquifier] with BreakableInventoryBlock with BlockGuiWrenchable {
  private var icons: Array[IIcon] = null
  val TEClass = classOf[TileLiquifier]
  lazy val guiId = MachineLiquifier.guiId

  setBlockName(Gendustry.modId + ".liquifier")
  setHardness(5)

  override def getIcon(side: Int, meta: Int): IIcon = {
    side match {
      case 0 =>
        return icons(0)
      case 1 =>
        return icons(1)
      case _ =>
        return icons(2)
    }
  }

  @SideOnly(Side.CLIENT)
  override def registerBlockIcons(reg: IIconRegister) {
    icons = new Array[IIcon](3)
    icons(0) = reg.registerIcon(Gendustry.modId + ":liquifier/bottom")
    icons(1) = reg.registerIcon(Gendustry.modId + ":liquifier/top")
    icons(2) = reg.registerIcon(Gendustry.modId + ":liquifier/side")
  }
}