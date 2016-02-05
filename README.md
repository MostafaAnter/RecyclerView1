# Work with RecyclerView


The RecyclerView widget is a more advanced and flexible version of ListView. This widget is a container for displaying large data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events



# issues when we use RecyclerView to replace ListView:

* There is no onItemClickListener() for list item selection - [solution](http://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener-and-how-recyclerview-is-dif)
* No divider between list items - [solution](http://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview)
* No built-in overlap selector, there is no visual feedback when you click list item - [solution](https://blog.stylingandroid.com/material-part-5/)
* No addHeaderView for list header - [solution](http://stackoverflow.com/questions/26530685/is-there-an-addheaderview-equivalent-for-recyclerview)


# steps
this steps just simple hint to use this project inside your project
- add recycler view dependency.
- Open content_main.xml and the recycler view widget.
- Open colors.xml located under res ⇒ values and copy colors inside it.
- create model class my model is Movie.java
- Create an layout xml named movie_list_row.xml
- Now create a class named MoviesAdapter.java
- use Butter Knife to find and automatically cast the corresponding view in your layout.
- Adding RecyclerView Divider / Separator
- Create a class named DividerItemDecoration.java 
- Adding RecyclerView Item Click Listener
- Open MainActivity.java and add the below RecyclerTouchListener class along with ClickListener interface.
- Finally add the recycler view item click listener


# ScreenShot
![alt tag](https://github.com/MostafaAnter/RecyclerView1/blob/master/device-2016-02-05-174500.png)

