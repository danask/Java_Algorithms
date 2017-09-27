package ask.design.intermediate;

import java.util.ArrayList;



// Entry
abstract class Entry
{
	protected Directory parent;
	protected long createdTime;
	protected long lastUpdatedTime;
	protected long lastAccessedTime;
	protected String name;
	
	public Entry(String name, Directory parent)
	{
		this.name = name;
		this.parent = parent;
		
		createdTime = System.currentTimeMillis();
		lastUpdatedTime = System.currentTimeMillis();
		lastAccessedTime = System.currentTimeMillis();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean delete()
	{
		if(parent == null)
			return false;
		
		return parent.deleteEntry(this);
	}
	

	public String getFullPath()
	{
		if(parent == null)
			return name;
		else
			return parent.getFullPath() + "/"+ name;
		
	}
	
	// S/Getters...
	public String getName()
	{
		return name;
	}
	
	public abstract int getSize();  // it depends on logic(file, dir)
	
	public long getCreationTime()
	{
		return this.createdTime;
	}
	public long getLastUpdatedTime()
	{
		return this.createdTime;
	}
	public long getLastAccessedTime()
	{
		return this.createdTime;
	}	
}

// FILE
class File extends Entry  
{
	private String content;
	private int size;
	
	// C
	public File(String n, Directory p, int size)
	{
		super(n, p);
		this.size = size;
	}
	
	// S/Getters...
	// all of variables from Entry should be defined in File	
	public int getSize()
	{
		return size;
	}
	
	// C/U
	public void setContents(String content)
	{
		this.content = content;
	}
	
	// R
	public String getContents()
	{
		return this.content;
	}
}


// DIR
class Directory extends Entry  
{
	protected ArrayList<Entry> contents;
	
	// C(Create)
	public Directory(String n, Directory p)
	{
		super(n, p);
		contents = new ArrayList<>();
	}
	
	// S/Getters...
	
	// U(Update)
	public void addEntry(Entry e)
	{
		contents.add(e);
	}	
	// R(Read)
	protected ArrayList<Entry> getContents()
	{
		return contents;
	}	
	// D(DEL)
	public boolean deleteEntry(Entry e)
	{
		return contents.remove(e);  // array
	}
	
	
	// all of variables from Entry should be defined in File	
	public int getSize()
	{
		int size = 0;
		for(Entry e : contents)
		{
			size += e.getSize();
		}
		return size;
	}
	
	public int numberOfFiles()
	{
		int count = 0;
		
		for(Entry e : contents)
		{
			if(e instanceof Directory)
			{
				count++;
				Directory d = (Directory) e;
				count += d.numberOfFiles();
			}
			else if(e instanceof File)
			{
				count++;
			}
		}
		return count;
	}
}







public class InMemoryFileSystem 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Directory root = new Directory("Food", null);
		File taco = new File("Taco", root, 4);
		File hamburger = new File("Hamburger", root, 9);
		root.addEntry(taco);  // 1
		root.addEntry(hamburger);  // 1
		
		Directory healthy = new Directory("Healthy", root);
	
		Directory fruits = new Directory("Fruits", healthy);
		File apple = new File("Apple", fruits, 5);
		File banana = new File("Banana", fruits, 6);
		fruits.addEntry(apple);
		fruits.addEntry(banana);
			
		healthy.addEntry(fruits);  // 2
			
		Directory veggies = new Directory("Veggies", healthy);
		File carrot = new File("Carrot", veggies, 6);
		File lettuce = new File("Lettuce", veggies, 7);
		File peas = new File("Peas", veggies, 4);
		veggies.addEntry(carrot);
		veggies.addEntry(lettuce);
		veggies.addEntry(peas);
		
		healthy.addEntry(veggies);  // 2
		
		root.addEntry(healthy);  // 1
		
		System.out.println("# of file : " + root.numberOfFiles());

		System.out.println(hamburger.getFullPath() + ", " + root.getSize());	
		
		System.out.println(fruits.getFullPath() + ", " + fruits.getSize());
		System.out.println(veggies.getFullPath() + ", " + veggies.getSize());
		
		System.out.println(banana.getFullPath() + ", " + banana.getSize());		
		System.out.println(lettuce.getFullPath() + ", " + lettuce.getSize());		

		// [{root {taco, hamburger,{healthy {fruits, veggies}}}}]
	}

}
