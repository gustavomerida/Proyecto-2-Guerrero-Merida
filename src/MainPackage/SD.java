/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import AuxClass.List;
import AuxClass.Node;
import MainClasses.App;

/**
 *
 * @author Angelo
 */
public class SD {

    private int LimitBlocks;
    private List<Block> BlocksList;

    public SD(int LimitBlocks, List<Block> BlocksList) {
        this.LimitBlocks = LimitBlocks;
        this.BlocksList = BlocksList;
    }

    public int getLimitBlocks() {
        return LimitBlocks;
    }

    public void setLimitBlocks(int LimitBlocks) {
        this.LimitBlocks = LimitBlocks;
    }

    public List<Block> getBlocksList() {
        return BlocksList;
    }

    public void setBlocksList(List<Block> BlocksList) {
        this.BlocksList = BlocksList;
    }

}
