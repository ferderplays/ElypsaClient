package net.ferderplays.elypsa.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/* this is a test to see just how good ChatGPT is */
public class ItemUtil {
    public static ItemStack getItemsFromInventory(EntityPlayer player, Item item, int amount) {
        ItemStack resultStack = ItemStack.EMPTY;

        // Loop through the player's inventory
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);

            // Check if the item in the slot matches the desired item
            if (!stackInSlot.isEmpty() && stackInSlot.getItem() == item) {
                // Calculate how many items to take from the stack
                int itemsToTake = Math.min(amount, stackInSlot.getCount());

                // Create a new ItemStack with the taken items
                ItemStack takenItems = new ItemStack(item, itemsToTake);

                // Decrease the count in the slot
                stackInSlot.shrink(itemsToTake);

                // Update the player's inventory
                player.inventory.setInventorySlotContents(i, stackInSlot);

                // Return the taken items
                return takenItems;
            }
        }

        return resultStack;
    }
}
