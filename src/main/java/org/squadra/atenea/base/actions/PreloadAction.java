package org.squadra.atenea.base.actions;

public abstract class PreloadAction {
	protected String param;
	protected String name;
	
	public abstract void execute();
	
	public PreloadAction setParam(String action)
	{
		param = action;
		return this;
	}
	
	public String getParam() {
		return param;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
