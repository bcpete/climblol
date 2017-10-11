<h3>Live @ https://climblol.herokuapp.com/</h3>

<h3>==========About==========</h3>

<p>Built with Java, using SpringBoot, Gradle, and a Mysql database on the backed. On the front end it uses HTML, CSS, and BootStrap</p>

<h3>==========Routes==========</h3>
<p> /home - landing page explanation of the site and links to the other pages</p>
<p> /register - make a new profile, redirects to your profile if you put in valid data.</p>
<p> /users - lists all the profiles that aren't coaches. Shows main champions, role, and ranking.</p>
<p> /coaches - list of all users that are coaches. Shows main champions, role, and ranking.</p>
<p> /{username} - profile page for whatever username you pass in shows user/coach data. </p>

<h3>==========Installation==========</h3>
<p>Just clone the repository, and add in an application.properties file with a link to a database and you'll be good to go! You'll have to populate the database for champions, and the roles otherwise you won't have any options show up in the dropdowns.</p>
