# EasyPasswordManager
EasyPasswordManager is a simple program that helps you store all your credentials locally.

It uses a SQLite database which is embedded directly in the jar file, so you can simply move/copy the executable from one pc to another (with JVM installed) and keep your credentials.

Keep in mind that EasyPasswordManager doesn't aim to be an "ultra safe" tool, all your credentials are protected by a single master Password, so if someone who uses your pc knows it he can see all your data.
<br/>Also someone who is familiar with SQLite can, with a little bit of work, access your data without using the application (I don't tell you how to do it obviously).

REGISTRATION:<br/>
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Registration.png)

LOGIN:<br/>
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Login.png)

MAIN WINDOW:<br/>
On the left side of the window you can add new credentials
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Adding%20Credentials.png)

On the right side you can select and view all your data
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Selecting%20Credentials.png)
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Viewing%20Credentials.png)

You can remove credentials
![alt text](https://github.com/daddi99/EasyPasswordManager/blob/main/Sample%20Images/Removing%20Credentials.png)
