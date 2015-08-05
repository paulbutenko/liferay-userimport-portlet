# Liferay user import portlet
Portlet for importing user to Liferay from csv file


As a source of user data for this application we will use CSV file with next format:
	
	username;email;firstName;lastName;password;male
	paul;paul@paul.com;Paul;Paul;paul;true
	ann;ann@ann.com;Ann;Ann;ann;false

First line is column names, we will need it while reading and transforming data

More info can be found [here](http://java-liferay.blogspot.com/2012/09/how-to-make-users-import-into-liferay.html).

