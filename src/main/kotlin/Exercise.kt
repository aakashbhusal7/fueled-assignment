import data.Comment
import data.Post
import data.User
import resources.Data

/**
# Fueled Kotlin Exercise
A blogging platform stores the following information that is available through separate API endpoints:
+ user accounts
+ blog posts for each user
+ comments for each blog post
### Objective
The organization needs to identify the 3 most engaging bloggers on the platform. Using only Kotlin and the Kotlin standard library, output the top 3 users with the highest average number of comments per post in the following format:
`[name]` - `[id]`, Score: `[average_comments]`
Instead of connecting to a remote API, we are providing this data in form of JSON files, which have been made accessible through a custom Resource enum with a `data` method that provides the contents of the file.
### What we're looking to evaluate
1. How you choose to model your data
2. How you transform the provided JSON data to your data model
3. How you use your models to calculate this average value
4. How you use this data point to sort the users
 */



fun main(vararg args: String) {
    val commentList = Data.getComments<List<Comment>>()
    val userList = Data.getUsers<List<User>>()
    val postList = Data.getPosts<List<Post>>()

    val commentNumber: HashMap<Int, Int> = HashMap()

}