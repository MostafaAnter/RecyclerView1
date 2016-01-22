# Work with RecyclerView

-------------------------------------------------------
The RecyclerView widget is a more advanced and flexible version of ListView. This widget is a container for displaying large data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events
-------------------------------------------------------


# issues when we use RecyclerView to replace ListView:

There is no onItemClickListener() for list item selection - [solution](http://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener-and-how-recyclerview-is-dif)
No divider between list items - [solution](http://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview)
No built-in overlap selector, there is no visual feedback when you click list item - [solution](https://blog.stylingandroid.com/material-part-5/)
No addHeaderView for list header - [solution](http://stackoverflow.com/questions/26530685/is-there-an-addheaderview-equivalent-for-recyclerview)


# steps

