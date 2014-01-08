package org.edy.script.data;

import java.util.ArrayList;
import java.util.List;

public class ScriptList {

	List<String> result_Script_List = new ArrayList<String>();
	List<String> result_Font_Table_List = new ArrayList<String>();

	// /////////////////////////////////////////////////////////
	public void add_ScriptList(String script) {
		result_Script_List.add(script);
	}

	public void add_FontTableList(String fontTable) {
		result_Font_Table_List.add(fontTable);
	}
	// ////////////////////////////////////////////////////////

	public List<String> getScript_list() {
		return result_Script_List;
	}

	public void setScript_list(List<String> script_list) {
		this.result_Script_List = script_list;
	}

	public List<String> getFont_table_list() {
		return result_Font_Table_List;
	}

	public void setFont_table_list(List<String> font_table_list) {
		this.result_Font_Table_List = font_table_list;
	}

	@Override
	public String toString() {
		return "ScriptList [script_list=" + result_Script_List + ", font_table_list="
				+ result_Font_Table_List + "]";
	}
	
}
