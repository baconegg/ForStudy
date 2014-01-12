package org.edy.script;

import org.edy.script.common.Constans;
import org.edy.script.data.ScriptList;
import org.edy.script.input.Input_File;
import org.edy.script.output.Output_File;

public class Main
{

	public static void main(String[] args)
	{
		Input_File input = new Input_File();
		Output_File save = new Output_File();
		
		input.start(Constans.Path.getInputPathFileName_ORI());
		
		ScriptList script = input.getData();		
		//FontTable 저장
		save.saveFile(script.getFont_table_list(), Constans.Path.getOutputPathFileName_FontTable(), Constans.Cmd.getCMD_1());
		//Script 저장
		save.saveFile(script.getScript_list(), Constans.Path.getOutputPathFileName_Script(), Constans.Cmd.getCMD_0());
	}
}
