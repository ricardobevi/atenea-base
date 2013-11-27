package org.squadra.atenea.base.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.squadra.atenea.base.ResourcesActions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ListOfAction {

	private static HashMap<String, List<Click>> clicks ;
	private static HashMap<String, String> commands = new HashMap<String, String>();
	private static LinkedHashMap<String, PreloadAction> preloadActions= new LinkedHashMap<String, PreloadAction>();
	private static LinkedHashMap<String, PreloadAction> preloadActionsWithParam= new LinkedHashMap<String, PreloadAction>();
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
		return preloadActions.get(action);
	}
	
	public PreloadAction getPreLoadActionWithParam(String action)
	{
		
		for ( Map.Entry<String, PreloadAction> entry : preloadActionsWithParam.entrySet() ) 
		{
		    String preloadAction = entry.getKey().toLowerCase();
		    
		    int posInit = action.toLowerCase().indexOf( preloadAction );
			if (posInit != -1)
			{
		    	String param = action.substring(posInit + preloadAction.length()).trim();
		    	entry.getValue().setName(preloadAction);
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
		SearchInWiki searchInWiki = new SearchInWiki();
		SearchInYouTube searchInYouTube = new SearchInYouTube();
		Dictate dictate = new Dictate();
		SearchInGoogle searchInGoogle = new SearchInGoogle();
		
		preloadActionsWithParam.put("buscar google", searchInGoogle);
		preloadActionsWithParam.put("buscar internet", searchInGoogle);
		preloadActionsWithParam.put("comenzar dictado", dictate);
		preloadActionsWithParam.put("dictar",dictate);
		preloadActionsWithParam.put("buscar youtube video", searchInYouTube);
		preloadActionsWithParam.put("buscar video youtube", searchInYouTube);
		preloadActionsWithParam.put("buscar youtube", searchInYouTube);
		preloadActionsWithParam.put("buscar video",searchInYouTube);
		preloadActionsWithParam.put("buscar wikipedia", searchInWiki);
		preloadActionsWithParam.put("buscar enciclopedia", searchInWiki);
		preloadActionsWithParam.put("buscar wiki", searchInWiki );
		
		
		preloadActions.put("abrir facebook", new OpenFacebook());
		
		commands.put("abrir bloc nota", "notepad.exe");
		commands.put("cerrar bloc nota", "taskkill /IM notepad.exe");
		commands.put("abrir panel control", "control");
		commands.put("abrir administrador tarea", "taskmgr");
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
