/**
 * @author Brandon Campbell
 * @version 1.0
 */
package com.springDeD.createPg.races;

public class DarkElf extends Elf
{
	private String[] subRacialBonus = {"Elf Weapon Training, Cantrip, Extra Language"};
	
	public DarkElf(String name, int strength, int dexterity, int constitution,
			int intelligence, int wisdom, int charisma) 
	{
		super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
	}
	
	public String[] getSubRacialBonus()
	{
		return subRacialBonus;
	}
}