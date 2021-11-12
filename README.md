# BRCM
Bronco Recreation Complex Management system by Team 03 for CS 5800. The aim is to convert the current recreation complex system into an automated one. 

# Backend
# Initializing DB
1. Open PGADMIN tool right click on databases and click create. A window will pop up give it a database name I named my brcm_db (keep note of it if yours is different) then select an owner. Leave default setting for all other tabs and click save.  

2. Right click the newly created database and select query tool. A blank Query Editor text pad will appear.

3. Open the brcm_db_initialization.sql file in the resources folder copy the contents from that file and paste it into the query tool and hit the execute button then hit the save data changes button.

# Setting Up Hibernate
1. Right click project folder, select configure build path then under the Java Build Path window select the libraries tab. Click on classpath and click add library.

2. Then click Add Library. 

3. Select User Library from the next menu and click next.

4.  Click the User Libraries... Button on the next page.

5. On the next window click New... A window will appear with an input box type in Hibernate. 

6. Next highlight the newly created library and click the option of Add External JARs... 

7. Navigate to the build folder and under the hibernatejar folder select all jars and add them to the newly created library.

8. Click apply and close and that window will close you will see the add user library window with the library you just created selected clich finish.

9. Then click apply and close.

# Seeding Data
