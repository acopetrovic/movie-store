# movie-store web app
Welcome to the documentation for our movie store built using Clojure! In this documentation, we will cover the various features of our movie store and how to use them.
The goal of this project is to make web application with CRUD operations.

The application uses Mustache logic-less templates for html pages, Clostache is Mustache for Clojure. Ring is used as a basic for this web application. It uses Compojure as routing library for Ring.
Application should allow a user to create a new actor, update, delete, and read all the actors from database. It should also allow for creation of a new producer and cinema, update, delete and read all producers and cinemas from database. It also this web application should read all movies from database. 

## User demo introduction

In this part i'm show you quick overview of this website.
<br>

This is the look of homepage card
[homepage1](homepage1.png),
[homepage2](homepage2.png),
[homepage3](homepage3.png), first here we have a scrolling panel, after it is a section opening this year and those are the movies that will be available this year, and finally we have a section subscribe to get newsletter where you can enter your email address, below it you can click and visit my GitHub account.<br>

The look of movies card is here
[movie](movies.png), in section available movies we have a scrolling panel that can be list on both side and here we read movies from our database, also exist option add to cart, when we pass the thought over a certain film, the information about it is printed as you can see in the picture [movie1](movies1.png).
Next two section is the same like homepage, subscribe and GitHub account.

Next three card are very similar. Right here is the look of that three card [actors](actor.png), [producers](producer.png), [cinemas](cinema.png). On card actors we have all actors from our database, in section "actions" we have two button `Edit` and `Delete` for update the existing one and deletiting it, below that has button add actor where we could insert new actor.
When we click the `edit` button it redirects us to the [update](actoru.png) page and when you click the `Add` button, we get a [form](form.png) for adding a new actor.
On card producers we have all producers from our database, the "actions" section is the same as on the actor page. Button `Edit` redirects us to [update](produceru.png) producer page and button `Add Producer` we get a [form](form.png) for adding new producer.
On card cinemas we have all cinemas from our database, the "actions" section is the same as on the actor page. Button `Edit` redirects us to [update](cinemau.png) cinema page and button `Add Cinema` we get a [form](form.png) for adding new cinema.
## Usage

To start the application, open the terminal and run: `lein run`.<br>
Also you need to import `database.sql` file. 

## Options

FIXME: listing of options this app accepts.

## Prerequisites

You will need <a href="https://leiningen.org">Leiningen</a> installed.

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
