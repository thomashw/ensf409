public class Demo {
public void lab2_tests()
{
LookupTable lt = new LookupTable();
if (lt.size() != 0){
System.out.println("\nError: Incorrect size \n");
System.exit(1);
}
System.out.println("\nPrinting table just after its creation...\n");
print(lt);
// Insert using new keys.
Product a = new Product ("Video Card", 2, 11, 1998, 33);
Product b = new Product ("Controller", 22, 10, 2008, 93);
Product c = new Product ("RAM", 31, 9, 2007, 3);
Product d = new Product ("Monitor", 2, 11, 1998, 83);
lt.insert(12355,a);
lt.insert(12345,b);
lt.insert(12363,c); 
lt.insert(22290,d);
if(lt.size() != 4){
System.out.println("\nError Incorrect size.\n");
System.exit(1);
}
System.out.println("\nPrinting table after inserting 4 new keys...\n");
print(lt);
// Insert using existing keys. .
Product e = new Product ("USB adaptor", 30, 8, 2000, 12);
Product f = new Product ("Mouse", 29, 8, 2001, 11);
lt.insert(12355,e);
lt.insert(22290,f);
if(lt.size() != 4){
System.out.println ( "\nError: Incorrect size.\n");
System.exit(1);
}
System.out.println ( "\nPrinting table after changing data for 2 keys ...\n");
print(lt);
// Try removal.
lt.remove(12363);
lt.remove(22222);
if (lt.size() != 3){
System.out.println( "\nError: Incorrect size. \n");
System.exit(1);
}
System.out.println( "\nPrinting table after two remove operations ...\n");
print(lt);
System.out.println ("\nLet's look up some product names ..\n");
try_to_find(lt, 12345);
try_to_find(lt, 22290);
try_to_find(lt, 12355);
try_to_find(lt, 12366);  
// Wipe out the entries in the table.
lt.destroy();
System.out.println("\nPrinting table for the last time ...\n");
print(lt);
System.out.println ( "***----Finished Lab 2 tests----------------***\n\n");
}
void print(LookupTable lt)
{
if (lt.is_empty())
System.out.println( "  Table is EMPTY.\n");
for (lt.go_to_first(); lt.cursor_ok(); lt.step_fwd()) {
System.out.println(lt);
}
}
void try_to_find(LookupTable lt, int key)
{
lt.find(key);
if (lt.cursor_ok())
System.out.println ("Found: " + lt );
else
System.out.println("  Sorry, I couldn't find key: " +  key + 
" in the table.\n");
}
public static void main(String [] args)
{
Demo d = new Demo();
d.lab2_tests();
} // end of main
}  // end of class Demo