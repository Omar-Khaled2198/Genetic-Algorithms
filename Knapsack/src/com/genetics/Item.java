package com.genetics;

public class Item{

    private int weight;
    private int benefit;

	
    public Item(int weight,int benefit){
        this.weight=weight;
        this.benefit=benefit;
    }
    
    public int getWeight()
	{
		return this.weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

    public int getBenefit()
	{
		return this.benefit;
	}

	public void setBenefit(int benefit)
	{
		this.benefit = benefit;
	}
    

}