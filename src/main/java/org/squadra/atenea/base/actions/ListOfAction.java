package org.squadra.atenea.base.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.squadra.atenea.base.ResourcesActions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ListOfAction {

	private static HashMap<String, List<Click>> clicks ;
	private static HashMap<String, String> commands = new HashMap<String, String>();
	private static HashMap<String, PreloadAction> preloadActions= new HashMap<String, PreloadAction>();
	private static ListOfAction INSTANCE = null;


	public boolean removeAction(String actionName)
	{
		return clicks.remove(actionName) != null;
	}
	
	public void addAction(String actionName, List<Click> listOfClicks)
	{
		clicks.put(actionName, listOfClicks);
	}
	
	/***
	 * Devuelve un objeto PreloadAction con el parametro a ejecutar cargado
	 * @param action "Buscar en internet el color del caballo blanco de San Martin"
	 * @return
	 */
	public PreloadAction getPreLoadAction(String action)
	{
		
		for (Map.Entry<String, PreloadAction> entry : preloadActions.entrySet()) 
		{
		    String preloadAction = entry.getKey();
		    int posInit = action.toLowerCase().indexOf(preloadAction);
			if (posInit != -1)
			{
		    	String param = action.substring(posInit + preloadAction.length()).trim();
		    	// param == "el color del caballo blanco de San Martin"
		    	return entry.getValue().setParam(param);
			}
		}
		return null;
	}

	public List<Click> getAction(String actionName) {
		return clicks.get(actionName);
	}
	
	public String getCommand(String command) {
		return commands.get(command);
	}

	//Agregar acciones precargadas aca!!
	private void fillPreloadActions()
	{
		preloadActions.put("buscar en google", new SearchInGoogle());
		preloadActions.put("buscar en internet", new SearchInGoogle());
		preloadActions.put("abrir facebook", new OpenFacebook());
		preloadActions.put("comenzar dictado", new Dictate());

	}
	
	private void loadActionsAndCommandsFromFiles()
	{
		File archivo = new File(ResourcesActions.Actions.actions_file);

		FileReader fr = null;
		BufferedReader br = null;
		try {
			Gson gson = new GsonBuilder().create();
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			clicks = gson.fromJson(br,  new TypeToken<HashMap<String, List<Click>>>(){}.getType());
			if (clicks == null)
				clicks = new HashMap<String, List<Click>>();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		BufferedReader br2 = null;
		try{
			br2 = new BufferedReader(new FileReader(ResourcesActions.Actions.commands_file));
			String line;
			while ((line = br2.readLine()) != null) {
				String a[] = line.split(",");
				commands.put(a[0], a[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			try {
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ListOfAction() {
		
		fillPreloadActions();
		
		ResourcesActions.buildPaths();
		
		loadActionsAndCommandsFromFiles();
		
	}

	private static ListOfAction createInstance()	
	{
		if (INSTANCE == null)
		{
			INSTANCE = new ListOfAction();
		}
		return INSTANCE;
	}

	public static ListOfAction getInstance()
	{
		return createInstance();		
	}

	public void writeToFile()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter writer = new FileWriter(ResourcesActions.Actions.actions_file);
			writer.write(gson.toJson(clicks));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}