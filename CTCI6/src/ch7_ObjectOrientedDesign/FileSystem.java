package ch7_ObjectOrientedDesign;

import java.util.HashMap;

public class FileSystem {

	public static void main (String args[])
	{
		
	}
}

class File{
	private String name;
	private String extension;
	private int size;
	private String content;
	
	public File(String name, String extension)
	{
		this.name = name;
		this.extension = extension;
	}
	
	public String getContent()
	{
		return this.content;
	}
	public void write(String content)
	{
		this.size = content.length() * 2;
		this.content += content;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void rename(String name)
	{
		this.name =name;
	}
	
	public String getExtension()
	{
		return this.extension;
	}
	public void changeExtension(String extension)
	{
		this.extension = extension;
	}
	
	
	public int getSize()
	{
		return this.size;
	}
	@Override
	public String toString()
	{
		return this.name + "." + this.extension;
	}

}

class Folder{
	
	private String name;
	private HashMap<String, Folder> folders;
	private HashMap<String, File> files;
	private Folder parent;
	
	/*public Folder(String name)
	{
		this.name = name;
		this.folders = new HashMap<String, Folder>();
		this.files = new HashMap<String, File>();
		this.parent = null;
	}
	*/
	public Folder(String name, Folder parent)
	{
		this.name = name;
		this.folders = new HashMap<String, Folder>();
		this.files = new HashMap<String, File>();
		this.parent = parent;
	}
	
	public boolean addFolder(Folder folder)
	{
		if(folders.get(folder) == null)
		{
			folders.put(folder.name, folder);
			return true;
		}
		return false;
	}
	
	public boolean addFile(File file)
	{
		if(files.get(file) == null)
		{
			files.put(file.toString(), file);
			return true;
		}
		return false;
	}
	
	public Folder getFolder(String folderName)
	{
		return folders.get(folderName);
	}
	
	public File getFile(String name, String extension)
	{
		return files.get(name+ "." +extension);
	}
	
	public String getName()
	{
		return this.name;
	}
		
	public void rename(String name)
	{
		parent.folders.put(name, parent.folders.remove(this.name));
		this.name = name;
	}
	
	public Folder getParent()
	{
		return this.parent;
	}
	
	public void setParent(Folder parent)
	{
		this.parent = parent;
	}
	
	public boolean deleteFolder(String  name) 
	{
		if(folders.containsKey(name))
		{
			delete(folders.get(name));
			folders.remove(name);
			return true;
		}
		return false;
	}
	
	private boolean delete(Folder folder)
	{
		if(folder.files.size() != 0)
		{
			for(File file : folder.files.values())
			{
				file = null;
			}
			folder.files.clear();
		}
		if(folder.folders.size() == 0)
			return true;
		for(Folder f : folder.folders.values())
		{
			delete(folder);
			f = null;
		}
		
		folder.folders.clear();
		folder = null;
		return true;
	}
	
}
